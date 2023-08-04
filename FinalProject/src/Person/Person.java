package Person;

import Main.BankAccount;
import Main.FileToString;

import java.util.Date;

public class Person implements FileToString {
    private String firstName ;
    private String lastName ;
    private int id;
    private Date birthDate;
    private BankAccount bankAccount;
    public Person(String firstName, String lastName, int id, Date birthDate, BankAccount bankAccount) {
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
        setBirthDate(birthDate);
        setBankAccount(bankAccount);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String fileToString() {
        return getFirstName() + "::" +
                getLastName() + "::" +
                getId() + "::" +
                getBirthDate();
    }
    public String toString (){
        return getFirstName() + "::" +
                getLastName() + "::" +
                getId() + "::" +
                getBirthDate();
    }
}