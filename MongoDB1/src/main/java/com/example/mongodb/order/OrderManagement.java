package com.example.mongodb.order;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Arrays;

public class OrderManagement {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取订单集合
            MongoCollection<Document> orderCollection = database.getCollection("orders");

            // 添加订单
            addOrder(orderCollection, 301, 1, Arrays.asList(101, 102), 1999.98, "processing");

            // 查询订单
            findOrder(orderCollection, 301);

            // 更新订单状态
            updateOrderStatus(orderCollection, 301, "shipped");

            // 删除订单
            deleteOrder(orderCollection, 301);
        }
    }

    // 添加订单
    private static void addOrder(MongoCollection<Document> collection, int orderId, int userId, Iterable<Integer> productIds, double totalAmount, String status) {
        Document orderDocument = new Document("order_id", orderId)
                .append("user_id", userId)
                .append("products", productIds)
                .append("total_amount", totalAmount)
                .append("status", status);
        collection.insertOne(orderDocument);
        System.out.println("Order added: " + orderDocument);
    }

    // 查询订单
    private static void findOrder(MongoCollection<Document> collection, int orderId) {
        Document query = new Document("order_id", orderId);
        Document orderResult = collection.find(query).first();
        System.out.println("Order found: " + orderResult);
    }

    // 更新订单状态
    private static void updateOrderStatus(MongoCollection<Document> collection, int orderId, String newStatus) {
        Document query = new Document("order_id", orderId);
        Document updateDocument = new Document("$set", new Document("status", newStatus));
        collection.updateOne(query, updateDocument);
        System.out.println("Order status updated: " + query);
    }

    // 删除订单
    private static void deleteOrder(MongoCollection<Document> collection, int orderId) {
        Document query = new Document("order_id", orderId);
        collection.deleteOne(query);
        System.out.println("Order deleted: " + query);
    }
}
