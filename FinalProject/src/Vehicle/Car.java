package Vehicle;

import Main.Damage;
import Main.FileToString;
import Main.season;

import java.util.ArrayList;
import java.util.Date;

public class Car extends Vehicle implements FileToString {

    @Override
    public double setOff(TimeSpan timeSpan, season season) {
        return 0;
    }

    public enum Type {sport,economic,luxury}
    private Type type ;

    public Car(String modleName, String companyName, double basePrice, Date produceYear, ArrayList<RentHistory> rentedListHistory, String moshakhasatFani, Damage damage, Type type) {
        super(modleName, companyName, basePrice, produceYear, rentedListHistory, moshakhasatFani, damage);
        setTypeVehicle(TypeVehicle.Car);
        setType(type);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String fileToString() {
        return "Vehicle" + "%" +
                getModleName() + "%" +
                getMotorNumber() + "%" +
                getCompanyName() + "%" +
                getBasePrice() + "%" +
                getProductionYear() + "%" +
                getRentedListHistory() + "%" +
                getMoshakhasatFani() ;
    }

}

