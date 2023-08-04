package controller.application.settings;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import media.userNameMedia;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class PassChangeController implements Initializable {


    @FXML
    private PasswordField pfCurrentPass;
    @FXML
    private PasswordField pfNewPass;
    @FXML
    private PasswordField pfRePass;
    @FXML
    private Button btnClrCurrentPf;
    @FXML
    private Button btnClrRePass;
    @FXML
    private Button btnClrNewPass;
    @FXML
    private Button btnChangePass;
    @FXML
    private Button btnClose;

    private String userId;
    private String userName;
    private userNameMedia nameMedia;

    @FXML
    private ImageView imgCurrentPassMatch;
    @FXML
    private ImageView imgNewPassMatch;

    public userNameMedia getNameMedia() {
        return nameMedia;
    }

    public void setNameMedia(userNameMedia nameMedia) {
        userId = nameMedia.getId();
        userName = nameMedia.getUsrName();
        this.nameMedia = nameMedia;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        BooleanBinding binding = pfCurrentPass.textProperty().isEmpty()
                .or(pfNewPass.textProperty().isEmpty()
                        .or(pfRePass.textProperty().isEmpty()));

        btnChangePass.disableProperty().bind(binding);

    }

    @FXML
    private void btnChangePassOnAction(ActionEvent event) {
        if (isCurrentPasswordChecqOk()) {
            if (isPasswordMatch()) {
                updatePassword();
            }

        } else {
            System.out.println("ddd");
        }

    }

    @FXML
    private void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void pfOnAction(ActionEvent event) {
        btnChangePassOnAction(event);
    }

    @FXML
    private void pfNewPassWordMatch(KeyEvent event) {
        if (pfNewPass.getText().matches(pfRePass.getText())) {
            System.out.println("Match");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR ");
            alert.setContentText("Invalid password");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }
    }

    private boolean isCurrentPasswordChecqOk() {
        boolean conDitionValid = true;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR ");
            alert.setContentText("Invalid password");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            conDitionValid = false;


        return conDitionValid;
    }

    private boolean isPasswordMatch() {
        boolean passMatch;
        if (pfNewPass.getText().matches(pfRePass.getText())) {
            System.out.println("New Password match");
            passMatch = true;

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR ");
            alert.setContentText("New Password what you enterd are not matched");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();

            passMatch = false;
        }
        return passMatch;
    }

    private void updatePassword() {


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucess");
            alert.setHeaderText("Sucess ");
            alert.setContentText("Update Password Sucessfuly");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            


    }
}
