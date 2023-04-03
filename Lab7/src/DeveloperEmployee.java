
public class DeveloperEmployee extends ITEmployee {
    public DeveloperEmployee(String firstname, String surname, double salary, int experience) {
        super(firstname, surname, salary, experience);
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
        this.payout = Math.round((salary + bonus) - ((salary + bonus) * (this.tax / 2)));

        System.out.println("stanowisko: " + "programista");
        System.out.println("wypłata po uldze: " + this.payout);
    }

}
