package com.mongodb.config;

import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;

/**
 * MongoDB适配Appender基类
 * 用于将日志事件写入MongoDB的基础功能实现。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class MongoDBAppenderBase<E> extends UnsynchronizedAppenderBase<E> {

    // MongoDB连接相关配置
    protected String source;
    private MongoClient mongo;
    private MongoCollection<Document> eventsCollection;
    private String host = "127.0.0.1"; // MongoDB地址
    private int port = 27017;           // MongoDB端口号
    private String dbName = "springboot";       // MongoDB数据库名
    private String collectionName;      // MongoDB集合名
    private int connectionsPerHost = 10000; // 空闲线程池中最大连接数
    private int threadsAllowedToBlockForConnectionMultiplier = 5000; // 一个线程等待连接可用的最大等待毫秒数
    private int maxWaitTime = 1000 * 60 * 2;  // 最长等待时间
    private int connectTimeout;
    private int socketTimeout;
    private int wtimeout;

    // 构造函数，设置集合名
    MongoDBAppenderBase(String collectionName) {
        this.collectionName = collectionName;
    }

    // 启动方法
    @Override
    public void start() {
        super.start();
    }

    // 构建MongoDB连接选项
    private MongoClientOptions buildOptions() {
        final MongoClientOptions.Builder options = new MongoClientOptions.Builder();
        options.connectionsPerHost(connectionsPerHost);
        options.threadsAllowedToBlockForConnectionMultiplier(threadsAllowedToBlockForConnectionMultiplier);
        options.maxWaitTime(maxWaitTime);
        options.connectTimeout(connectTimeout);
        options.socketTimeout(socketTimeout);
        options.maxWaitTime(wtimeout);
        return options.build();
    }

    // 抽象方法，将日志事件转换为MongoDB文档
    protected abstract Document toMongoDocument(E event);

    // 实现父类的append方法，将文档插入MongoDB集合
    @Override
    protected void append(E eventObject) {
        eventsCollection.insertOne(toMongoDocument(eventObject));
    }

    // 停止方法，关闭MongoDB连接
    @Override
    public void stop() {
        if (mongo != null)
            mongo.close();
        super.stop();
    }
}
