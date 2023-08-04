package Main;

import Money.*;
import Person.*;
import Vehicle.*;
import java.util.*;

public class VehicleCompany implements FileToString, RentAndReciveVehicle , Discount {

    CompanyBankAccount companyBankAccount;
    ArrayList<VehicleShop> vehicleShops = new ArrayList<>();
    ArrayList<Garage> garages = new ArrayList<>();

    public VehicleCompany(CompanyBankAccount companyBankAccount, ArrayList<VehicleShop> vehicleShops, ArrayList<Garage> garages) {
        setCompanyBankAccount(companyBankAccount);
        setVehicleShops(vehicleShops);
        setGarages(garages);
    }

    public CompanyBankAccount getCompanyBankAccount() {
        return companyBankAccount;
    }

    public void setCompanyBankAccount(CompanyBankAccount companyBankAccount) {
        this.companyBankAccount = companyBankAccount;
    }

    public ArrayList<VehicleShop> getVehicleShops() {
        return vehicleShops;
    }

    public void setVehicleShops(ArrayList<VehicleShop> vehicleShops) {
        this.vehicleShops = vehicleShops;
    }

    public ArrayList<Garage> getGarages() {
        return garages;
    }

    public void setGarages(ArrayList<Garage> garages) {
        this.garages = garages;
    }

    public void addVehicle(Vehicle vehicle , VehicleShop vehicleShop){
        vehicleShop.addVehicle(vehicle);
    }

    public void addVehicle(Vehicle vehicle , Garage garage){
        garage.addVehicle(vehicle);
    }

    public void removeVehicle(Vehicle vehicle , VehicleShop vehicleShop){
        vehicleShop.removeVehicle(vehicle);
    }
    public void removeVehicle(Vehicle vehicle , Garage garage){
        garage.removeVehicle(vehicle);
    }
    public void editVehicle(Garage garage, String vehicleType, String modelName, double motorNumber, String companyName, double basePrice, Date productionYear, ArrayList<RentHistory> rentedListHistory, String moshakhasatFani, Damage damage, Car.Type type) {
        garage.removeVehicle(motorNumber);
        Vehicle vehicle = detectVehicle( vehicleType, modelName, companyName, basePrice,  productionYear, rentedListHistory, moshakhasatFani, damage,type);
        garage.addVehicle(vehicle);
    }
    public void editVehicle(VehicleShop vehicleShop, String vehicleType, String modelName, double motorNumber, String companyName, double basePrice, Date productionYear, ArrayList<RentHistory> rentedListHistory, String moshakhasatFani, Damage damage, Car.Type type){
        vehicleShop.removeVehicle(motorNumber);
        Vehicle vehicle = detectVehicle( vehicleType, modelName, companyName, basePrice,  productionYear, rentedListHistory, moshakhasatFani, damage,type);
        vehicleShop.addVehicle(vehicle);
    }
    public ArrayList<Vehicle> getVehicleList(){
        return availableVehicles;
    }

    public void addVehicleShop(VehicleShop vehicleShop){
        this.vehicleShops.add(vehicleShop);
    }
    public void removeShop(VehicleShop vehicleShop){
        this.vehicleShops.remove(vehicleShop);
    }
    public void addGarage(Garage garage){
        this.garages.add(garage);
    }
    public void removeGarage(Garage garage){
        this.garages.remove(garage);
    }
    public void addPersonnel(Personnel personnel, VehicleShop vehicleShop){
        vehicleShop.addPersonnel(personnel);
    }
    public void addPersonnel(Personnel personnel, Garage garage){
        garage.addPersonnel(personnel);
    }
    public void removePersonnel(Personnel personnel, Garage garage){
        garage.removePersonnel(personnel);
    }
    public void removePersonnel(Personnel personnel, VehicleShop vehicleShop){
        vehicleShop.removePersonnel(personnel);
    }
    @Override
    public void rentVehicle(Vehicle vehicle, Date returnTime, Person person){
        TimeSpan timeSpan = timeDifference(returnTime);
        Date date = new Date();
        season season = seasonDetect();
        double price = vehicle.getBasePrice();
        price = setOff(timeSpan, season);
        RentHistory rentHistory = new RentHistory(date, returnTime, price, person);
        OnRent onRent = new OnRent(date,returnTime,price,person,vehicle);
        vehicle.addRentedListHistory(rentHistory);
        rentedVehicle.add(onRent);
        availableVehicles.remove(vehicle);
    }

    @Override


    public void reciveVehicle(){

    }
    public void vehicleRepair(Vehicle vehicle, Person person){
        person.getBankAccount().decreaseTotalCash(vehicle.getDamage().getDamageAmount().getMoney());
        detectVehicleForincrease(vehicle, vehicle.getDamage().getDamageAmount().getMoney());
        vehicle.setDamage(new Damage(0,null));
    }
//    public void rentHistory(){
//
//    }
    public ArrayList<OnRent>  getVehicleRentedList(){
        return rentedVehicle;
    }
    public Dollar getIncomFromCars(){
        return companyBankAccount.getCarCash();
    }
    public Dollar getIncomFromBuses(){
        return companyBankAccount.getBusCash();
    }
    public Dollar getIncomFromTruck(){
        return companyBankAccount.getTruckCash();
    }
    public Dollar getIncomFromMotorcycle(){
        return companyBankAccount.getMotorcycleCash();
    }

    private Vehicle detectVehicle(String vehicleType, String modelName, String companyName, double basePrice, Date productionYear, ArrayList<RentHistory> rentedListHistory, String moshakhasatFani, Damage damage, Car.Type type){
        Vehicle vehicle;
        if(vehicleType.equals("Car")){
            vehicle = new Car(modelName, companyName, basePrice, productionYear, rentedListHistory, moshakhasatFani, damage, type);
        }else if(vehicleType.equals("Bus")){
            vehicle = new Bus(modelName, companyName, basePrice, productionYear, rentedListHistory, moshakhasatFani, damage);
        }else if (vehicleType.equals("Motorcycle")){
            vehicle = new Motorcycle(modelName, companyName, basePrice, productionYear, rentedListHistory, moshakhasatFani, damage);
        }else{
            vehicle = new Truck(modelName, companyName, basePrice, productionYear, rentedListHistory, moshakhasatFani, damage);
        }
        return vehicle;
    }

    private void detectVehicleForincrease(Vehicle vehicle,double damag ){
        if (vehicle.getTypeVehicle().name().equals("Car")){
            companyBankAccount.increaseCarCash(damag);
        }else if(vehicle.getTypeVehicle().name().equals("Bus")){
            companyBankAccount.increaseBusCash(damag);
        }else if(vehicle.getTypeVehicle().name().equals("Motorcycle")){
            companyBankAccount.increaseMotorcycleCash(damag);
        }else{
            companyBankAccount.increaseTruckCash(damag);
        }
    }

    private TimeSpan timeDifference(Date returnTime){
            int dayDifference;
        int temp;
        int monthDifference;
        int hoursDifference;
        int yearDifference;
        Date now = new Date();
        if(returnTime.after(now)){
            hoursDifference = Math.abs(returnTime.getMinutes() - now.getMonth());
            dayDifference = Math.abs(returnTime.getDate() - now.getDate());
            monthDifference = Math.abs(returnTime.getMonth() - now.getMonth());
            yearDifference = Math.abs(returnTime.getYear() - now.getYear());
            temp = Integer.valueOf(hoursDifference/24);
            dayDifference += temp;
            temp = Integer.valueOf(dayDifference/30);
            monthDifference += temp;
            if (monthDifference > 1){
                return TimeSpan.monthly;
            }
            temp = Integer.valueOf(monthDifference/12);
            yearDifference += temp;
            if(yearDifference > 1){
                return TimeSpan.yearly;
            }


        }
        return null;
    }
    private season seasonDetect(){
        Date date = new Date();
        if((date.getMonth() == 1 ) || (date.getMonth() == 2 ) || (date.getMonth() == 3 )){
            return Main.season.spring;
        }else
        if((date.getMonth() == 4 ) || (date.getMonth() == 5 ) || (date.getMonth() == 6 )){
            return Main.season.summer;
        }else
        if((date.getMonth() == 7 ) || (date.getMonth() == 8 ) || (date.getMonth() == 9 )){
            return Main.season.autumn;
        }else
        if((date.getMonth() == 10 ) || (date.getMonth() == 11 ) || (date.getMonth() == 12 )){
            return Main.season.winter;
        }
        return null;
    }

    @Override
    public String fileToString() {
         return companyBankAccount + "@@" +
                vehicleShops + "@@" +
                garages;
    }
    public String toString(){
        return companyBankAccount + "@@" +
                vehicleShops + "@@" +
                garages;
    }


    @Override
    public double setOff(TimeSpan timeSpan, Main.season season) {
        return 0;
    }
}
