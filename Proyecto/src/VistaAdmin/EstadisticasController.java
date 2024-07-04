package VistaAdmin;

import static Controlador.Main.history;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.ArrayList;
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
        series.setName("Amount");
        
        ArrayList<Integer> salesInMonths = history.getAllSales();

        // Añadir datos a la serie
        series.getData().add(new XYChart.Data<>("Jan", salesInMonths.get(0)));
        series.getData().add(new XYChart.Data<>("Feb", salesInMonths.get(1)));
        series.getData().add(new XYChart.Data<>("Mar", salesInMonths.get(2)));
        series.getData().add(new XYChart.Data<>("Apr", salesInMonths.get(3)));
        series.getData().add(new XYChart.Data<>("May", salesInMonths.get(4)));
        series.getData().add(new XYChart.Data<>("Jun", salesInMonths.get(5)));
        series.getData().add(new XYChart.Data<>("Jul", salesInMonths.get(6)));
        series.getData().add(new XYChart.Data<>("Aug", salesInMonths.get(7)));
        series.getData().add(new XYChart.Data<>("Sep", salesInMonths.get(8)));
        series.getData().add(new XYChart.Data<>("Oct", salesInMonths.get(9)));
        series.getData().add(new XYChart.Data<>("Nov", salesInMonths.get(10)));
        series.getData().add(new XYChart.Data<>("Dec", salesInMonths.get(11)));

        // Añadir la serie al LineChart
        linea.getData().add(series);
    }
}
