package Vehicle;

import Main.Damage;
import Main.FileToString;
import Money.Dollar;
import Person.Person;

import java.util.Date;

public class RentHistory implements FileToString{

        private Date rentTime;
        private Date returnTime;
        private Dollar price = new Dollar(0);
        private Person person;

        public RentHistory(Date rentTime, Date returnTime, double price, Person person) {
            setRentTime(rentTime);
            setReturnTime(returnTime);
            setPrice(price);
            setPerson(person);
        }

        public Date getRentTime() {
            return rentTime;
        }

        public void setRentTime(Date rentTime) {
            this.rentTime = rentTime;
        }

        public Date getReturnTime() {
            return returnTime;
        }

        public void setReturnTime(Date returnTime) {
            if(returnTime.after(rentTime)) {
                this.returnTime = returnTime;
            }
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public Dollar getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price.setMoney(price);
        }

        @Override
        public String fileToString() {
            return getRentTime() + "::" +
                    getReturnTime() + "::" +
                    getPrice() + "::" +
                    getPerson();
        }
        public String toString(){
            return getRentTime() + "::" +
                    getReturnTime() + "::" +
                    getPrice() + "::" +
                    getPerson();
        }



}
