import java.util.ArrayList;

public class Shop {
    public static void main(String[] args) throws Exception {
        Fruits f1 = new Fruits();
        Fruits f2 = new Fruits("banan", 10.56, 4, new Batch("2023-03"));
        Fruits f3 = new Fruits("apple", 0.99, 1, new Batch("2025-01"));
        Fruits f4 = new Fruits(f2);
        // Fruits f5 = new Fruits("banan", 10.56, 4, f3.batch); batch private i nie mozna tak
        ArrayList<Fruits> fruits = new ArrayList<>();
        fruits.add(f1);
        fruits.add(f2);
        fruits.add(f3);
        fruits.add(f4);
        // fruits.add(f5);
        
        for(Fruits item : fruits){
            item.display();
        System.out.println("");
        }
    }


}