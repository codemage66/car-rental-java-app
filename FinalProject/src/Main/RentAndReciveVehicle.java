package Main;

import Person.Person;
import Vehicle.*;

import java.util.ArrayList;
import java.util.Date;

public interface RentAndReciveVehicle {
    ArrayList<OnRent> rentedVehicle = null;
    ArrayList<Vehicle> availableVehicles = null;
    TimeSpan season = null;


    public void rentVehicle(Vehicle vehicle, Date returnTime, Person person);
    public void reciveVehicle();
}
