package Main;

import Person.Person;
import Person.Personnel;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Date;

public class VehicleShop implements FileToString, RentAndReciveVehicle {

    private String name;
    private ArrayList<Personnel> personnels = new ArrayList<>();
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    public VehicleShop(String name, ArrayList<Personnel> personnels, ArrayList<Vehicle> vehicles) {
        setName(name);
        setPersonnels(personnels);
        setVehicles(vehicles);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(ArrayList<Personnel> personnels) {
        this.personnels = personnels;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String fileToString() {
        return getName() + "++" +
                getPersonnels() + "++" +
                getVehicles();
    }
    public String toString(){
        return getName() + "++" +
                getPersonnels() + "++" +
                getVehicles();
    }

    public void addPersonnel(Personnel personnel){
        this.personnels.add(personnel);
    }
    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
    public void removePersonnel(Personnel personnel){
        this.personnels.remove(personnel);
    }
    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }
    public void removeVehicle(double motorNumber){
        Vehicle vehicle = searchVehicle(motorNumber);
        this.vehicles.remove(vehicle);
    }
    private Vehicle searchVehicle(double motorNumber){
        for(int i = 0 ; i < vehicles.size() ; i++){
            if(vehicles.get(i).equals(motorNumber)){
                return vehicles.get(i);
            }
        }
        return null;
    }


    @Override
    public void rentVehicle(Vehicle vehicle, Date returnTime, Person person) {

    }

    @Override
    public void reciveVehicle() {

    }
}
