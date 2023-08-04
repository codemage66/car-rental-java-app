package Vehicle;

import Main.Damage;
import Main.FileToString;
import Main.season;

import java.util.ArrayList;
import java.util.Date;

public class Bus extends Vehicle implements FileToString {


    public Bus(String modleName, String companyName, double basePrice, Date produceYear, ArrayList<RentHistory> rentedListHistory, String moshakhasatFani, Damage damage) {
        super(modleName, companyName, basePrice, produceYear, rentedListHistory, moshakhasatFani,damage);
        setTypeVehicle(TypeVehicle.Bus);
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

    @Override
    public double setOff(TimeSpan timeSpan, season season) {
        return 0;
    }
}
