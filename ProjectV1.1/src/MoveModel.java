import java.util.ArrayList;

public class MoveModel {
    private Car[] board;
    private ArrayList<Car> AllCars;
    private ArrayList<Car> listOfCars;
    private TrafficLight trafficLight;
    private int timeStep = 0;

    MoveModel(ArrayList<Car> AllInitialCars) {
        this.trafficLight = new TrafficLight("red");
        this.board = new Car[50];
        this.AllCars = new ArrayList<>();
        this.listOfCars = new ArrayList<>();
        for (Car car : AllInitialCars) {
            this.AllCars.add(car);
        }
    }

    public ArrayList<Car> move() {
        listOfCars.clear();
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
            if (board[i] != null) {

                board[i].setPosition(i*10, 32);
                listOfCars.add(board[i]);
            }
        }
        for (Car item : listOfCars) {
            System.out.print("car:");
            System.out.println(item.getPositionX());
        }
        System.out.println("");
        return this.listOfCars;
    }

}
