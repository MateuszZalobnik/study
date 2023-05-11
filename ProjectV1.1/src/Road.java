import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Road extends JPanel {
    private static final Color ROAD_COLOR = Color.DARK_GRAY;
    private static final Color SQUARE_COLOR = Color.BLUE;
    private static final Color MARKING_COLOR = Color.WHITE;

    private List<Point> squareCoordinates;

    public Road(ArrayList<Car> listOfCars) {
        squareCoordinates = new ArrayList<>();

        for (Car item : listOfCars) {
            int x = item.getPositionX();
            int y = item.getPositionY();
            System.out.println("x" + x + " y" + y);
            squareCoordinates.add(new Point(x, y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the background color of the panel to green
        setBackground(ROAD_COLOR);


        // Draw the marks on the board
        for (int i = 0; i < 500; i += 30) {
            g.setColor(MARKING_COLOR);
            g.fillRect(i, 24, 20, 2);
        }

        // Draw the squares on the board
        for (Point coordinate : squareCoordinates) {
            int x = coordinate.x;
            int y = coordinate.y;

            g.setColor(SQUARE_COLOR);
            g.fillRect(x, y, 15, 12); // Adjust the size of the square as needed
        }
    }
}
