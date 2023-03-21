import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FeaturesCalculator {
    private ArrayList<ArrayList<Integer>> binary_mask;
    private Integer[] mass_center;
    private String filename;

    public FeaturesCalculator(String filename) {
        this.filename = filename;
        read_data(filename);
        calculate_mass_center();
    }

    public void read_data(String currentFilename) {
        try {
            File data = new File(currentFilename);
            Scanner fileScanner = new Scanner(data);
            binary_mask = new ArrayList<ArrayList<Integer>>();
            while (fileScanner.hasNextLine()) {
                ArrayList<Integer> row = new ArrayList<>();
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(" ");
                for (String value : lineArray) {
                    row.add(Integer.parseInt(value));
                }
                binary_mask.add(row);
                System.out.println(line);
            }
            System.out.println("\n" + binary_mask);
            fileScanner.close();

        } catch (FileNotFoundException err) {
            System.out.println(currentFilename + " not found");
        }
    }

    public void calculate_mass_center() {
        this.mass_center = new Integer[2];
        this.mass_center[0] = 0;
        this.mass_center[1] = 0;
        int x = 0;
        int y = 0;
        int n = 0;
        for (ArrayList<Integer> arrayList : binary_mask) {
            y++;
            for (Integer integer : arrayList) {
                x++;
                if (integer == 1) {
                    System.out.print("(" + x + ", " + y + ")");
                    n++;
                    this.mass_center[0] = (x + this.mass_center[0]);
                    this.mass_center[1] = (y + this.mass_center[1]);
                }
            }
            x = 0;
        }
        System.out.println("");
        this.mass_center[0] = this.mass_center[0] / n;
        this.mass_center[1] = this.mass_center[1] / n;
        System.out.println("mass center: (" + this.mass_center[0] + ", " + this.mass_center[1] + ")");
    }

    public void save_results() {
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter a filename: ");
        // String value = scanner.nextLine();
        String value = "binary_mask_2.txt";
        FeaturesCalculator obj = new FeaturesCalculator(value);
        // scanner.close();

        // obj.read_data("binary_mask_1.txt");

    }
}