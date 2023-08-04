package controller.application.home;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;


public class HomeController implements Initializable {
    @FXML
    private Label lblTotalItem;
    @FXML
    private Label lblStockValue;
    @FXML
    private Label lblTotalSupplyer;
    @FXML
    private Label lblTotalEmployee;

    @FXML
    private Label lblTotalSell;
    @FXML
    private Label lblSellValue;
    @FXML
    private Label lblOrgName;
    @FXML
    private Text txtOrgAddress;
    @FXML
    private Text txtorgPhoneNumber;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        valueCount();
        totalCount();
    }    
    
    public void valueCount(){

    }
    
    public void totalCount(){

    }
}
