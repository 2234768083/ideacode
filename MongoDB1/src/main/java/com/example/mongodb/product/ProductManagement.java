package com.example.mongodb.product;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ProductManagement {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取商品集合
            MongoCollection<Document> productCollection = database.getCollection("products");

            // 添加商品
            addProduct(productCollection, 101, "Laptop", 999.99, "Powerful laptop for your needs");

            // 查询商品
            findProduct(productCollection, 101);

            // 更新商品信息
            updateProduct(productCollection, 101, 1099.99);

            // 删除商品
            deleteProduct(productCollection, 101);
        }
    }

    // 添加商品
    private static void addProduct(MongoCollection<Document> collection, int productId, String name, double price, String description) {
        Document productDocument = new Document("product_id", productId)
                .append("name", name)
                .append("price", price)
                .append("description", description);
        collection.insertOne(productDocument);
        System.out.println("Product added: " + productDocument);
    }

    // 查询商品
    private static void findProduct(MongoCollection<Document> collection, int productId) {
        Document query = new Document("product_id", productId);
        Document productResult = collection.find(query).first();
        System.out.println("Product found: " + productResult);
    }

    // 更新商品信息
    private static void updateProduct(MongoCollection<Document> collection, int productId, double newPrice) {
        Document query = new Document("product_id", productId);
        Document updateDocument = new Document("$set", new Document("price", newPrice));
        collection.updateOne(query, updateDocument);
        System.out.println("Product updated: " + query);
    }

    // 删除商品
    private static void deleteProduct(MongoCollection<Document> collection, int productId) {
        Document query = new Document("product_id", productId);
        collection.deleteOne(query);
        System.out.println("Product deleted: " + query);
    }
}
