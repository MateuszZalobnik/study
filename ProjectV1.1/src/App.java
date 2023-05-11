import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> AllCars;
        ArrayList<Car> listOfCars;
        AllCars = new ArrayList<>();
        listOfCars = new ArrayList<>();

        for (int i = 0; i < 18; i++) {
            Car c = new Car();
            AllCars.add(c);
        }

        Car[] board;
        board = new Car[50];

        TrafficLight trafficLight = new TrafficLight("red");

        for (int timeStep = 0; timeStep < 50; timeStep++) {

            if (timeStep % 5 == 0) {
                if (trafficLight.getState().equals("green")) {
                    trafficLight.setState("red");
                } else {
                    trafficLight.setState("green");
                }
            }

            for (int i = 49; i >= 0; i--) {
                if (board[i] != null) {
                    if (i == 49) {
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

            if (AllCars.size() > 0 && board[0] == null) { // new car from list appear on road
                board[0] = AllCars.get(0);
                AllCars.remove(0);
            }

            for (int i = 0; i < 50; i++) {
                if (board[i] == null) {
                    System.out.print("-");
                } else {
                    board[i].setPosition(i * 10, 32);
                    System.out.print(">");
                    listOfCars.add(board[i]);
                }
            }
            System.out.println("");

            listOfCars.clear();
        }

    }
}
