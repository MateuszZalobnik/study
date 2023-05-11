import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.awt.Color;

public class StaticDisplay {
    public static void main(String[] args) {
        ArrayList<Car> listOfCars;
        listOfCars = new ArrayList<>();

        for (int i = 0; i < 18; i++) {
            Car c = new Car();
            listOfCars.add(c);
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Traffic Agent Based Model");
            frame.setSize(MoveModel.width*20+400, MoveModel.width*20);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel greenBoard = new JPanel(null);
            greenBoard.setBackground(Color.GREEN);
            greenBoard.setBounds(400, 0, MoveModel.width*20, MoveModel.width*20);
            Road road = new Road(listOfCars);
            road.setBounds(0, (MoveModel.width*20/2)-25, MoveModel.width*20, 50);
            greenBoard.add(road);
            frame.add(greenBoard);

            frame.setLayout(null);
            frame.setVisible(true);
        });
    }
}
