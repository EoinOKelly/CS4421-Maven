import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieCharts extends Application {

    @Override
    public void start(Stage stage) {
        // Create a PieChart
        PieChart pieChart = new PieChart();

        // Add data to the PieChart
        PieChart.Data slice1 = new PieChart.Data("Category A", 30);
        PieChart.Data slice2 = new PieChart.Data("Category B", 25);
        PieChart.Data slice3 = new PieChart.Data("Category C", 45);

        pieChart.getData().addAll(slice1, slice2, slice3);

        // Set the title for the window (Stage), not the chart itself
        stage.setTitle("Pie Chart Example");

        // Create a scene and add the PieChart to it
        Scene scene = new Scene(pieChart, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
