package Main;

import Money.Dollar;
import Vehicle.Vehicle;

import java.util.concurrent.CountDownLatch;

public class Damage implements FileToString {

    private Dollar damageAmount = new Dollar(0);
    private String crashDescribtion;

    public Damage(double damageAmount, String crashDescribtion) {
        setDamageAmount(damageAmount);
        setCrashDescribtion(crashDescribtion);
    }

    public Dollar getDamageAmount() {
        return damageAmount;
    }

    public void setDamageAmount(double damageAmount) {
        this.damageAmount.setMoney(damageAmount);
    }

    public String getCrashDescribtion() {
        return crashDescribtion;
    }

    public void setCrashDescribtion(String crashDescribtion) {
        this.crashDescribtion = crashDescribtion;
    }

    @Override
    public String fileToString() {
        return getDamageAmount() + "::" +
                getCrashDescribtion();
    }

    public String toString (){
        return getDamageAmount() + "::" +
                getCrashDescribtion();
    }
}
