
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import media.userNameMedia;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane apMother;
    @FXML
    private AnchorPane apDesignPane;
    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField pfUserPassword;
    @FXML
    private Button btnLogin;



    @FXML
    void ExitIcon() {
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BooleanBinding boolenBinding = tfUserName.textProperty().isEmpty()
                .or(pfUserPassword.textProperty().isEmpty());

        btnLogin.disableProperty().bind(boolenBinding);

    }


    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        userNameMedia media = new userNameMedia();
        ApplicationController apController = new ApplicationController();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Application.fxml"));
        loader.load();
        Parent parent = loader.getRoot();
        Scene adminPanelScene = new Scene(parent);
        Stage adminPanelStage = new Stage();
        adminPanelStage.setMaximized(true);
        adminPanelStage.initStyle(StageStyle.UNDECORATED);
        ApplicationController apControl = loader.getController();
        apControl.btnHomeOnClick(event);

        adminPanelStage.setScene(adminPanelScene);
        adminPanelStage.getIcons().add(new Image("/image/icon.png"));
        adminPanelStage.show();

        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.close();
    }

    private boolean isValidCondition() {
        boolean validCondition = false;
        if (tfUserName.getText().trim().isEmpty()
                || pfUserPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING :");
            alert.setHeaderText("WARNING !!");
            alert.setContentText("Please Fill Text Field And Password Properly");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();

            validCondition = false;
        } else {
            validCondition = true;
        }
        return validCondition;
    }

    @FXML
    private void pfUserNameOnHitEnter(ActionEvent event) {
        try {
            btnLogin(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void pfUserPassOnHitEnter(ActionEvent event) {
        try {
            btnLogin(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
