
package controller.application.Personnel;



import java.net.URL;
import java.util.ResourceBundle;



import Person.Person;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import media.userNameMedia;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Parent;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;

import java.util.Optional;

public class ViewEmployeController implements Initializable {



    private File file;
    private BufferedImage bufferedImage;
    private String imagePath;
    private Image image;
    private Blob blobImage;

    private String userId;
    private String name;
    private String id;
    private userNameMedia nameMedia;
    private String creatorId;
    private String creatorName;

    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfFullName;
    @FXML
    private TextField tfEmailAddress;
    @FXML
    private TextField tfPhoneNumber;
    @FXML
    private TextField tfSearch;
    @FXML
    private Rectangle recUsrImage;
    @FXML
    private Button btnAttachImage;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField tfSalary;
    @FXML
    private TextField tfDateofJoin;
    @FXML
    private TextField tfCreatedBy;
    @FXML
    private TextArea taAddress;
    @FXML
    public Button btnClrFulNametf;
    @FXML
    public Button btnClrEmailtf;
    @FXML
    public Button btnClrPhonetf;
    @FXML
    public Button btnClrSalarytf;
    @FXML
    public Button btnClrDatestf;
    @FXML
    public Button btnClrCreatortf;
    @FXML
    private CheckBox cbStatus;
    @FXML
    private TableView<Person> tblEmoyeeList;
    @FXML
    private TableColumn<Object, Object> clmEmployeId;
    @FXML
    private TableColumn<Object, Object> clmEmployeName;
    @FXML
    private Label lblCreator;

    Image usrImg = new Image("/image/Javid.png");
    private Parent apMotherContent;

    public userNameMedia getNameMedia() {
        return nameMedia;
    }

    public void setNameMedia(userNameMedia nameMedia) {
        userId = nameMedia.getId();
        name = nameMedia.getUsrName();
        this.nameMedia = nameMedia;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        apMotherContent.getStylesheets().add(ViewEmployeController.class.getResource("/style/MainStyle.css").toExternalForm());
    }

    @FXML
    private void tfSearchOnAction(ActionEvent event) {

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
            recUsrImage.setFill(new ImagePattern(image));
            imagePath = file.getAbsolutePath();
        }

    }

    @FXML
    private void tblViewOnClick(KeyEvent event) {
        if (event.getCode().equals(KeyCode.UP)) {
            setselectedView();
        } else if (event.getCode().equals(KeyCode.DOWN)) {
            setselectedView();
        }
    }

    public void tblEmployeOnClick(Event event) {
        setselectedView();
    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) throws FileNotFoundException {


    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Employee");
        alert.setHeaderText("Are You sure ?");
        alert.setContentText("Are you sure to remove this employee \n Click OK to confirm");
        alert.initStyle(StageStyle.UNDECORATED);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

        }
        
        tblEmoyeeList.getItems().clear();
        showDetails();

    }

    @FXML
    private void cbOnAction(ActionEvent event) {
        if (cbStatus.isSelected()) {
            cbStatus.setText("Active");
        } else {
            cbStatus.setText("Deactive");
        }
    }

    @FXML
    private void hlChangePasswordOnAction(ActionEvent event) {

    }

    @FXML
    private void hlViewPermissionOnAction(ActionEvent event) throws IOException {

//        EmployeePermissionController pcc = new EmployeePermissionController();
//        userNameMedia usrID = new userNameMedia();
//        FXMLLoader loader = new FXMLLoader();
//        System.out.println(id);
//        loader.setLocation(getClass().getResource("/view/application/employe/EmployeePermission.fxml"));
//        loader.load();
//        Parent root = loader.getRoot();
//        Scene scene = new Scene(root);
//        scene.setFill(new Color(0, 0, 0, 0));
//        EmployeePermissionController PermissionController = loader.getController();
//        nameMedia.setId(id);
//        PermissionController.setMedia(nameMedia);
//        PermissionController.checqPermission();
//        Stage nStage = new Stage();
//        nStage.setScene(scene);
//        nStage.initModality(Modality.APPLICATION_MODAL);
//        nStage.initStyle(StageStyle.TRANSPARENT);
//        nStage.show();
    }

    @FXML
    private void hlViewUpdateHistory(ActionEvent event) throws IOException {
        String emp = "Employee";

        System.out.println("view");
    }

    public void setselectedView() {
        clearAll();

    }

    public void showDetails() {

        clmEmployeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        clmEmployeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));


    }

    private void clearAll() {
        tfUserName.clear();
        tfFullName.clear();
        tfCreatedBy.clear();
        tfSalary.clear();
        tfEmailAddress.clear();
        tfDateofJoin.clear();
        tfPhoneNumber.clear();
        taAddress.clear();
    }
}
