package com.example.mongodb.user;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class UserExtension {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取用户扩展信息集合
            MongoCollection<Document> userExtensionCollection = database.getCollection("user_extensions");

            // 添加用户扩展信息
            addUserExtension(userExtensionCollection, 1, "John Doe", "Male", "30");

            // 查询用户扩展信息
            findUserExtension(userExtensionCollection, 1);

            // 更新用户扩展信息
            updateUserExtension(userExtensionCollection, 1, "John Doe", "Male", "31");

            // 删除用户扩展信息
            deleteUserExtension(userExtensionCollection, 1);
        }
    }

    // 添加用户扩展信息
    private static void addUserExtension(MongoCollection<Document> collection, int userId, String fullName, String gender, String age) {
        Document userExtensionDocument = new Document("user_id", userId)
                .append("full_name", fullName)
                .append("gender", gender)
                .append("age", age);
        collection.insertOne(userExtensionDocument);
        System.out.println("User extension added: " + userExtensionDocument);
    }

    // 查询用户扩展信息
    private static void findUserExtension(MongoCollection<Document> collection, int userId) {
        Document query = new Document("user_id", userId);
        Document userExtensionResult = collection.find(query).first();
        System.out.println("User extension found: " + userExtensionResult);
    }

    // 更新用户扩展信息
    private static void updateUserExtension(MongoCollection<Document> collection, int userId, String fullName, String gender, String newAge) {
        Document query = new Document("user_id", userId);
        Document updateDocument = new Document("$set", new Document("full_name", fullName).append("gender", gender).append("age", newAge));
        collection.updateOne(query, updateDocument);
        System.out.println("User extension updated: " + query);
    }

    // 删除用户扩展信息
    private static void deleteUserExtension(MongoCollection<Document> collection, int userId) {
        Document query = new Document("user_id", userId);
        collection.deleteOne(query);
        System.out.println("User extension deleted: " + query);
    }
}

