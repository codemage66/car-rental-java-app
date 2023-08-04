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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


import media.userNameMedia;


public class StockController implements Initializable {
    @FXML
    private AnchorPane acHeadStore;
    @FXML
    private StackPane spMainContent;

    private String usrId;

    private userNameMedia userId;
    @FXML
    public BorderPane bpStore;
    @FXML
    private Label lblHeader;
    @FXML
    private ToggleButton btnStock;
    @FXML
    private ToggleButton btnSupplyer;
    @FXML
    private ToggleButton btnBrands;
    @FXML
    private ToggleButton btnCatagory;
    @FXML
    private ToggleButton btnUnit;
    @FXML
    private ToggleButton btnRma;
    @FXML
    private ToggleButton btnRepoerts;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ToggleGroup toggleGroup = new ToggleGroup();
        btnStock.setSelected(true);
        btnStock.setToggleGroup(toggleGroup);
        btnSupplyer.setToggleGroup(toggleGroup);
        btnBrands.setToggleGroup(toggleGroup);
        btnCatagory.setToggleGroup(toggleGroup);
        btnUnit.setToggleGroup(toggleGroup);
        btnRma.setToggleGroup(toggleGroup);
        btnRepoerts.setToggleGroup(toggleGroup);


    }


    @FXML
    public void btnStockOnAction(ActionEvent event) throws IOException {
        lblHeader.setText("Store");
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/stock/CurrentStore.fxml").openStream());
        StackPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    private void btnSupplyerOnAction(ActionEvent event) throws IOException {
        lblHeader.setText("Supplyer");
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/stock/ViewSupplier.fxml").openStream());
        AnchorPane acPane = fXMLLoader.getRoot();

        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    private void btnBrandsOnAction(ActionEvent event) throws IOException {
        lblHeader.setText("Brands");
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/stock/ViewBrand.fxml").openStream());
        AnchorPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    private void btnCatagoryOnAction(ActionEvent event) throws IOException {
        lblHeader.setText("Catagories");
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/stock/ViewCategory.fxml").openStream());
        AnchorPane acPane = fXMLLoader.getRoot();

        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    private void btnUnitOnAction(ActionEvent event) throws IOException {
        lblHeader.setText("Unit");

        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/stock/ViewUnit.fxml").openStream());
        AnchorPane acPane = fXMLLoader.getRoot();

        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    private void btnRmaOnAction(ActionEvent event) throws IOException {
        lblHeader.setText("RMA");

        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/stock/ViewRMA.fxml").openStream());
        AnchorPane acPane = fXMLLoader.getRoot();

        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    private void btnRepoertsOnAction(ActionEvent event) {
    }
    
    public void settingPermission(){}

}
