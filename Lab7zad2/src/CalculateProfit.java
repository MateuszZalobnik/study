
public class CalculateProfit {
    
    public static double profit(double pay,double cost){
        System.out.println(pay-cost);
        return (pay-cost);
    }
    public static void main(String[] args) {
        Train train = new Train();
        Airplane airplane = new Airplane();
        profit(10, train.calculateCost(200));
        profit(50, airplane.calculateCost(50));
        profit(40, airplane.calculateCost(30));
        profit(45, airplane.calculateCost(350));
        profit(45, train.calculateCost(350));
    }
}
