package Money;

import Main.FileToString;

public abstract class Money implements FileToString {

    private double money;

    public Money(double money) {
        setMoney(money);
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if(money > 0) {
            this.money = money;
        }
    }
}
