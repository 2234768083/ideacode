/*
 * Copyright (c) JiaChaoYang 2023-7-27 MongoPlus版权所有
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * email: j15030047216@163.com
 * phone: 15030047216
 * weChat: JiaChaoYang_
 */

package com.anwen.mongoa;

import com.anwen.mongo.config.MongoPlusAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description:
 * @BelongsProject: mongo-plus-demo
 * @BelongsPackage: com.anwen.mongo
 * @Author: JiaChaoYang
 * @CreateTime: 2023-02-26 16:48
 * @Version: 1.0
 */
@SpringBootApplication
@Slf4j
@Import(MongoPlusAutoConfiguration.class)
@EnableAsync
public class MongoPlusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoPlusDemoApplication.class, args);
        log.info("启动成功，访问：http://127.0.0.1:9527/mongo-plus/doc.html");
    }

}
