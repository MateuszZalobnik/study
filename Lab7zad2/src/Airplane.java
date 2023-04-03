
public class Airplane implements Transport {
    public double calculateCost(double distance){
        double cost = 0;
        cost = 0.01 * Math.pow(distance, 2);
        return cost;
    }
}
