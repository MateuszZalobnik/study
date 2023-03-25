
public class Fruits {
    public static int countStatic_ = 0; //odnosi się do całej klasy
    // public int countNonStatic_ = 0; odnosi się do obiektu

    public static int idStatic_ = 0;
    // public int idNonStatic_ = 0;


    private String name;
    private double price;
    private int amount;
    private int id;

    public Fruits() {
        countStatic_++;
        idStatic_++;
        this.name = "ERROR";
        this.price = -1;
        this.amount = -1;
        this.id = idStatic_;
        System.out.println("Default values");
    }

    public Fruits(String name, double price, int amount) {
        countStatic_++;
        idStatic_++;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.id = idStatic_;
        System.out.println("owoc: " + name);
        System.out.println("cena: " + price);
        System.out.println("ilosc: " + amount);
    }

    public Fruits(Fruits copy) {
        countStatic_++;
        idStatic_++;
        this.name = copy.name;
        this.price = copy.price;
        this.amount = copy.amount;
        this.id = idStatic_;
        System.out.println("Utworzono kopie: " + name);
    }

    public void display() {
        System.out.println("id: " + id + " name: " + name + " price: " + price + " amount: " + amount);
    }
}
