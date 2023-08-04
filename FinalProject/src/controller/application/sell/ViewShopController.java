package controller.application.sell;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import media.userNameMedia;


public class ViewShopController implements Initializable{
    
    userNameMedia nameMedia;
    

    
    String userId;
    @FXML
    private Button btnSellOrder;
    @FXML
    private TableView<Long> tblSellView;
    @FXML
    private TableColumn<Object, Object> tblClmSellId;
    @FXML
    private TableColumn<Object, Object> tblClmProductId;
    @FXML
    private TableColumn<Object, Object> tblClmCustomerName;
    @FXML
    private TableColumn<Object, Object> tblClmSoldDate;
    @FXML
    private TableColumn<Object, Object> tblClmPursrsPrice;
    @FXML
    private TableColumn<Object, Object> tblClmSellPrice;
    @FXML
    private TableColumn<Object, Object> tblClmQuantity;
    @FXML
    private TableColumn<Object, Object> tblClmTotalPrice;
    @FXML
    private TableColumn<Object, Object> tblClmWarrenty;
    @FXML
    private TableColumn<Object, Object> tblClmSoldBy;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnRefresh;

    public void setNameMedia(userNameMedia nameMedia) {
        userId = nameMedia.getId();
        this.nameMedia = nameMedia;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblSellView.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("Clicked");
        });
    }

    @FXML
    private void btnSellOrderOnAction(ActionEvent event) {
        System.out.println(userId);
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/application/sell/NewSell.fxml"));
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
    
    public void viewDetails(){
//        tblSellView.setItems(sellCart.soldList);
        tblClmCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblClmSellId.setCellValueFactory(new PropertyValueFactory<>("sellId"));
        tblClmProductId.setCellValueFactory(new PropertyValueFactory<>("productGId"));
        tblClmSoldDate.setCellValueFactory(new PropertyValueFactory<>("sellDate"));
        tblClmPursrsPrice.setCellValueFactory(new PropertyValueFactory<>("pursesPrice"));
        tblClmSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tblClmQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblClmTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        tblClmWarrenty.setCellValueFactory(new PropertyValueFactory<>("warrentyVoidDate"));
        tblClmSoldBy.setCellValueFactory(new PropertyValueFactory<>("sellerName"));
    }

    @FXML
    private void tfSearchOnKeyReleased(KeyEvent event) {
        tblSellView.getItems().clear();
    }

    @FXML
    private void btnRefreshOnAction(ActionEvent event) {
        tblSellView.getItems().clear();
        tfSearch.clear();
        tblClmCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblClmSellId.setCellValueFactory(new PropertyValueFactory<>("sellId"));
        tblClmProductId.setCellValueFactory(new PropertyValueFactory<>("productGId"));
        tblClmSoldDate.setCellValueFactory(new PropertyValueFactory<>("sellDate"));
        tblClmPursrsPrice.setCellValueFactory(new PropertyValueFactory<>("pursesPrice"));
        tblClmSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tblClmQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblClmTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        tblClmWarrenty.setCellValueFactory(new PropertyValueFactory<>("warrentyVoidDate"));
        tblClmSoldBy.setCellValueFactory(new PropertyValueFactory<>("sellerName"));
    }
    
    
    
}
