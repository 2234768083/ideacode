package com.example.mongodb.cart;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Arrays;

public class ShoppingCart {
    public static void main(String[] args) {
        // 连接到 MongoDB 服务器
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // 选择数据库
            MongoDatabase database = mongoClient.getDatabase("your_database_name");

            // 获取购物车集合
            MongoCollection<Document> cartCollection = database.getCollection("shopping_carts");

            // 用户1将商品101和102添加到购物车
            addToCart(cartCollection, 1, Arrays.asList(101, 102));

            // 查询用户1的购物车
            viewCart(cartCollection, 1);

            // 用户1修改购物车中商品101的数量
            updateCartItemQuantity(cartCollection, 1, 101, 3);

            // 查询用户1的购物车
            viewCart(cartCollection, 1);

            // 用户1从购物车中移除商品102
            removeFromCart(cartCollection, 1, 102);

            // 查询用户1的购物车
            viewCart(cartCollection, 1);
        }
    }

    // 将商品添加到购物车
    private static void addToCart(MongoCollection<Document> collection, int userId, Iterable<Integer> productIds) {
        Document cartDocument = new Document("user_id", userId)
                .append("products", productIds);
        collection.insertOne(cartDocument);
        System.out.println("Items added to cart for user " + userId);
    }

    // 查看购物车
    private static void viewCart(MongoCollection<Document> collection, int userId) {
        Document query = new Document("user_id", userId);
        Document cartResult = collection.find(query).first();
        System.out.println("Shopping Cart for user " + userId + ": " + cartResult);
    }

    // 更新购物车中商品的数量
    private static void updateCartItemQuantity(MongoCollection<Document> collection, int userId, int productId, int quantity) {
        Document query = new Document("user_id", userId);
        Document updateDocument = new Document("$set", new Document("products." + productId, quantity));
        collection.updateOne(query, updateDocument);
        System.out.println("Item quantity updated in cart for user " + userId);
    }

    // 从购物车中移除商品
    private static void removeFromCart(MongoCollection<Document> collection, int userId, int productId) {
        Document query = new Document("user_id", userId);
        Document updateDocument = new Document("$pull", new Document("products", productId));
        collection.updateOne(query, updateDocument);
        System.out.println("Item removed from cart for user " + userId);
    }
}
