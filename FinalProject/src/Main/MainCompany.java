package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import IO.MyFile;
import Person.*;
import Vehicle.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainCompany extends Application {
    
    public MainCompany() {
    }

    @Override
    public void start(Stage primaryStage) {
//        CompanyBankAccount companyBankAccount = new CompanyBankAccount(10000,21348, BankAccount.AccountType.current);
//        ArrayList<VehicleShop> vehicleShops = new ArrayList<>();
//        ArrayList<Personnel> personnels = new ArrayList<>();
//        BankAccount bankAccount = new BankAccount(10000,21354, BankAccount.AccountType.current);
//        Personnel personnel = new Personnel("ad","sdasd",231,new Date(2465,4,8),0, "Employee",bankAccount);
//        personnels.add(personnel);
//        ArrayList rentedHistory = new ArrayList();
//        Vehicle vehicle = new Car("sad","fdgsdg",354654,new Date(314,5,6),rentedHistory,"sadd",new Damage(3546,"sada"), Car.Type.sport);
//        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
//        vehicles.add(vehicle);
//        VehicleShop vehicleShop = new VehicleShop("ffd", personnels,vehicles);
//        Garage garage = new Garage("sadas",personnels,vehicles);
//        ArrayList<Garage> garages = new ArrayList<>();
//        garages.add(garage);
//        VehicleCompany vehicleCompany = new VehicleCompany(companyBankAccount,vehicleShops,garages);
//        System.out.println(vehicleCompany.toString());
        Parent root = null;
        try {
            MyFile myFile = new MyFile();
            root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Welcome to MainCompany -Login");
            primaryStage.getIcons().add(new Image("/image/icon.png"));
            primaryStage.setMaximized(true);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
