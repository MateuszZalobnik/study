import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics;  
import java.awt.Color;
import java.awt.GridLayout;

class MyJComponent extends JComponent {  
    public void paint(Graphics g) {  
      g.setColor(Color.red);  
    //   g.setBounds(400, 325, 550, 100);  
    //   g.fillRect(400, 325, 550, 100);  
    }  
}  

public class StaticDisplay {
    public static void main(String[] args) {
        // Create a JFrame object to hold the display window

        JFrame frame = new JFrame("Traffic Agent Based Model");

        // Set the size of the window
        frame.setSize(800, 800);
        // Create a JLabel component to display the static content
        // JLabel label = new JLabel("Hello, World!");
        // label.setBounds(10, 10, 200, 30); // Set the position and size of the label



        
        
        JPanel board = new JPanel();
        board.setBounds(0, 0, 400, 400);
        board.setLayout(new GridLayout(10, 10)); // Use GridLayout to arrange components in a grid
        // board.setBackground(Color.green);
        for (int row = 9; row >= 0; row--) {
            for (int col = 0; col < 10; col++) {
                JLabel label2 = new JLabel((char)('A' + col) + "" + (row + 1));
                board.add(label2);
            }
        }


        // JPanel roadHorizontal = new JPanel();
        MyJComponent roadHorizontal = new MyJComponent();  
        roadHorizontal.setBackground(Color.gray);
        roadHorizontal.setBounds(400, 325, 550, 100);
        roadHorizontal.setBounds(0, 225, 550, 100);
        board.add(roadHorizontal);
        // Add the label to the frame
        // frame.add(label);
        frame.add(board);
        // frame.add(roadHorizontal);

        // Set the layout manager of the frame to null for absolute positioning
        frame.setLayout(null);

        // Set the default close operation of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);
    }
}