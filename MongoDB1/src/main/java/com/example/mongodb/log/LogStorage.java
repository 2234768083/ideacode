package com.example.mongodb.log;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogStorage {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取日志集合
            MongoCollection<Document> logCollection = database.getCollection("logs");

            // 记录日志
            log(logCollection, "User john_doe logged in.");

            // 查询日志
            findLogs(logCollection);
        }
    }

    // 记录日志
    private static void log(MongoCollection<Document> collection, String logMessage) {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = timestamp.format(formatter);

        Document logDocument = new Document("timestamp", formattedTimestamp)
                .append("log_message", logMessage);
        collection.insertOne(logDocument);
        System.out.println("Log recorded: " + logDocument);
    }

    // 查询日志
    private static void findLogs(MongoCollection<Document> collection) {
        for (Document log : collection.find()) {
            System.out.println("Log entry: " + log);
        }
    }
}
