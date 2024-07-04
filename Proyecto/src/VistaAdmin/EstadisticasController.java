package VistaAdmin;

import VistaControlador.AdminPageController;
import VistaControlador.CatalogueController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

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
        series.setName("All Sales");
        
        

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

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void allproducts(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/adminPage.fxml"));
        Parent root = loader.load();
        AdminPageController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
       // stage.initModality(Modality.APPLICATION_MODAL); sirve para no salir hasta terminar el programa
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }catch(IOException ex){
        }
    }
}
