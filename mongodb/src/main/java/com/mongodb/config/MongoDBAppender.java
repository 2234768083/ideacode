package com.mongodb.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.bson.Document;

import java.util.Date;

/**
 * MongoDB适配文档输出内容定义
 * 用于将日志事件写入MongoDB的自定义Appender。
 */
public class MongoDBAppender extends MongoDBAppenderBase<ILoggingEvent> {

    /**
     * 构造函数，初始化MongoDB集合名称。
     */
    public MongoDBAppender() {
        // 调用基类构造函数，设置MongoDB集合名称为"logdbs"
        super("logdbs");
    }

    /**
     * 将日志事件转换为MongoDB文档。
     *
     * @param eventObject 要转换的日志事件。
     * @return 表示日志事件的MongoDB文档。
     */
    @Override
    protected Document toMongoDocument(ILoggingEvent eventObject) {
        // 创建一个新的Document用于存储日志信息
        final Document doc = new Document();

        // 使用当前日期记录日志条目
        doc.append("date", new Date());

        // 将来源、级别、日志记录器、线程和消息添加到文档中
        doc.append("source", source);
        doc.append("level", eventObject.getLevel().toString());
        doc.append("logger", eventObject.getLoggerName());
        doc.append("thread", eventObject.getThreadName());
        doc.append("message", eventObject.getFormattedMessage());

        // 如果存在MDC属性，则添加到文档中
        if (eventObject.getMDCPropertyMap() != null && !eventObject.getMDCPropertyMap().isEmpty())
            doc.append("mdc", eventObject.getMDCPropertyMap());

        return doc;
    }
}
