package lab5v1;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class RootsCalculatorTest {

    @Test
    public void test_nr_1() {
        List<Double> actual = RootsCalculator.calculate_roots(1, -5, -6); //statyczne metody mozna wywolywac przez nazwe klasy
        List<Double> expected = Arrays.asList(2.0, 3.0);
        assertEquals(expected, actual); //porownuje dwie podane wartosci
    }

    @Test
    public void test_nr_2() {
        List<Double> actual = RootsCalculator.calculate_roots(1, -4, 4);
        List<Double> expected = Arrays.asList(2.0);
        assertEquals(expected, actual);
    }

    @Test
    public void test_nr_3() {
        List<Double> actual = RootsCalculator.calculate_roots(1, 1, 6);
        List<Double> expected = Arrays.asList();
        assertEquals(expected, actual);
    }

    @Test
    public void test_nr_4() {
        List<Double> actual = RootsCalculator.calculate_roots(0, 1, 7);
        List<Double> expected = Arrays.asList(-6.0);
        assertEquals(expected, actual);
    }

    @Test
    public void test_nr_5() {
        List<Double> actual = RootsCalculator.calculate_roots(0, 0, 6);
        List<Double> expected = Arrays.asList();
        assertEquals(expected, actual);
    }

    @Test
    public void test_nr_6() {
        double inf = Double.POSITIVE_INFINITY;
        List<Double> actual = RootsCalculator.calculate_roots(0, 0, 0);
        List<Double> expected = Arrays.asList(inf);
        assertEquals(expected, actual);
    }
}