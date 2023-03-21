import java.util.ArrayList;
import java.util.List;

public class RootsCalculator {
    public static List<Double> calculate_roots(double a, double b, double c) {
        double inf = Double.POSITIVE_INFINITY;
        List<Double> result = new ArrayList<>();
        if(a == 0 && b == 0 && c == 0){
            result.add(inf);
        } else if (a == 0 && b == 0 && c != 0){
            //
        } else if (a== 0 && b != 0){
            result.add((-c/b));
        } else if (a != 0){
            double delta = Math.pow(a, 2) - 4*a*c;
            if(delta < 0){

            } else if (delta == 0){
                result.add(-b/2*a);
            } else if (delta > 0){
                double pierw_delta = Math.pow(delta, 1/2);
                result.add(((-b)-pierw_delta)/2*a);
                result.add(((-b)+pierw_delta)/2*a);
            }
        }

        System.out.println(result);
        return result;
    }

    
    public static void main(String[] args) {
        calculate_roots(1, -5, -6);
    }
}
