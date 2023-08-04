package controller.application.settings;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;
import media.userNameMedia;

import javafx.scene.control.Alert;


public class MyAccountController implements Initializable {

    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfFullName;
    @FXML
    private TextField tfContractNumber;
    @FXML
    private TextField tfEmailAddress;
    @FXML
    private TextArea taAddress;
    @FXML
    private Button btnSave;
    @FXML
    private Rectangle retImage;

    private Image image;

    private File file;

    private FileInputStream fileInput;

    private FileOutputStream fileOutput;

    private byte[] userImage;

    private String imgPath;

    private String userID;

    private userNameMedia usrMediaID;

    public userNameMedia getUsrMediaID() {
        return usrMediaID;
    }

    public void setUsrMediaID(userNameMedia usrMediaID) {
        userID = usrMediaID.getId();
        this.usrMediaID = usrMediaID;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BooleanBinding boolenBinding = tfFullName.textProperty().isEmpty()
                .or(tfEmailAddress.textProperty().isEmpty()
                        .or(tfContractNumber.textProperty().isEmpty()));

        btnSave.disableProperty().bind(boolenBinding);
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    private void hlChangePasswordOnClick(ActionEvent event) throws IOException {
        System.out.println("You can change your password");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/application/settings/PassChange.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        scene.setFill(new Color(0, 0, 0, 0));
        Stage nStage = new Stage();
        nStage.setScene(scene);
        nStage.setTitle("Registration -MainCompany");
        nStage.initModality(Modality.APPLICATION_MODAL);
        nStage.initStyle(StageStyle.TRANSPARENT);
        nStage.show();
    }

    @FXML
    private void apOnOpenAction(MouseEvent event) {

    }

    public void showDetails() {
        retImage.setFill(new ImagePattern(image));
    }


    @FXML
    private void attachImageOnAction(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterjpg = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterpng = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");

        fileChooser.getExtensionFilters().addAll(extFilterjpg, extFilterpng);

        file = fileChooser.showOpenDialog(null);

        if (file != null) {
            if (file.length() < 6000000) {
                System.out.print("Condition ok");
                System.out.println(file.length());
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                retImage.setFill(new ImagePattern(image));
                imgPath = file.getAbsolutePath();
            } else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Permiss");
                alert.setHeaderText("Permission denied");
                alert.setContentText("Your Image file is too big to upload \nplease choise another image");
                alert.initStyle(StageStyle.UNDECORATED);

            }

        }
    }

    private boolean nullCheck() {
        boolean notNull;

        if (tfFullName.getText().trim().length() == 0
                || tfContractNumber.getText().trim().length() == 0
                || tfEmailAddress.getText().trim().length() == 0) {
            notNull = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR ");
                alert.setContentText("Please Fill all requere fields");
                alert.initStyle(StageStyle.UNDECORATED);
        } else {
            notNull = true;
            System.out.println("Not Null");
        }
        return notNull;
    }

}
