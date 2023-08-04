package controller.application.stock;

import controller.application.sell.NewSellController;
import controller.application.sell.ViewVehicleController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import media.userNameMedia;
import controller.application.SettingsController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;

public class CurrentStoreController implements Initializable {
    

    @FXML
    public StackPane spProductContent;
    @FXML
    private TextField tfSearch;
    @FXML
    private ComboBox<String> cbSoteViewSupplyer;
    @FXML
    private ComboBox<String> cbSoteViewBrands;
    @FXML
    private ComboBox<String> cbSoteViewCatagory;
    @FXML
    private ComboBox<String> cbSoteViewRMA;
    @FXML
    private Button btnAddNew;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Long> tblViewCurrentStore;
    @FXML
    private TableColumn<Object, Object> tblClmProductId;
    @FXML
    private TableColumn<Object, Object> tblClmProductName;
    @FXML
    private TableColumn<Object, Object> tblClmProductquantity;
    @FXML
    private TableColumn<Object, Object> tblClmProductUnit;
    @FXML
    private TableColumn<Object, Object> tblClmProductRMA;
    @FXML
    private TableColumn<Object, Object> tblClmProductSupplyer;
    @FXML
    private TableColumn<Object, Object> tblClmProductBrand;
    @FXML
    private TableColumn<Object, Object> tblClmProductCatagory;
    @FXML
    private TableColumn<Object, Object> tblClmProductPursesPrice;
    @FXML
    private TableColumn<Object, Object> tblClmProductSellPrice;
    @FXML
    private TableColumn<Object, Object> tblClmProductdate;
    @FXML
    private TableColumn<Object, Object> tblClmProductAddBy;
    @FXML
    private TableColumn<Object, Object> tblClmProductdescription;
    @FXML
    private MenuItem miSellSelected;
    @FXML
    private Button btnRefresh;
    @FXML
    public AnchorPane apCombobox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void tfSearchOnKeyRelese(KeyEvent event) {
    }

    @FXML
    private void cbSoteViewSupplyerOnClick(MouseEvent event) {
        cbSoteViewSupplyer.getItems().clear();
        cbSoteViewBrands.setPromptText("Select Brand");
        cbSoteViewCatagory.setPromptText("Select Category");

    }

    @FXML
    private void cbSoteViewBrandOnClick(MouseEvent event) {
        cbSoteViewBrands.getItems().clear();
    }

    @FXML
    private void cbSoteViewCatagoryOnClick(MouseEvent event) {
        cbSoteViewCatagory.getItems().clear();
    }

    @FXML
    private void cbSoteViewRMAOnClick(MouseEvent event) {
        cbSoteViewRMA.getItems().clear();
    }

    @FXML
    private void btnAddNewOnAction(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/application/stock/AddProduct.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
        if (!tblViewCurrentStore.getSelectionModel().isEmpty()) {
            viewSelected();
        } else {
            System.out.println("EMPTY SELECTION");
        }
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Login Now");
        alert.setHeaderText("Confirm");
        alert.setContentText("Are you sure to delete this item \n to Confirm click ok");
        alert.initStyle(StageStyle.UNDECORATED);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            btnRefreshOnACtion(event);
        }

    }

    @FXML
    private void tblViewCurrentStoreOnClick(MouseEvent event
    ) {
        if (event.getClickCount() == 2) {
            if (!tblViewCurrentStore.getSelectionModel().isEmpty()) {
                viewSelected();
            } else {
                System.out.println("EMPTY SELECTION");
            }
        } else {
            tblViewCurrentStore.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    tblViewCurrentStore.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                }
            });

        }
    }

    public void viewDetails() {
        System.out.println("CLCKED");
        tblClmProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        tblClmProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tblClmProductquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblClmProductdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblClmProductSupplyer.setCellValueFactory(new PropertyValueFactory<>("suppliedBy"));
        tblClmProductBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblClmProductCatagory.setCellValueFactory(new PropertyValueFactory<>("catagory"));
        tblClmProductUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        tblClmProductPursesPrice.setCellValueFactory(new PropertyValueFactory<>("pursesPrice"));
        tblClmProductSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tblClmProductRMA.setCellValueFactory(new PropertyValueFactory<>("rma"));
        tblClmProductAddBy.setCellValueFactory(new PropertyValueFactory<>("user"));
        tblClmProductdate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private void viewSelected() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/application/stock/AddProduct.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void miSellSelectedOnAction(ActionEvent event) {
        if (tblViewCurrentStore.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource("/view/application/sell/NewSell.fxml"));
            try {
                fXMLLoader.load();
                Parent parent = fXMLLoader.getRoot();
                Scene scene = new Scene(parent);
                scene.setFill(new Color(0, 0, 0, 0));
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ViewVehicleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    @FXML
    private void cbSoteViewSupplyerOnAction(ActionEvent event) {

    }

    @FXML
    private void cbSoteViewBrandOnAction(ActionEvent event) {
    }

    @FXML
    private void cbSoteViewCatagoryOnAction(ActionEvent event) {
    }

    public void settingPermission() {

    }

    @FXML
    private void btnRefreshOnACtion(ActionEvent event) {
        tfSearch.clear();
        cbSoteViewRMA.getItems().clear();
        cbSoteViewSupplyer.getItems().clear();
        cbSoteViewBrands.getItems().clear();
        cbSoteViewCatagory.getItems().clear();
        cbSoteViewSupplyer.setPromptText("Select supplier");
        cbSoteViewBrands.setPromptText("select brands");
        cbSoteViewCatagory.setPromptText("select category");
        cbSoteViewRMA.setPromptText("select rma");

        tblClmProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        tblClmProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tblClmProductquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblClmProductdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblClmProductSupplyer.setCellValueFactory(new PropertyValueFactory<>("suppliedBy"));
        tblClmProductBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblClmProductCatagory.setCellValueFactory(new PropertyValueFactory<>("catagory"));
        tblClmProductUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        tblClmProductPursesPrice.setCellValueFactory(new PropertyValueFactory<>("pursesPrice"));
        tblClmProductSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tblClmProductRMA.setCellValueFactory(new PropertyValueFactory<>("rma"));
        tblClmProductAddBy.setCellValueFactory(new PropertyValueFactory<>("user"));
        tblClmProductdate.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    @FXML
    private void cbSoteViewRMAOnAction(ActionEvent event) {

    }

    @FXML
    private void tblViewCurrentStoreOnScroll(ScrollEvent event) {
        if (event.isInertia()) {
            System.out.println("ALT DOWN");
        } else {
            System.out.println("Noting");
        }
    }

}
