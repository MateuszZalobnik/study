public class Fib {
    public static void main(String[] args) {
        System.out.println(fibbI(4));
        System.out.println(fibbR(6));
    }

    public static int fibbI(int n) {
        int a = 0;
        int b = 1;
        int result = 0;
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n >= 3) {

            for (int i = 0; i < n - 2; i++) {
                result = a + b;
                a = b;
                b = result;
            }
            return result;
        } else {
            return -1;
        }
    }

    public static int fibbR(int n) {
        if (n < 1) {
            return -1;
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibbR(n - 1) + fibbR(n - 2);
        }
    }

}
