package com.mongodb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class MongodbApplication {

    /**
     * 主函数，应用程序的入口点。
     *
     * @param args 命令行参数
     * @throws UnknownHostException 无法解析主机名
     */
    public static void main(String[] args) throws UnknownHostException {
        // 创建可配置的应用程序上下文
        ConfigurableApplicationContext application = SpringApplication.run(MongodbApplication.class, args);
        // 获取环境对象
        Environment env = application.getEnvironment();
        // 获取服务器端口号
        String port = env.getProperty("server.port");
        // 获取服务器servlet上下文路径
        String path1 = env.getProperty("server.servlet.context-path");
        path1 = "system.html";

        // 打印应用启动信息
        log.info("应用启动成功:\n\t" +
                "前台界面: \t\thttp://localhost:" + port + "\n\t" +
                "后台界面: \t\thttp://localhost:" + port + "/" + path1 + "\n\t" );
    }
}
