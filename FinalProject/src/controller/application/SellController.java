package controller.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import media.userNameMedia;

public class SellController implements Initializable {

    @FXML
    private ToggleButton tbtnSell;
    @FXML
    private ToggleButton tbtnCustomer;
    @FXML
    private ToggleButton tbtnReports;
    @FXML
    private Label lblPathInfo;
    @FXML
    private StackPane spMainContent;

    userNameMedia nameMedia;

    String userId;
    @FXML
    public AnchorPane acMainSells;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup group = new ToggleGroup();
        tbtnSell.setSelected(true);
        tbtnCustomer.setToggleGroup(group);
        tbtnSell.setToggleGroup(group);
        tbtnReports.setToggleGroup(group);
    }

    @FXML
    public void tbtnSellOnAction(ActionEvent event) throws IOException {
        lblPathInfo.setText("Sells");
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/sell/ViewSell.fxml").openStream());
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(fXMLLoader.getRoot());
    }

    @FXML
    private void tbtnCustomerOnAction(ActionEvent event) throws IOException {
        lblPathInfo.setText("Customers");
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/sell/Vehicle.fxml").openStream());
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(fXMLLoader.getRoot());
    }

    @FXML
    private void tbtnReportsOnAction(ActionEvent event) throws IOException {

    }

}
