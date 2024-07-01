package VistaAdmin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class EstadisticasController implements Initializable {

    @FXML
    private LineChart<String, Number> linea; // String para CategoryAxis, Number para NumberAxis
    @FXML
    private CategoryAxis xAxis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Crear una serie de datos
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        
        xAxis.setTickLabelRotation(360);
        linea.setTitle("Sales in the Year");
        series.setName("");
        
        

        // Añadir datos a la serie
        series.getData().add(new XYChart.Data<>("Jan", 23));
        series.getData().add(new XYChart.Data<>("Feb", 14));
        series.getData().add(new XYChart.Data<>("Mar", 15));
        series.getData().add(new XYChart.Data<>("Apr", 24));
        series.getData().add(new XYChart.Data<>("May", 34));
        series.getData().add(new XYChart.Data<>("Jun", 36));
        series.getData().add(new XYChart.Data<>("Jul", 22));
        series.getData().add(new XYChart.Data<>("Aug", 45));
        series.getData().add(new XYChart.Data<>("Sep", 43));
        series.getData().add(new XYChart.Data<>("Oct", 17));
        series.getData().add(new XYChart.Data<>("Nov", 17));
        series.getData().add(new XYChart.Data<>("Dec", 17));

        // Añadir la serie al LineChart
        linea.getData().add(series);
    }
}
