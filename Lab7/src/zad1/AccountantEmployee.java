package zad1;

public class AccountantEmployee extends Employee {
    public AccountantEmployee (String firstname, String surname, double salary){
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
        this.payout = Math.round((salary * 1.1) - ((salary * 1.1) * this.tax));
        display();
    }

    public void display(){
        System.out.println("----------------------");
        System.out.println("stanowisko: " + "księgowy");
        System.out.println(this.firstname + " " + this.surname);
        System.out.println("pensja: " + this.salary);
        System.out.println("pensja + premia: " + Math.round(this.salary*1.1));
        System.out.println("wypłata: " + this.payout);
    }
}
