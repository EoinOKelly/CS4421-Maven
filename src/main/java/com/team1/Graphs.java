package com.team1;  // Ensure this matches your actual package structure

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Graphs extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create Pie Chart
        PieChart pieChart = new PieChart();
        PieChart.Data slice1 = new PieChart.Data("Category A", 30);
        PieChart.Data slice2 = new PieChart.Data("Category B", 25);
        PieChart.Data slice3 = new PieChart.Data("Category C", 45);
        pieChart.getData().addAll(slice1, slice2, slice3);

        // Create Bar Chart
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Category");
        yAxis.setLabel("Value");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        XYChart.Series<String, Number> barSeries = new XYChart.Series<>();
        barSeries.setName("Data Values");
        barSeries.getData().add(new XYChart.Data<>("Category A", 30));
        barSeries.getData().add(new XYChart.Data<>("Category B", 25));
        barSeries.getData().add(new XYChart.Data<>("Category C", 45));

        barChart.getData().add(barSeries);

        // Create Line Chart
        NumberAxis lineXAxis = new NumberAxis();
        NumberAxis lineYAxis = new NumberAxis();
        lineXAxis.setLabel("X Values");
        lineYAxis.setLabel("Y Values");

        LineChart<Number, Number> lineChart = new LineChart<>(lineXAxis, lineYAxis);
        XYChart.Series<Number, Number> lineSeries = new XYChart.Series<>();
        lineSeries.setName("Trend Line");
        lineSeries.getData().add(new XYChart.Data<>(1, 23));
        lineSeries.getData().add(new XYChart.Data<>(2, 14));
        lineSeries.getData().add(new XYChart.Data<>(3, 15));
        lineSeries.getData().add(new XYChart.Data<>(4, 24));
        lineSeries.getData().add(new XYChart.Data<>(5, 34));

        lineChart.getData().add(lineSeries);

        // Layout: Arrange the charts in a vertical layout (VBox)
        VBox vbox = new VBox(10);  // 10px spacing between the charts
        vbox.getChildren().addAll(pieChart, barChart, lineChart);

        // Set up the scene and stage
        Scene scene = new Scene(vbox, 800, 800);  // Adjust width and height as needed
        primaryStage.setTitle("Multiple Chart Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // This starts the JavaFX application
    }
}
