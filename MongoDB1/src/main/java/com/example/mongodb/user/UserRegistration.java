package com.example.mongodb.user;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class UserRegistration {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("mall");

            // 获取用户集合
            MongoCollection<Document> userCollection = database.getCollection("users");

            // 用户注册
            boolean registrationSuccessful = registerUser(userCollection, "new_user", "password456", "new_user@example.com");

            if (registrationSuccessful) {
                System.out.println("User registered successfully.");
            } else {
                System.out.println("Registration failed. Username or email already exists.");
            }
        }
    }

    // 用户注册
    private static boolean registerUser(MongoCollection<Document> collection, String username, String password, String email) {
        // 检查用户名和邮箱是否已存在
        Document existingUserQuery = new Document("username", username);

        long existingUserCount = collection.countDocuments(existingUserQuery);

        if (existingUserCount > 0) {
            return false; // 用户名或邮箱已存在，注册失败
        }

        // 用户注册
        Document newUser = new Document("username", username)
                .append("password", password)
                .append("email", email);

        collection.insertOne(newUser);

        return true; // 注册成功
    }
}
