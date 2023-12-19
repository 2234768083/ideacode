package com.example.mongodb.click;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ClickCount {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取点击量集合
            MongoCollection<Document> clickCollection = database.getCollection("click_counts");

            // 增加点击量（示例：增加商品101的点击量）
            increaseClickCount(clickCollection, 101);

            // 查询点击量
            findClickCount(clickCollection, 101);
        }
    }

    // 增加点击量
    private static void increaseClickCount(MongoCollection<Document> collection, int productId) {
        Document query = new Document("product_id", productId);
        Document updateDocument = new Document("$inc", new Document("clicks", 1));
        collection.updateOne(query, updateDocument);
        System.out.println("Click count increased for product " + productId);
    }

    // 查询点击量
    private static void findClickCount(MongoCollection<Document> collection, int productId) {
        Document query = new Document("product_id", productId);
        Document clickResult = collection.find(query).first();
        System.out.println("Click count for product " + productId + ": " + clickResult);
    }
}
