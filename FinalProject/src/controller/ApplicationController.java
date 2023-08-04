package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.application.SellController;
import controller.application.SettingsController;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import media.userNameMedia;


public class ApplicationController implements Initializable {

    @FXML
    private StackPane acContent;
    @FXML
    private ScrollPane leftSideBarScroolPan;
    @FXML
    private ToggleButton sideMenuToogleBtn;
    @FXML
    private ImageView imgMenuBtn;
    @FXML
    private BorderPane appContent;
    @FXML
    private Button btnLogOut;
    @FXML
    private MenuItem miPopOver;
    @FXML
    private AnchorPane acDashBord;
    @FXML
    private AnchorPane acHead;
    @FXML
    private AnchorPane acMain;
    @FXML
    private MenuButton mbtnUsrInfoBox;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView imgHomeBtn;
    @FXML
    private Button btnStore;
    @FXML
    private ImageView imgStoreBtn;
    @FXML
    private Button btnEmplopye;
    @FXML
    private ImageView imgEmployeBtn;
    @FXML
    private Button btnSell;
    @FXML
    private ImageView imgSellBtn;
    @FXML
    private Button btnSettings;
    @FXML
    private ImageView imgSettingsBtn;
    @FXML
    private Button btnAbout;
    @FXML
    private ImageView imgAboutBtn;
    @FXML
    private Label lblUsrName;
    @FXML
    private Label lblUsrNamePopOver;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblRoleAs;
    @FXML
    private Hyperlink hlEditUpdateAccount;
    @FXML
    private Circle imgUsrTop;
    @FXML
    private Circle circleImgUsr;
    @FXML
    private Label lblUserId;

    String usrName;
    String id;


    private userNameMedia usrNameMedia;

    public userNameMedia getUsrNameMedia() {
        return usrNameMedia;
    }

    public void setUsrNameMedia(userNameMedia usrNameMedia) {
        lblUserId.setText(usrNameMedia.getId());
        lblUsrName.setText(usrNameMedia.getUsrName());
        id = usrNameMedia.getId();
        usrName = usrNameMedia.getUsrName();
        this.usrNameMedia = usrNameMedia;
    }

    Image menuImage = new Image("/icon/menu.png");
    Image menuImageRed = new Image("/icon/menuRed.png");
    Image image;

    String defultStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:none";

    String activeStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:#FF4E3C";

    Image home = new Image("/icon/home.png");
    Image homeRed = new Image("/icon/homeRed.png");
    Image stock = new Image("/icon/stock.png");
    Image stockRed = new Image("/icon/stockRed.png");
    Image sell = new Image("/icon/sell2.png");
    Image sellRed = new Image("/icon/sell2Red.png");
    Image employee = new Image("/icon/employe.png");
    Image employeeRed = new Image("/icon/employeRed.png");
    Image setting = new Image("/icon/settings.png");
    Image settingRed = new Image("/icon/settingsRed.png");
    Image about = new Image("/icon/about.png");
    Image aboutRed = new Image("/icon/aboutRed.png");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgMenuBtn.setImage(menuImage);
        Image usrImg = new Image("/image/Javid.png");

        imgUsrTop.setFill(new ImagePattern(usrImg));
        circleImgUsr.setFill(new ImagePattern(usrImg));

    }

    @FXML
    private void sideMenuToogleBtnOnCLick(ActionEvent event) throws IOException {
        if (sideMenuToogleBtn.isSelected()) {
            imgMenuBtn.setImage(menuImageRed);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
            sideMenu.setByX(-130);
            sideMenu.play();
            acDashBord.getChildren().clear();
        } else {
            imgMenuBtn.setImage(menuImage);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
            sideMenu.setByX(130);
            sideMenu.play();
            acDashBord.getChildren().add(leftSideBarScroolPan);
        }
    }

    @FXML
    private void btnLogOut(ActionEvent event) throws IOException {
        acContent.getChildren().clear();
        acContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Login.fxml")));
        acDashBord.getChildren().clear();
        acHead.getChildren().clear();
        acHead.setMaxHeight(0.0);
    }

    @FXML
    private void acMain(KeyEvent event) {
        if (event.getCode() == KeyCode.F11) {
            Stage stage = (Stage) acMain.getScene().getWindow();
            stage.setFullScreen(true);
        }
    }

    @FXML
    public void btnHomeOnClick(ActionEvent event){
        homeActive();
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/application/home/Home.fxml").openStream());
        } catch (IOException e) {
            
        }
        AnchorPane root = fxmlLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(root);

        System.out.println(lblUsrName.getText());
        System.out.println(lblUserId.getText());

    }

    @FXML
    void ExitIcon() {
        System.exit(0);
    }

    @FXML
    private void btnStoreOnClick(ActionEvent event) throws IOException {
        sotreActive();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/Stock.fxml").openStream());
        AnchorPane acPane = fXMLLoader.getRoot();

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane);
    }

    @FXML
    private void btnEmplopyeOnClick(ActionEvent event) throws IOException {
        employeeActive();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/Employe.fxml").openStream());

        AnchorPane acPane = fXMLLoader.getRoot();

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane);


    }

    @FXML
    private void btnSettingsOnClick(ActionEvent event) throws IOException {
        settingsActive();
        FXMLLoader settingLoader = new FXMLLoader();
        //set the location of Settings.fxml by fxmlloader
        settingLoader.load(getClass().getResource("/view/application/Settings.fxml").openStream());
        //take control of settingController elements or node
        AnchorPane acPane = settingLoader.getRoot();
        //acContent clear and make useul for add next node
        acContent.getChildren().clear();
        //add a node call "acPane" to acContent
        acContent.getChildren().add(acPane);

    }

    @FXML
    private void btnAboutOnClick(ActionEvent event) {
        aboutActive();
        FXMLLoader fXMLLoader = new FXMLLoader();
        try {
            fXMLLoader.load(getClass().getResource("/view/application/about/AboutMe.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        AnchorPane anchorPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(anchorPane);
    }

    @FXML
    private void btnSellOnClick(ActionEvent event) {
        sellActive();
        FXMLLoader fXMLLoader = new FXMLLoader();
        try {
            fXMLLoader.load(getClass().getResource("/view/application/Sell.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        AnchorPane anchorPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(anchorPane);


    }

    @FXML
    private void hlUpdateAccount(ActionEvent event) {

    }

    @FXML
    private void mbtnOnClick(ActionEvent event) {

    }

    @FXML
    private void acMainOnMouseMove(MouseEvent event) {

    }

    private void homeActive() {
        imgHomeBtn.setImage(homeRed);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(activeStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void sotreActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stockRed);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(activeStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void sellActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sellRed);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(activeStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void employeeActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employeeRed);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(activeStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void settingsActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(settingRed);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(activeStyle);
        btnAbout.setStyle(defultStyle);
    }

    private void aboutActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(stock);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(employee);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(aboutRed);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(activeStyle);
    }


}
