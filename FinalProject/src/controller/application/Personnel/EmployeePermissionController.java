package controller.application.Personnel;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import media.userNameMedia;

public class EmployeePermissionController implements Initializable {

    @FXML
    private CheckBox cbStockManegement;
    @FXML
    private CheckBox cbAddProduct;
    @FXML
    private CheckBox cbAddSupplyer;
    @FXML
    private CheckBox cbAddBrand;
    @FXML
    private CheckBox cbAddCatagory;
    @FXML
    private CheckBox cbUpdateProduct;
    @FXML
    private CheckBox cbUpdateSupplyert;
    @FXML
    private CheckBox cbUpdateBrands;
    @FXML
    private CheckBox cbUpdateCatagory;
    @FXML
    private CheckBox cbSellManegement;
    @FXML
    private CheckBox cbSellProduct;
    @FXML
    private CheckBox cbAddCustomer;
    @FXML
    private CheckBox cbUpdateCustomer;
    @FXML
    private CheckBox cbEmployeeManegement;
    @FXML
    private CheckBox cbAddEmployee;
    @FXML
    private CheckBox cbUpdateEmployee;
    @FXML
    private CheckBox cbEmployePassChange;
    @FXML
    private CheckBox cbUser;
    @FXML
    private CheckBox cbChangePassword;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnClose;

    private String id;

    private userNameMedia media;
    @FXML
    private CheckBox cbAddUnit;
    @FXML
    private CheckBox cbUpdateUnit;
    @FXML
    private CheckBox cbProvideDiscount;
    @FXML
    private CheckBox cbOrgManage;
    @FXML
    private CheckBox cbMenageRMA;


    public userNameMedia getMedia() {
        return media;
    }

    public void setMedia(userNameMedia media) {
        id = media.getId();
        this.media = media;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {}

    @FXML
    private void btnCloseOnClick(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cbStockOnAction(ActionEvent event) {
        stockManeCbOperation();

    }

    @FXML
    private void cbSellManegementOnAction(ActionEvent event) {
    }


    @FXML
    private void cbEmployeeManegementOnAction(ActionEvent event) {
        if (cbEmployeeManegement.isSelected()) {
            cbAddEmployee.setSelected(true);
            cbEmployePassChange.setSelected(true);
            cbUpdateEmployee.setSelected(true);

        } else if (!cbEmployeeManegement.isSelected()) {
            cbAddEmployee.setSelected(false);
            cbEmployePassChange.setSelected(false);
            cbUpdateEmployee.setSelected(false);
        }
    }

    @FXML
    private void cbUserOnAction(ActionEvent event) {
    }

    private void stockManeCbOperation() {

        if (cbStockManegement.isSelected()) {
            cbAddProduct.setSelected(true);
            cbAddBrand.setSelected(true);
            cbAddCatagory.setSelected(true);
            cbAddSupplyer.setSelected(true);
            cbAddUnit.setSelected(true);
            cbUpdateBrands.setSelected(true);
            cbUpdateCatagory.setSelected(true);
            cbUpdateSupplyert.setSelected(true);
            cbUpdateProduct.setSelected(true);
            cbUpdateUnit.setSelected(true);
            cbMenageRMA.setSelected(true);
        } else if (!cbStockManegement.isSelected()) {
            cbAddProduct.setSelected(false);
            cbAddBrand.setSelected(false);
            cbAddCatagory.setSelected(false);
            cbAddSupplyer.setSelected(false);
            cbAddUnit.setSelected(false);
            cbUpdateBrands.setSelected(false);
            cbUpdateCatagory.setSelected(false);
            cbUpdateSupplyert.setSelected(false);
            cbUpdateProduct.setSelected(false);
            cbUpdateUnit.setSelected(false);
            cbMenageRMA.setSelected(false);
        }

    }
}
