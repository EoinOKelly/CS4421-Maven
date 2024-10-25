/*package com.team1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.util.Util;

public class Graphs extends Application {

    @Override
    public void start(Stage primaryStage) {
        // OSHI System Information
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        // Simulating CPU Usage
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(1000);  // Give it a second to calculate load
        long[] ticks = processor.getSystemCpuLoadTicks();
        double cpuUsage = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100;

        // Memory Information
        long totalMemory = memory.getTotal();
        long availableMemory = memory.getAvailable();
        double usedMemory = ((double) (totalMemory - availableMemory) / totalMemory) * 100;

        // Create Pie Chart with CPU and Memory Info
        PieChart pieChart = new PieChart();
        PieChart.Data cpuSlice = new PieChart.Data("CPU Usage", cpuUsage);
        PieChart.Data memorySlice = new PieChart.Data("Memory Usage", usedMemory);
        pieChart.getData().addAll(cpuSlice, memorySlice);

        // Create Bar Chart
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Category");
        yAxis.setLabel("Percentage (%)");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        XYChart.Series<String, Number> barSeries = new XYChart.Series<>();
        barSeries.setName("System Data");
        barSeries.getData().add(new XYChart.Data<>("CPU Usage", cpuUsage));
        barSeries.getData().add(new XYChart.Data<>("Memory Usage", usedMemory));
        barChart.getData().add(barSeries);

        // Create Line Chart (CPU Load Over Time Example)
        NumberAxis lineXAxis = new NumberAxis();
        NumberAxis lineYAxis = new NumberAxis();
        lineXAxis.setLabel("Time (Seconds)");
        lineYAxis.setLabel("CPU Usage (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(lineXAxis, lineYAxis);
        XYChart.Series<Number, Number> lineSeries = new XYChart.Series<>();
        lineSeries.setName("CPU Load Trend");

        // Simulate CPU load over 5 seconds (you can adjust the range or update it dynamically)
        for (int i = 1; i <= 5; i++) {
            Util.sleep(1000);  // 1-second interval
            long[] newTicks = processor.getSystemCpuLoadTicks();
            double load = processor.getSystemCpuLoadBetweenTicks(ticks) * 100;
            ticks = newTicks;
            lineSeries.getData().add(new XYChart.Data<>(i, load));
        }

        lineChart.getData().add(lineSeries);

        // Layout: Arrange the charts in a vertical layout (VBox)
        VBox vbox = new VBox(10);  // 10px spacing between the charts
        vbox.getChildren().addAll(pieChart, barChart, lineChart);

        // Set up the scene and stage
        Scene scene = new Scene(vbox, 800, 800);  // Adjust width and height as needed
        primaryStage.setTitle("System Info with OSHI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // This starts the JavaFX application
    }
}*/
package com.team1;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.util.Util;

public class Graphs {

    public static void main(String[] args) {
        // OSHI System Information
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        // Simulating CPU Usage
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(1000);  // Give it a second to calculate load
        long[] ticks = processor.getSystemCpuLoadTicks();
        double cpuUsage = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100;

        // Memory Information
        long totalMemory = memory.getTotal();
        long availableMemory = memory.getAvailable();
        double usedMemory = ((double) (totalMemory - availableMemory) / totalMemory) * 100;

        // Print CPU and Memory Information
        System.out.println("System Information:");
        System.out.printf("CPU Usage: %.2f%%\n", cpuUsage);
        System.out.printf("Total Memory: %.2f GB\n", totalMemory / (1024.0 * 1024 * 1024));
        System.out.printf("Used Memory: %.2f%%\n", usedMemory);

        // Print CPU Load over Time
        System.out.println("\nCPU Load Trend (over 5 seconds):");
        for (int i = 1; i <= 5; i++) {
            Util.sleep(1000);  // 1-second interval
            long[] newTicks = processor.getSystemCpuLoadTicks();
            double load = processor.getSystemCpuLoadBetweenTicks(ticks) * 100;
            ticks = newTicks;
            System.out.printf("Second %d: CPU Load = %.2f%%\n", i, load);
        }
    }
}

