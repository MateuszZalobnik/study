
public class App {
    public static void main(String[] args) throws Exception {
        // char[][] board;
        // board = new char[16][16];
        // for (int i = 0; i < 16; i++) {
        // for (int j = 0; j < 16; j++) {
        // board[i][j] = '_';
        // }
        // }

        // board[6][9] = 'g';
        // board[9][6] = 'g';

        // String[][] carBoard;
        // carBoard = new String[16][16];
        // for (int i = 0; i < 16; i++) {
        // for (int j = 0; j < 16; j++) {
        // System.out.print(board[i][j]);
        // }
        // System.out.println("");
        // }

        // Create cars

        Car[] board;
        board = new Car[16];
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        board[0] = car1;
        board[1] = car2;
        board[2] = car3;
        board[3] = car3;
        board[4] = car3;

        TrafficLight trafficLight = new TrafficLight("red");

        for (int timeStep = 0; timeStep < 50; timeStep++) {

            if (timeStep % 2 == 0) {
                if (trafficLight.getState().equals("green")) {
                    trafficLight.setState("red");
                } else {
                    trafficLight.setState("green");
                }
            }

            for (int i = 15; i >= 0; i--) {
                if (board[i] != null) {
                    if (i == 15) {
                        board[i] = null;
                    } else if (i == 10) {
                        if (board[i + 1] == null && trafficLight.getState().equals("green")) {
                            board[i + 1] = board[i];
                            board[i] = null;
                        }
                    } else {
                        if (board[i + 1] == null) {
                            board[i + 1] = board[i];
                            board[i] = null;
                        }
                    }
                }
            }

            for (int i = 0; i < 16; i++) {
                if (board[i] == null) {
                    System.out.print("-");
                } else {
                    System.out.print(">");
                }
            }
            System.out.println("");
        }
    }
}
