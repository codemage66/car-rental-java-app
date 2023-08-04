package controller.application.stock;



import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import media.userNameMedia;

import java.util.Optional;

public class ViewBrandController implements Initializable {

    @FXML
    private TableView<Long> tblBrand;
    @FXML
    private TableColumn<Object, Object> tblCollumId;
    @FXML
    private TableColumn<Object, Object> tblCollumName;
    @FXML
    private TableColumn<Object, Object> tblCollumSupplyer;
    @FXML
    private TableColumn<Object, Object> tblCollumDescription;
    @FXML
    private TableColumn<Object, Object> tblCollumCreator;
    @FXML
    private TableColumn<Object, Object> tblClmDate;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnAddBrand;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnRefresh;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void tblBrandOnClick(MouseEvent event) {
        int click = event.getClickCount();
        if (click == 2) {
            viewDetails();
        }

    }

    @FXML
    private void tfSearchOnKeyPress(Event event) {
        tblCollumId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCollumName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        tblCollumSupplyer.setCellValueFactory(new PropertyValueFactory<>("supplyerName"));
        tblCollumDescription.setCellValueFactory(new PropertyValueFactory<>("brandComment"));
        tblCollumCreator.setCellValueFactory(new PropertyValueFactory<>("creatorId"));
        tblClmDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    private void btnAddBrandOnAction(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/application/stock/AddBrand.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.initStyle(StageStyle.TRANSPARENT);
            nStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tfSearchOnAction(event);
    }

    @FXML
    private void btnUpdateOnAction(Event event) {
        if (tblBrand.getSelectionModel().getSelectedItem() != null) {
            viewDetails();
        } else {
            System.out.println("EMPTY SELECTION");
        }

    }

    @FXML
    private void btnDeleteOnAction(Event event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Login Now");
        alert.setHeaderText("Confirm");
        alert.setContentText("Are you sure to delete this item \n to Confirm click ok");
        alert.initStyle(StageStyle.UNDECORATED);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            tblBrand.getItems().clear();
            showDetails();
        }

    }

    public void showDetails() {
        tblCollumId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCollumName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        tblCollumSupplyer.setCellValueFactory(new PropertyValueFactory<>("supplyerName"));
        tblCollumDescription.setCellValueFactory(new PropertyValueFactory<>("brandComment"));
        tblCollumCreator.setCellValueFactory(new PropertyValueFactory<>("creatorId"));
        tblClmDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    Callback<TableColumn<Object, Object>, TableCell<Object, Object>> callback = new Callback<TableColumn<Object, Object>, TableCell<Object, Object>>() {
        @Override
        public TableCell<Object, Object> call(TableColumn<Object, Object> param) {
            final TableCell cell = new TableCell() {

                public void updateItem(Object item, boolean empty) {

                    super.updateItem(item, empty);
                    Text text = new Text();
                    if (!isEmpty()) {
                        text = new Text(item.toString());
                        text.setWrappingWidth(200);
                        text.setFill(Color.BLACK);
                        setGraphic(text);
                    } else if (isEmpty()) {
                        text.setText(null);
                        setGraphic(null);
                    }
                }
            };
            return cell;
        }
    };

    @FXML
    public void tfSearchOnAction(ActionEvent event) {

    }

    private void viewDetails() {

    }

    @FXML
    private void miSearch(ActionEvent event) {
        tblBrand.getSelectionModel().clearSelection();
        tfSearch.requestFocus();
    }

    @FXML
    private void miUpdate(Event event) {
        btnUpdateOnAction(event);
    }

    @FXML
    private void miSeeUpdateHistory(ActionEvent event) {
    }

    @FXML
    private void miDelete(ActionEvent event) {
        btnDeleteOnAction(event);
    }

    @FXML
    private void miAddNew(ActionEvent event) {
        btnAddBrandOnAction(event);
    }

    @FXML
    private void btnRefreshOnAction(ActionEvent event) {
        showDetails();
    }
}
