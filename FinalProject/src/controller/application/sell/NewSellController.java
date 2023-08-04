package controller.application.sell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Vehicle.RentHistory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import media.userNameMedia;


public class NewSellController implements Initializable {

    public Button btnAddCustomer;
    userNameMedia nameMedia;

    String userId;
    @FXML
    private MenuButton mbtnCustomer;
    @FXML
    private TableView<RentHistory> tblCustomerSortView;
    @FXML
    private TableColumn<Object, Object> tblClmCustomerName;
    @FXML
    private TableColumn<Object, Object> tblClmCustomerPhoneNo;
    @FXML
    private TextField tfCustomerSearch;
    @FXML
    private Button btnClose;

    String customerId;
    @FXML
    public TextField tfProductId;
    @FXML
    private TableView<FileHandler> tblSellPreList;
    @FXML
    private TableColumn<Object, Object> tblClmSellId;
    @FXML
    private TableColumn<Object, Object> tblClmProductId;
    @FXML
    private TableColumn<Object, Object> tblClmSellPrice;
    @FXML
    private TableColumn<Object, Object> tblClmCustomer;
    @FXML
    private TableColumn<Object, Object> tblClmSolledBy;
    @FXML
    private TableColumn<Object, Object> tblClmWarrentyVoidDate;
    @FXML
    private TableColumn<Object, Object> tblClmQuantity;
    @FXML
    private TableColumn<Object, Object> tblClmTotalPrice;
    @FXML
    private TextField tfQuantity;
    @FXML
    private Label lblCurrentQuantity;
    @FXML
    private TextField tfSellPrice;
    @FXML
    private Label lblPursesPrice;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblNetCost;
    private Label lblDiscount;
    @FXML
    private Label lblUnit;
    @FXML
    private TextField tfSupplyer;
    @FXML
    private TextField tfBrand;
    @FXML
    private TextField tfCatagory;
    @FXML
    private TextField tfWarrentVoidDate;
    @FXML
    private Button btnAddToChart;
    @FXML
    private Button btnSell;
    @FXML
    private Label lblPursesDate;
    int quantity;
    @FXML
    private Label lblTotalItems;
    @FXML
    private TextField tfProductName;
    @FXML
    private Button btnClearAll;
    @FXML
    private Button btnClearSelected;
    @FXML
    private Label lblSellId;

    public void setNameMedia(userNameMedia nameMedia) {
        userId = nameMedia.getId();
        this.nameMedia = nameMedia;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearAll();

    }

    @FXML
    private void tblCustomerOnClick(MouseEvent event) {
        System.out.println(customerId);
    }

    @FXML
    private void mbtnCustomerOnClicked(MouseEvent event) {


        tblClmCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblClmCustomerPhoneNo.setCellValueFactory(new PropertyValueFactory<>("customerContNo"));

    }

    @FXML
    private void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void tfCustomerSearchOnKeyReleased(KeyEvent event) {
        tblClmCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblClmCustomerPhoneNo.setCellValueFactory(new PropertyValueFactory<>("customerContNo"));
    }

    @FXML
    public void tfProductIdOnAction(ActionEvent event) {
        if (tfProductId.getText().isEmpty()) {
            clearAll();
        } else {

        }
    }

    @FXML
    private void btnAddToChartOnAction(ActionEvent event) {
    }

    public void viewAll() {
        tblClmProductId.setCellValueFactory(new PropertyValueFactory<>("productID"));
        tblClmQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblClmSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tblClmTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        tblClmWarrentyVoidDate.setCellValueFactory(new PropertyValueFactory<>("warrentyVoidDate"));
    }

    @FXML
    private void btnSellOnAction(ActionEvent event) {
        if (!tblSellPreList.getItems().isEmpty()) {
            System.out.println(lblSellId.getText());
            int indexs = tblSellPreList.getItems().size();
            for (int i = 0; i < indexs; i++) {
                tblSellPreList.getSelectionModel().select(i);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucess");
            alert.setHeaderText("Soled");
            alert.setContentText("Soled Sucessfuly");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();

            tblSellPreList.getItems().clear();
            lblTotal.setText(null);

            System.out.println("Customer ID: " + customerId);
        } else {
            System.out.println("EMPTY");
        }

    }

    public void clearAll() {
        tfBrand.clear();
        tfProductId.clear();
        tfCatagory.clear();
        tfSellPrice.clear();
        tfSupplyer.clear();
        tfWarrentVoidDate.clear();
        tfQuantity.clear();
        tfProductName.clear();
        lblCurrentQuantity.setText(null);
        lblNetCost.setText(null);
        lblPursesPrice.setText(null);
        lblUnit.setText(null);
        lblPursesDate.setText(null);
    }

    @FXML
    private void tfQuantityOnAction(KeyEvent event) {
        if (!tfQuantity.getText().isEmpty()) {
            String givenQuentity = tfQuantity.getText();
            int givenQinInt = Integer.parseInt(givenQuentity);
            String currentQuentity = lblCurrentQuantity.getText();
            int currentQuentiInt = Integer.parseInt(currentQuentity);
            if (givenQinInt > currentQuentiInt) {
                System.out.println("BIG");
                tfQuantity.clear();
                lblNetCost.setText("0.0");
            } else {
                quantity = Integer.parseInt(tfQuantity.getText());
                float sellPrice = Float.parseFloat(tfSellPrice.getText());
                String netPrice = String.valueOf(sellPrice * quantity);
                lblNetCost.setText(netPrice);
            }
        } else {
            lblNetCost.setText("0.0");
        }
    }

    @FXML
    private void tfSellPriceOnAction(KeyEvent event) {
        System.out.println("PRESSES");

        if (!tfSellPrice.getText().isEmpty()) {
            String quentity = tfQuantity.getText();
            int intQuentity = Integer.parseInt(quentity);
            String sellPrice = tfSellPrice.getText();
            float fSellPrice = Float.parseFloat(sellPrice);
            String sTotalPrice = String.valueOf(intQuentity * fSellPrice);
            lblNetCost.setText(sTotalPrice);
            System.out.println(sTotalPrice);
        } else {
            lblNetCost.setText("0.0");
        }
    }

    @FXML
    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        System.out.println(userId);
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/application/sell/AddVehicle.fxml"));

        try {
            fXMLLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = fXMLLoader.getRoot();
        Scene scene = new Scene(parent);
        scene.setFill(new Color(0, 0, 0, 0));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
}
    @FXML
    private void btnClearAllOnAction(ActionEvent event) {

    }

    @FXML
    private void btnClearSelectedOnAction(ActionEvent event) {
        if (tblSellPreList.getItems().size() != 0) {
            System.out.println("Clicked");
            tblSellPreList.getItems().removeAll(tblSellPreList.getSelectionModel().getSelectedItems());
        } else {
            System.out.println("EMPTY");
        }


    }

}
