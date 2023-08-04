
package controller.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import media.userNameMedia;


public class EmployeController implements Initializable {
    @FXML
    private MenuItem btnViewEmployee;
    @FXML
    private MenuItem btnAddEmployee;
    
    private String userId;
    
    private userNameMedia nameMedia;
    @FXML
    private StackPane spEmployeContent;
    @FXML
    public BorderPane bpContent;
    @FXML
    private Label lblView;
    @FXML
    private ImageView ivEmployeIcon;
    
    Image image = new Image("/icon/d.png");

    public userNameMedia getNameMedia() {
        return nameMedia;
    }

    public void setNameMedia(userNameMedia nameMedia) {
        userId = nameMedia.getId();
        this.nameMedia = nameMedia;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ivEmployeIcon.setImage(image);
    }    

    @FXML
    public void btnViewEmployeeOnAction(ActionEvent event) throws IOException {
        lblView.setText("Employee");

        
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/employe/ViewEmploye.fxml").openStream());

        AnchorPane acPane = fXMLLoader.getRoot();
        
        spEmployeContent.getChildren().clear();
        
        spEmployeContent.getChildren().add(acPane);
    }

    @FXML
    private void btnAddEmployeeOnClick(ActionEvent event) throws IOException {
        lblView.setText("Add Employee");
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/employe/AddEmploye.fxml").openStream());
        AnchorPane acPane = fXMLLoader.getRoot();
        
        spEmployeContent.getChildren().clear();
        
        spEmployeContent.getChildren().add(acPane);
        
    }

    
}
