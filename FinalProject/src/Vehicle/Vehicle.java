package Vehicle;

import Main.Damage;
import Main.FileToString;
import Main.season;
import Money.Dollar;

import java.util.ArrayList;
import java.util.Date;

public abstract class Vehicle implements Discount, FileToString {

    private String modleName;
    private static double motorNumber =8648;
    private String companyName;
    private Dollar basePrice = new Dollar(0);
    private Date productionYear;
    private ArrayList<RentHistory> rentedListHistory = new ArrayList<RentHistory>();
    private String moshakhasatFani;
    private Damage damage;
    private TypeVehicle typeVehicle;


    public Vehicle(String modleName, String companyName, double basePrice, Date productionYear, ArrayList<RentHistory> rentedListHistory, String moshakhasatFani, Damage damage) {
        motorNumber++;
        setModleName(modleName);
        setCompanyName(companyName);
        setBasePrice(basePrice);
        setProductionYear(productionYear);
        setRentedListHistory(rentedListHistory);
        setMoshakhasatFani(moshakhasatFani);
        setDamage(damage);
    }


    public double getBasePrice() {
        return basePrice.getMoney();
    }

    public String getModleName() {
        return modleName;
    }

    public void setModleName(String modleName) {
        this.modleName = modleName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBasePrice(double basePrice) {
        if(basePrice > 0) {
            this.basePrice.setMoney(basePrice);
        }
    }

    public Date getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Date productionYear) {
        this.productionYear = productionYear;
    }

    public String getMoshakhasatFani() {
        return moshakhasatFani;
    }

    public void setMoshakhasatFani(String moshakhasatFani) {
        this.moshakhasatFani = moshakhasatFani;
    }

    public double getMotorNumber() {
        return motorNumber;
    }

    public void setMotorNumber(double motorNumber) {
        if(motorNumber > 0) {
            this.motorNumber = motorNumber;
        }
    }
    public boolean equals (Vehicle vehicle){
        if(this.getMotorNumber() == vehicle.getMotorNumber()){
            return true;
        }else{
            return false;
        }
    }
    public boolean equals (double motorNumber){
        if(this.getMotorNumber() == motorNumber){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public double setOff(TimeSpan timeSpan , season season) {
        if(this.typeVehicle.getName().equals("Motorcycle")){
            if(season.getName().equals("winter")){
                this.setBasePrice(this.getBasePrice()*0.85);
            }
        }
        if (timeSpan.getName().equals("yearly")) {
            this.basePrice.setMoney(this.basePrice.getMoney() * 0.8);
        } else if (timeSpan.getName().equals("monthly")) {
            this.basePrice.setMoney(this.basePrice.getMoney() * 0.9);
        }

        return basePrice.getMoney();
    }

    public ArrayList<RentHistory> getRentedListHistory() {
        return rentedListHistory;
    }

    public void setRentedListHistory(ArrayList<RentHistory> rentedListHistory) {
        this.rentedListHistory = rentedListHistory;
    }

    public void addRentedListHistory(RentHistory rent){
        this.rentedListHistory.add(rent);
    }

    public void removeRentedListHistory(RentHistory rent){
        this.rentedListHistory.remove(rent);
    }
    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public TypeVehicle getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicle typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    @Override
    public String fileToString() {
        return "Vehicle" + "%" +
                getModleName() + "%" +
                getMotorNumber() + "%" +
                getCompanyName() + "%" +
                getBasePrice() + "%" +
                getProductionYear() + "%" +
                getRentedListHistory().toString() + "%" +
                getMoshakhasatFani() ;

    }

    public String toString (){
        return "Vehicle" + "%" +
                getModleName() + "%" +
                getMotorNumber() + "%" +
                getCompanyName() + "%" +
                getBasePrice() + "%" +
                getProductionYear() + "%" +
                getRentedListHistory().toString() + "%" +
                getMoshakhasatFani() ;
    }
}
