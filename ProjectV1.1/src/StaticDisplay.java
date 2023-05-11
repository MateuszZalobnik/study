import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.awt.Color;

public class StaticDisplay {
    public static void main(String[] args) {
        ArrayList<Car> listOfCars;
        listOfCars = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Car c = new Car();
            listOfCars.add(c);
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Traffic Agent Based Model");
            frame.setSize(1000, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel greenBoard = new JPanel(null);
            greenBoard.setBackground(Color.GREEN);
            greenBoard.setBounds(450, 150, 500, 500);
            Road road = new Road(listOfCars);
            road.setBounds(0, 225, 500, 50);
            greenBoard.add(road);
            frame.add(greenBoard);

            frame.setLayout(null);
            frame.setVisible(true);
        });
    }
}
