package Main;

import Person.Personnel;
import Vehicle.Vehicle;

import java.util.ArrayList;

public class Garage implements FileToString{

    private String name;
    private ArrayList<Personnel> personnels;
    private ArrayList<Vehicle> vehicles ;

    public Garage(String name, ArrayList<Personnel> personnels, ArrayList<Vehicle> vehicles) {
        this.name = name;
        this.personnels = personnels;
        this.vehicles = vehicles;
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

    public void addPersonnel(Personnel personnel){
        this.personnels.add(personnel);
    }
    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
    public void removePersonnel(Personnel personnel){
        this.personnels.remove(personnel);
    }
    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }
    public void removeVehicle(double motorNumber) {
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
    public String fileToString() {
        return "Garage" + "$$" +
                getName() + "---" +
                getPersonnels() + "---" +
                getVehicles();
    }
    public String toString (){
        return "Garage"+ "$$" +
                getName() + "---" +
                getPersonnels() + "---" +
                getVehicles();
    }
}
