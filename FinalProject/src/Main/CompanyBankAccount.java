package Main;

import Money.Dollar;

public class CompanyBankAccount extends BankAccount implements FileToString {

    private Dollar carCash = new Dollar(0);
    private Dollar busCash = new Dollar(0);
    private Dollar motorcycleCash = new Dollar(0);
    private Dollar truckCash = new Dollar(0);

    public CompanyBankAccount(double cash, int accontNumber, AccountType accountType) {
        super(cash, accontNumber, accountType);
    }

    public Dollar getCarCash() {
        return carCash;
    }

    private void setCarCash(double carCash) {
        this.carCash.setMoney(carCash);
    }

    public Dollar getBusCash() {
        return busCash;
    }

    private void setBusCash(double busCash) {
        this.busCash.setMoney(busCash);
    }

    public Dollar getMotorcycleCash() {
        return motorcycleCash;
    }

    private void setMotorcycleCash(double motorcycleCash) {
        this.motorcycleCash.setMoney(motorcycleCash);
    }

    public Dollar getTruckCash() {
        return truckCash;
    }

    private void setTruckCash(double truckCash) {
        this.truckCash.setMoney(truckCash) ;
    }

    public void increaseCarCash(double increase){
        setCarCash(getCarCash().getMoney() + increase);
    }
    public void increaseBusCash(double increase){
        setBusCash(getBusCash().getMoney() + increase);
    }
    public void increaseMotorcycleCash(double increase){
        setMotorcycleCash(getMotorcycleCash().getMoney() + increase);
    }
    public void increaseTruckCash(double increase){
        setTruckCash(getTruckCash().getMoney() + increase);
    }
    public void decreaseCarCash(double decrease){
        setCarCash(getCarCash().getMoney() - decrease);
    }
    public void decreaseBusCash(double decrease){
        setBusCash(getBusCash().getMoney() - decrease);
    }
    public void decreaseMotorcycleCash(double decrease) {
        setMotorcycleCash(getMotorcycleCash().getMoney() - decrease);
    }

    public void decreaseTruck(double decrease){
        setTruckCash(getTruckCash().getMoney() - decrease);
    }





    @Override
    public String fileToString() {
        return getTotalCash() + "::" +
                getAccontNumber() + "::" +
                getAccountType();
    }
    public String toString(){
        return getTotalCash() + "::" +
                getAccontNumber() + "::" +
                getAccountType();
    }
}
