public class ITEmployee extends Employee {
    private double payout;
    private int experience;

    public ITEmployee(String firstname, String surname, double salary, int experience) {
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
        this.experience = experience;
        if (experience < 2) {
            this.payout = Math.round((salary + 500) - ((salary + 500) * this.tax));
        } else if (experience < 5) {
            this.payout = Math.round((salary + 2000) - ((salary + 2000) * this.tax));
        } else {
            this.payout = Math.round((salary + 5000) - ((salary + 5000) * this.tax));
        }
        display();
    }

    public void display() {
        System.out.println("----------------------");
        System.out.println("stanowisko: " + "pracownik IT");
        System.out.println(this.firstname + " " + this.surname);
        System.out.println("pensja: " + this.salary);
        System.out.println("doświadczenie: " + this.experience);
        System.out.println("wypłata: " + payout);
    }
}
