package Vehicle;

import Main.Damage;
import Main.FileToString;
import Main.season;

import java.util.ArrayList;
import java.util.Date;

public class Motorcycle extends Vehicle implements Discount, FileToString {

    public Motorcycle(String modleName, String companyName, double basePrice, Date produceYear, ArrayList<RentHistory> rentedListHistory, String moshakhasatFani, Damage damage) {
        super(modleName, companyName, basePrice, produceYear, rentedListHistory, moshakhasatFani, damage);
        setTypeVehicle(TypeVehicle.Motorcycle);
    }

    @Override
    public double setOff(TimeSpan timeSpan ,season season) {
        double price;

        price = this.getBasePrice();
        if (timeSpan.getName().equals("winter")){
            this.setBasePrice(this.getBasePrice()*0.85);
        }
        return price;
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
                getMoshakhasatFani();
    }

}
