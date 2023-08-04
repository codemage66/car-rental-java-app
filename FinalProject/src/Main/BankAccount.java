package Main;

import Money.Dollar;

public class BankAccount implements FileToString {


    public enum AccountType {deposit,creditCard,current}
    private Dollar totalCash = new Dollar(0);
    private int accontNumber;
    private AccountType accountType;

    public BankAccount(double totalCash, int accontNumber, AccountType accountType) {
        setTotalCash(totalCash);
        setAccontNumber(accontNumber);
        setAccountType(accountType);
    }

    public Dollar getTotalCash() {
        return totalCash;
    }

    private void setTotalCash(double totalCash) {
        this.totalCash.setMoney(totalCash);
    }

    public int getAccontNumber() {
        return accontNumber;
    }

    public void setAccontNumber(int accontNumber) {
        this.accontNumber = accontNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void decreaseTotalCash(double decrease){
        setTotalCash(getTotalCash().getMoney() - decrease);
    }
    public void increaseTotalCash(double increase){
        setTotalCash(getTotalCash().getMoney() + increase);
    }
    @Override
    public String fileToString() {
        return null;
    }

}
