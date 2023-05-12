import java.util.ArrayList;
import java.util.Random;

public class MoveModel {
    private ArrayList<Car> AllCars; // all cars
    private int MaxTimeReaction = 0; // max time reaction
    private int MinTimeReaction = 0; // min time reaction
    private int trafficLightsTime = 9; // traffic lights time change
    private boolean reverse = false; // true = move right to left
   
   
    private static int positionYLeftToRight = 32; //y position
    private static int positionYRightToLeft = 5; //y position
    private Car[] board;
    private ArrayList<Car> listOfCars;
    private TrafficLight trafficLight;
    private int timeStep = 0;
    public static int boardWidth = 40;

    MoveModel(int numberOfCars, boolean reverse, int MinTimeReaction, int MaxTimeReaction, int trafficLightsTime) {
        this.MinTimeReaction = MinTimeReaction;
        this.MaxTimeReaction = MaxTimeReaction;
        this.trafficLightsTime = trafficLightsTime;
        this.reverse = reverse;
        this.trafficLight = new TrafficLight("green");
        this.board = new Car[boardWidth];
        this.AllCars = new ArrayList<>();
        this.listOfCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            Car car = new Car();
            Random random = new Random();
            if (MaxTimeReaction > 0) {
                int randomReaction = random.nextInt(MaxTimeReaction) + MinTimeReaction; // reaction between min and max;
                car.setReaction(randomReaction);
            }
            this.AllCars.add(car);
        }

    }

    public TrafficLight getLight() {
        return this.trafficLight;
    }

    public ArrayList<Car> move() {
        listOfCars.clear();
        if (timeStep % trafficLightsTime == 0) {
            if (this.trafficLight.getState().equals("green")) {
                this.trafficLight.setState("red");
            } else {
                this.trafficLight.setState("green");
            }
        }

        for (int i = boardWidth - 1; i >= 0; i--) {
            if (board[i] != null) {
                if (i == boardWidth - 1) {
                    board[i] = null;
                } else if (i == MoveModel.boardWidth / 2 - 5) {
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
                        } else {
                            board[i].currentReactionDecrease();
                        }
                    } else {
                        board[i].setIsMoving(false);
                    }
                }
            }
        }

        if (AllCars.size() > 0 && board[0] == null) { // new car from list appear on road
            board[0] = AllCars.get(0);
            AllCars.remove(0);
        }

        for (int i = 0; i < boardWidth; i++) {
            if (board[i] != null) {
                board[i].setPosition(i, this.positionYLeftToRight);
                listOfCars.add(board[i]);
            }
        }

        if (this.reverse) {
            reverseCoordination();
        }

        // for (Car item : listOfCars) {
        // System.out.print("car:");
        // System.out.println(item.getPositionX());
        // }
        // System.out.println("");
        timeStep++;
        return this.listOfCars;
    }

    public void reverseCoordination() {
        for (Car car : listOfCars) {
            int x = car.getPositionX();
            int y = this.positionYRightToLeft;
            car.setPosition(boardWidth - x - 1, y);
        }
    }

}
