package controller.application.settings;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;
import media.userNameMedia;

public class OrgSettingController implements Initializable {

    @FXML
    private TextField tfOrganizeName;
    @FXML
    private Rectangle retOrgLogo;
    @FXML
    private Button btnAttechLogo;
    @FXML
    private Button btnSaveOrganize;

    private File file;

    private BufferedImage bufferedImage;

    private Image image;

    private String userId;

    private String imagePath;

    private userNameMedia usrIdMedia;
    @FXML
    private TextField tfWebSite;
    @FXML
    private TextArea taContactNumber;
    @FXML
    private TextArea taAdddress;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BooleanBinding boolenBind = tfOrganizeName.textProperty().isEmpty()
                .or(tfWebSite.textProperty().isEmpty()
                        .or(taContactNumber.textProperty().isEmpty())
                        .or(taAdddress.textProperty().isEmpty()));

        btnSaveOrganize.disableProperty().bind(boolenBind);
    }

    @FXML
    private void btnSaveOrganizeOnClick(ActionEvent event) {
        if (isFoundData()) {
            //update
            if (imagePath != null) {
                updateOrganizeWithImage();
            }

        } else {
            //insert
            insertOrganizeWithImage();
        }
    }

    @FXML
    private void btnAttechLogoOnAction(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG (Joint Photographic Group)", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG (Joint Photographic Experts Group)", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG (Portable Network Graphics)", "*.png")
        );

        fileChooser.setTitle("Choise a Image File");

        file = fileChooser.showOpenDialog(null);

        if (file != null) {
            System.out.println(file);
            bufferedImage = ImageIO.read(file);
            image = SwingFXUtils.toFXImage(bufferedImage, null);
            retOrgLogo.setFill(new ImagePattern(image));
            imagePath = file.getAbsolutePath();
        }
    }

    public void showDetails() {
    }


    private boolean isFoundData() {
        boolean dataFound = true;
        System.out.println("Data not found");
        dataFound = false;
        return dataFound;
    }

    private void updateOrganizeWithImage() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update");
        alert.setHeaderText("Update ");
        alert.setContentText("Update Sucessfully");
        alert.initStyle(StageStyle.UNDECORATED);
        alert.showAndWait();

    }

    private void insertOrganizeWithImage() {
        if (imagePath != null) {

            try {
                InputStream is = new FileInputStream(new File(imagePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update");
            alert.setHeaderText("Sucess ");
            alert.setContentText("Insert Data Sucessfuly");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();

        }

    }
}
