package com.example.mongodb.user;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Objects;

public class UserAuthentication {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取用户集合
            MongoCollection<Document> userCollection = database.getCollection("users");

            // 用户登录
            User user = login(userCollection, "john_doe", "password123");

            if (user != null) {
                System.out.println("User logged in: " + user);
            } else {
                System.out.println("Login failed. Invalid credentials.");
            }
        }
    }

    // 用户登录
    private static User login(MongoCollection<Document> collection, String username, String password) {
        Document query = new Document("username", username)
                .append("password", password);

        Document userDocument = collection.find(query).first();

        if (userDocument != null) {
            return new User(
                    userDocument.getInteger("user_id"),
                    userDocument.getString("username"),
                    userDocument.getString("email")
            );
        }

        return null;
    }

    // 用户类
    private static class User {
        private final int userId;
        private final String username;
        private final String email;

        public User(int userId, String username, String email) {
            this.userId = userId;
            this.username = username;
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userId=" + userId +
                    ", username='" + username + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}
