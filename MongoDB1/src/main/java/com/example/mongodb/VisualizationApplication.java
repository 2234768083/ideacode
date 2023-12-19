package com.example.mongodb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class VisualizationApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Click Count Visualization");

        // 创建横轴和纵轴
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Day");
        yAxis.setLabel("Click Count");

        // 创建折线图
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Click Count Trend");

        // 创建数据系列
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Product 101");

        // 添加示例数据（实际应从数据库中获取）
        series.getData().add(new XYChart.Data<>(1, 50));
        series.getData().add(new XYChart.Data<>(2, 65));
        series.getData().add(new XYChart.Data<>(3, 80));
        series.getData().add(new XYChart.Data<>(4, 45));

        // 将数据系列添加到图表
        lineChart.getData().add(series);

        // 创建场景
        Scene scene = new Scene(lineChart, 800, 600);

        // 设置舞台
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
