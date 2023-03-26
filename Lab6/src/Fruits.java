
public class Fruits {
    private Batch batch;
    public static int countStatic_ = 0; // odnosi się do całej klasy
    // public int countNonStatic_ = 0; odnosi się do obiektu

    public static int idStatic_ = 0; //Jeśli klasa główna ma dostęp do pól statycznych, ale nie ma do nich dostępu z poziomu instancji (obiektów) danej klasy, to może wyświetlać wartości tych pól, ale nie może ich modyfikować
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
        this.batch = new Batch("ERROR");
        System.out.println("Default values");
    }

    public Fruits(String name, double price, int amount, Batch batch) {
        countStatic_++;
        idStatic_++;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.id = idStatic_;
        this.batch = batch;
    }

    public Fruits(Fruits copy) {
        countStatic_++;
        idStatic_++;
        this.name = copy.name;
        this.price = copy.price;
        this.amount = copy.amount;
        this.id = idStatic_;
        this.batch = copy.batch;
        System.out.println("Utworzono kopie: " + name);
    }

    public void display() {
        System.out.print("id: " + id + " name: " + name + " price: " + price + " amount: " + amount + " ");
        batch.display();
    }
}

class Batch {
    private String batch_nr;

    public Batch(String batch_nr) {
        this.batch_nr = batch_nr;
        System.out.println("Utworzono partię nr: " + this.batch_nr);
    }

    public void display(){
        System.out.print(" partia: " + this.batch_nr);
    }
}