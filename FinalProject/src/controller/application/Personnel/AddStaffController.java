package controller.application.Personnel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import media.userNameMedia;
import javafx.beans.binding.BooleanBinding;


public class AddStaffController implements Initializable {

    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfFullName;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btnAttachImage;
    @FXML
    private Button btnSave;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfSalary;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextArea taAddress;
    @FXML
    private ImageView imvUsrImg;
    
    private File file;
    private BufferedImage bufferedImage;
    private Image image;
    
    private String imagePath;
    private String usrId;
    
    private userNameMedia nameMedia;
    @FXML
    public Button btnClrUsrName;
    @FXML
    public Button btnClrFullName;
    @FXML
    public Button btnClrEmail;
    @FXML
    public Button btnClrPhone;
    @FXML
    public Button btnClrSalary;
    @FXML
    public Button btnClrPassword;

    public userNameMedia getNameMedia() {
        return nameMedia;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        BooleanBinding binding = tfUserName.textProperty().isEmpty()
                .or(tfFullName.textProperty().isEmpty()
                .or(tfPhone.textProperty().isEmpty())
                .or(tfPassword.textProperty().isEmpty()));
        btnSave.disableProperty().bind(binding);
    }    

    @FXML
    private void btnAttachImageOnAction(ActionEvent event) throws IOException {
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
            imvUsrImg.setImage(image);
            imagePath = file.getAbsolutePath();
        }
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
    }

    

    
}
