package com.example.mongodb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Database Application");

        // 创建按钮和文本区域
        Button addButton = new Button("Add User");
        Button findButton = new Button("Find User");
        TextArea resultArea = new TextArea();

        // 设置按钮点击事件
        addButton.setOnAction(event -> {
            // 调用添加用户的数据库操作方法
            // 这里需要根据实际情况调用相关的数据库操作方法
            resultArea.appendText("Add User clicked\n");
        });

        findButton.setOnAction(event -> {
            // 调用查询用户的数据库操作方法
            // 这里需要根据实际情况调用相关的数据库操作方法
            resultArea.appendText("Find User clicked\n");
        });

        // 创建布局
        VBox layout = new VBox(10);
        layout.getChildren().addAll(addButton, findButton, resultArea);

        // 创建场景
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

