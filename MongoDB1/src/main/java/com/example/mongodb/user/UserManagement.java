package com.example.mongodb.user;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class UserManagement {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取用户集合
            MongoCollection<Document> userCollection = database.getCollection("users");

            // 添加用户
            addUser(userCollection, 1, "john_doe", "john@example.com");

            // 查询用户
            findUser(userCollection, "john_doe");

            // 更新用户
            updateUser(userCollection, "john_doe", "new_email@example.com");

            // 删除用户
            deleteUser(userCollection, "john_doe");
        }
    }

    // 添加用户
    private static void addUser(MongoCollection<Document> collection, int userId, String username, String email) {
        Document userDocument = new Document("user_id", userId)
                .append("username", username)
                .append("email", email);
        collection.insertOne(userDocument);
        System.out.println("User added: " + userDocument);
    }

    // 查询用户
    private static void findUser(MongoCollection<Document> collection, String username) {
        Document query = new Document("username", username);
        Document userResult = collection.find(query).first();
        System.out.println("User found: " + userResult);
    }

    // 更新用户
    private static void updateUser(MongoCollection<Document> collection, String username, String newEmail) {
        Document query = new Document("username", username);
        Document updateDocument = new Document("$set", new Document("email", newEmail));
        collection.updateOne(query, updateDocument);
        System.out.println("User updated: " + query);
    }

    // 删除用户
    private static void deleteUser(MongoCollection<Document> collection, String username) {
        Document query = new Document("username", username);
        collection.deleteOne(query);
        System.out.println("User deleted: " + query);
    }
}
