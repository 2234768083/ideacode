package com.example.mongodb.order;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Arrays;

public class OrderHistory {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取历史订单集合
            MongoCollection<Document> historyCollection = database.getCollection("order_history");

            // 将订单从订单集合移至历史订单集合（示例：将订单号为301的订单移至历史订单）
            moveOrderToHistory(database.getCollection("orders"), historyCollection, 301);

            // 查询历史订单
            findOrderInHistory(historyCollection, 301);
        }
    }

    // 将订单从订单集合移至历史订单集合
    private static void moveOrderToHistory(MongoCollection<Document> orderCollection, MongoCollection<Document> historyCollection, int orderId) {
        Document query = new Document("order_id", orderId);
        Document orderDocument = orderCollection.find(query).first();

        if (orderDocument != null) {
            // 将订单插入历史订单集合
            historyCollection.insertOne(orderDocument);

            // 删除订单集合中的订单
            orderCollection.deleteOne(query);

            System.out.println("Order moved to history: " + orderDocument);
        } else {
            System.out.println("Order not found in the order collection.");
        }
    }

    // 查询历史订单
    private static void findOrderInHistory(MongoCollection<Document> collection, int orderId) {
        Document query = new Document("order_id", orderId);
        Document orderResult = collection.find(query).first();
        System.out.println("Order found in history: " + orderResult);
    }
}
