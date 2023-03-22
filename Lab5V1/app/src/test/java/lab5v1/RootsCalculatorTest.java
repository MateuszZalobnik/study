package lab5v1;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class RootsCalculatorTest {
    @Test
    public void test1(){

    }

    @Test
    public void testCalculateRootsOneRoot() {
        RootsCalculator calculator = new RootsCalculator();
        List<Double> roots = calculator.calculate_roots(1, -4, 4);
        double[] expectedArray = roots.stream().mapToDouble(Double::doubleValue).toArray();
        assertArrayEquals(new double[]{2}, expectedArray, 0.001);
    }
}
