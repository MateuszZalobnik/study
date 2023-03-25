import java.util.ArrayList;

public class Shop {
    public static void main(String[] args) throws Exception {
        Fruits f1 = new Fruits();
        Fruits f2 = new Fruits("banan", 10.56, 4);
        Fruits f3 = new Fruits(f2);
        ArrayList<Fruits> fruits = new ArrayList<>();
        fruits.add(f1);
        fruits.add(f2);
        fruits.add(f3);
        
        for(Fruits item : fruits){
            item.display();
        }
    }


}