package com.example.mongodb.product;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ProductReview {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取商品评价集合
            MongoCollection<Document> reviewCollection = database.getCollection("product_reviews");

            // 添加商品评价
            addProductReview(reviewCollection, 201, 101, 1, "Not satisfied with the product");

            // 查询商品评价
            findProductReview(reviewCollection, 201);

            // 更新商品评价
            updateProductReview(reviewCollection, 201, 2, "Okay, but could be better");

            // 删除商品评价
            deleteProductReview(reviewCollection, 201);
        }
    }

    // 添加商品评价
    private static void addProductReview(MongoCollection<Document> collection, int reviewId, int productId, int rating, String comment) {
        Document reviewDocument = new Document("review_id", reviewId)
                .append("product_id", productId)
                .append("rating", rating)
                .append("comment", comment);
        collection.insertOne(reviewDocument);
        System.out.println("Product review added: " + reviewDocument);
    }

    // 查询商品评价
    private static void findProductReview(MongoCollection<Document> collection, int reviewId) {
        Document query = new Document("review_id", reviewId);
        Document reviewResult = collection.find(query).first();
        System.out.println("Product review found: " + reviewResult);
    }

    // 更新商品评价
    private static void updateProductReview(MongoCollection<Document> collection, int reviewId, int newRating, String newComment) {
        Document query = new Document("review_id", reviewId);
        Document updateDocument = new Document("$set", new Document("rating", newRating).append("comment", newComment));
        collection.updateOne(query, updateDocument);
        System.out.println("Product review updated: " + query);
    }

    // 删除商品评价
    private static void deleteProductReview(MongoCollection<Document> collection, int reviewId) {
        Document query = new Document("review_id", reviewId);
        collection.deleteOne(query);
        System.out.println("Product review deleted: " + query);
    }
}
