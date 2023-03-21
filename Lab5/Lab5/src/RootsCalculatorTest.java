import org.junit.Test;
import static org.junit.Assert.*;

public class RootsCalculatorTest {
    @Test
    public void test1(){

    }

    @Test
    public void testCalculateRootsOneRoot() {
        RootsCalculator calculator = new RootsCalculator();
        double[] roots = calculator.calculateRoots(1, -4, 4);
        assertArrayEquals(new double[]{2}, roots, 0.001);
    }
}
