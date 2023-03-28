public class Employee {
    public String firstname;
    public String surname;
    public double salary;
    public double tax = 0.17;
    public static void main(String[] args)  {
        AccountantEmployee adam = new AccountantEmployee("Adam", "Wiśniewski", 6000);
        ITEmployee agata = new ITEmployee("Agata", "Wróbel", 7500, 3);
    }
}
