package Money;

import Main.FileToString;

public class Dollar extends Money implements FileToString {



    public Dollar(int money) {
        super(money);
    }

    @Override
    public String fileToString() {
        return String.valueOf(this.getMoney());
    }
    public String toString (){
        return String.valueOf(this.getMoney());
    }
}
