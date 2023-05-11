import java.util.ArrayList;
import java.util.Random;

public class MoveModel {
    private ArrayList<Car> AllCars; // all cars
    private int MaxTimeReaction = 4; // free space between cars

    private Car[] board;
    private ArrayList<Car> listOfCars;
    private TrafficLight trafficLight;
    private int timeStep = 0;
    public static int width = 40;

    MoveModel(ArrayList<Car> AllInitialCars) {
        this.trafficLight = new TrafficLight("green");
        this.board = new Car[width];
        this.AllCars = new ArrayList<>();
        this.listOfCars = new ArrayList<>();
        for (Car car : AllInitialCars) {
            Random random = new Random();
            int randomReaction = random.nextInt(MaxTimeReaction)+2; // reaction between 0 and max;
            car.setReaction(randomReaction);
            this.AllCars.add(car);
        }
    }

    public TrafficLight getLight() {
        return this.trafficLight;
    }

    public ArrayList<Car> move() {
        listOfCars.clear();
        if (timeStep % 9 == 0) {
            if (this.trafficLight.getState().equals("green")) {
                this.trafficLight.setState("red");
            } else {
                this.trafficLight.setState("green");
            }
        }

        for (int i = width - 1; i >= 0; i--) {
            if (board[i] != null) {
                if (i == width - 1) {
                    board[i] = null;
                } else if (i == MoveModel.width / 2 - 5) {
                    if (board[i + 1] == null && this.trafficLight.getState().equals("green")) {
                        board[i].setIsMoving(true);
                        if (board[i].getCurrentReaction() == 0) {
                            board[i + 1] = board[i];
                            board[i] = null;
                        } else {
                            board[i].currentReactionDecrease();
                        }
                    } else {
                        board[i].setIsMoving(false);
                    }
                } else {
                    if (board[i + 1] == null) {
                        board[i].setIsMoving(true);
                        if (board[i].getCurrentReaction() == 0) {
                            board[i + 1] = board[i];
                            board[i] = null;
                        } 
                        else {
                            board[i].currentReactionDecrease();
                        }
                    } 
                    else {
                        board[i].setIsMoving(false);
                    }

                    // if (board[i + 1] == null) {
                    // board[i + 1] = board[i];
                    // board[i] = null;
                    // }
                }
            }
        }

        if (AllCars.size() > 0 && board[0] == null) { // new car from list appear on road
            board[0] = AllCars.get(0);
            AllCars.remove(0);
        }

        // add all cars from board to list with position
        for (int i = 0; i < width; i++) {
            if (board[i] != null) {

                board[i].setPosition(i * 20, 32);
                listOfCars.add(board[i]);
            }
        }
        // for (Car item : listOfCars) {
        // System.out.print("car:");
        // System.out.println(item.getPositionX());
        // }
        // System.out.println("");
        timeStep++;
        return this.listOfCars;
    }

}
