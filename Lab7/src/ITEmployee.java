
public class ITEmployee extends Employee {
    private int experience;
    public double bonus = 0;

    public ITEmployee(String firstname, String surname, double salary, int experience) {
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
        this.experience = experience;
        if (experience < 2) {
            bonus = 500;
        } else if (experience < 5) {
            bonus = 2000;
        } else {
            bonus = 5000;
        }
        this.payout = Math.round((salary + bonus) - ((salary + bonus) * this.tax));
        this.display();
    }

    public void display() {
        System.out.println("----------------------");
        System.out.println("stanowisko: " + "pracownik IT");
        System.out.println(this.firstname + " " + this.surname);
        System.out.println("pensja: " + this.salary);
        System.out.println("pensja + premia: " + Math.round(this.salary + bonus));
        System.out.println("doświadczenie: " + this.experience);
        System.out.println("wypłata: " + this.payout);
    }

    // public static void main(){
    //     System.out.println("----------------------");
    //     System.out.println("stanowisko: " + "pracownik IT");
    // } 
}
