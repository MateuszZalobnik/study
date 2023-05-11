import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> listOfCars;
        listOfCars = new ArrayList<>();

        for (int i = 0; i < 18; i++) {
            Car c = new Car();
            listOfCars.add(c);
        }

        Car[] board;
        board = new Car[16];

        TrafficLight trafficLight = new TrafficLight("red");

        for (int timeStep = 0; timeStep < 50; timeStep++) {

          

            if (timeStep % 5 == 0) {
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

            if (listOfCars.size() > 0 && board[0] == null) { // new car from list appear on road
                board[0] = listOfCars.get(0);
                listOfCars.remove(0);
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
