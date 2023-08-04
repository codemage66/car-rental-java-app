package controller.application;

import controller.application.settings.MyAccountController;
import controller.application.settings.OrgSettingController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import media.userNameMedia;

public class SettingsController implements Initializable {
    @FXML
    private MenuItem miMyASccount;
    @FXML
    private MenuItem miOrganize;
    @FXML
    private MenuItem miBackup;
    @FXML
    private StackPane spSettingContent;
    @FXML
    private Label lblCurrentStatus;
    @FXML
    public BorderPane bpSettings;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    public void miMyASccountOnClick(ActionEvent event) throws IOException {
        lblCurrentStatus.setText("My Account");
        

        FXMLLoader fxmlload = new FXMLLoader();
        fxmlload.load(getClass().getResource("/view/application/settings/MyAccount.fxml").openStream());
        AnchorPane acPane = fxmlload.getRoot();
        spSettingContent.getChildren().clear();
        spSettingContent.getChildren().add(acPane);
        
    }

    @FXML
    private void miOrganizeOnAction(ActionEvent event) throws IOException {
        lblCurrentStatus.setText("Org. Setup");
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/settings/OrgSetting.fxml").openStream());
        spSettingContent.getChildren().clear();
        AnchorPane orgAp = fXMLLoader.getRoot();
        spSettingContent.getChildren().add(orgAp);
    }

    @FXML
    private void miBackupOnAction(ActionEvent event) {
        
    }
    

    
}
