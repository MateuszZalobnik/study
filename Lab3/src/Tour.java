import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tour {

    public static void printCountries() {
        Map<String, String> Countries = new HashMap<String, String>();// przechowuje pary klucz-wartość w losowej
                                                                      // kolejności

        Countries.put("England", "London");
        Countries.put("USA", "Washington");
        Countries.put("France", "Paris");
        Countries.put("Sweden", "Stockholm");

        // Countries.keySet() zawiera unikalne wartości, które odpowiadają kluczom
        // używanym w mapie. Metoda keySet() pozwala na pobranie wszystkich kluczy z
        // danej mapy
        for (String key : Countries.keySet()) {
            String value = Countries.get(key);
            System.out.println(key + " -> " + value);
        }
        System.out.println("");
        if (Countries.containsKey("Sweden")) {
            System.out.println("kolekcja zawiera Sweden");
        } else {
            System.out.println("kolekcja nie zawiera Sweden");
        }
        System.out.println("\nliczba elementow: " + Countries.size());
    }

    public static void printCities() {
        List<String> Cities = new ArrayList<String>();// przechowuje elementy w porządku, w jakim zostały dodane do
                                                      // listy

        // Cities.add("Paris");
        Cities.add("London");
        Cities.add("Washington");
        Cities.add("Warsaw");
        Cities.add("Berlin");

        for (String value : Cities) {
            System.out.println(value);
        }
        System.out.println("");
        if (Cities.contains("Paris")) {
            System.out.println("kolekcja zawiera Paris");
        } else {
            System.out.println("kolekcja nie zawiera Paris");
        }
        System.out.println("\nliczba elementow: " + Cities.size());
    }

    public static void printUniqueCities() {

        Set<String> UniqueCities = new HashSet<String>();

        // UniqueCities.add("Rome");
        UniqueCities.add("Paris");
        UniqueCities.add("London");
        UniqueCities.add("Washington");
        UniqueCities.add("Warsaw");
        UniqueCities.add("Berlin");
        for (String value : UniqueCities) {
            System.out.println(value);
        }
        System.out.println("");
        if (UniqueCities.contains("Rome")) {
            System.out.println("kolekcja zawiera Rome");
        } else {
            System.out.println("kolekcja nie zawiera Rome");
        }
        System.out.println("\nliczba elementow: " + UniqueCities.size());
    }

    public static void main(String[] args) {
        System.out.println("------------kolekcja a------------");
        printCountries();
        System.out.println("------------kolekcja b------------");
        printCities();
        System.out.println("------------kolekcja c------------");
        printUniqueCities();
    }
}
