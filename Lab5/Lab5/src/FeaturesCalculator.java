import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FeaturesCalculator {
    private ArrayList<ArrayList<Integer>> binary_mask;
    private Integer[] mass_center;
    private String filename;

    public FeaturesCalculator(String filename) {
        this.filename = filename;
        read_data(this.filename);
        calculate_mass_center();
        save_results();
    }

    public void read_data(String currentFilename) {
        try {
            File data = new File(currentFilename);
            Scanner fileScanner = new Scanner(data);
            binary_mask = new ArrayList<ArrayList<Integer>>();
            while (fileScanner.hasNextLine()) { //do ostatniej linii
                ArrayList<Integer> row = new ArrayList<>(); //wiersz jako arraylista
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(" ");
                for (String value : lineArray) {
                    row.add(Integer.parseInt(value));
                }
                binary_mask.add(row);
                // System.out.println(line);
            }
            // System.out.println("\n" + binary_mask);
            fileScanner.close();

        } catch (FileNotFoundException err) { //jezeli nie znajdzie pliku
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
                    // System.out.print("(" + x + ", " + y + ")");
                    n++;
                    this.mass_center[0] = (x + this.mass_center[0]);
                    this.mass_center[1] = (y + this.mass_center[1]);
                }
            }
            x = 0;
        }
        // System.out.println("");
        this.mass_center[0] = this.mass_center[0] / n;
        this.mass_center[1] = this.mass_center[1] / n;
        // System.out.println("mass center: (" + this.mass_center[0] + ", " + this.mass_center[1] + ")");
    }

    public void save_results() {
        try {
            File resultFile = new File(filename.replace(".", "_out."));
            FileWriter writer = new FileWriter(resultFile);
            writer.write("P = (" + this.mass_center[0] + ", " + this.mass_center[1] + ")");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean filenameCheck(String currentFilename) {
        String[] words = currentFilename.split("\\.");
        String[] firstSegment;
        if (words.length != 2) {
            return false;
        } else {
            firstSegment = words[0].split("_");
        }

        if (!words[1].equals("txt")) {
            return false;
        } else if (firstSegment.length != 3) {
            return false;
        } else if (!firstSegment[0].equals("binary") || !firstSegment[1].equals("mask")) {
            return false;
        } else if (Integer.parseInt(firstSegment[2]) > 3 || Integer.parseInt(firstSegment[2]) < 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String value = scanner.nextLine();
        // String value = "binary_mask_3.txt";
        Boolean check = filenameCheck(value);
        if (check == true) {
            FeaturesCalculator obj = new FeaturesCalculator(value);
        } else {
            System.out.println("zla nazwa pliku");
        }
        scanner.close();
    }
}