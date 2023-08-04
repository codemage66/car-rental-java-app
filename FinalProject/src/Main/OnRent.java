package Main;

import Money.*;
import Person.*;
import Vehicle.*;

import java.util.Date;

public class OnRent extends RentHistory implements FileToString {


    private Vehicle vehicle;

    public OnRent(Date rentTime, Date returnTime, double price, Person person, Vehicle vehicle) {
        super(rentTime, returnTime, price, person);
        setVehicle(vehicle);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String fileToString() {
        return getRentTime() + "::" +
                getReturnTime() + "::" +
                getPrice() + "::" +
                getPerson() ;
    }
    public String toString (){
        return getRentTime() + "::" +
                getReturnTime() + "::" +
                getVehicle() + "::" +
                getPrice() + "::" +
                getPerson();
    }
}
