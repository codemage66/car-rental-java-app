package Person;

import Main.BankAccount;
import Main.FileToString;
import Money.Dollar;

import java.util.Date;

public class Personnel extends Person implements FileToString {

    public enum Post {Boss, Vicar, Secretary, Employee }

    private Dollar salary = new Dollar(0);
    private String post;

    public Personnel(String firstName, String lastName, int id, Date age, double salary, String post, BankAccount bankAccount) {
        super(firstName, lastName, id, age, bankAccount);
        setSalary(salary);
        setPost(post);
    }

    public Dollar getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary.setMoney(salary);
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String fileToString() {
        return getFirstName() + "::" +
                getLastName() + "::" +
                getId() + "::" +
                getBirthDate() + "::" +
                getSalary() + "::" +
                getPost();
    }
    public String toString (){
        return getFirstName() + "::" +
                getLastName() + "::" +
                getId() + "::" +
                getBirthDate() + "::" +
                getSalary() + "::" +
                getPost();
    }
}
