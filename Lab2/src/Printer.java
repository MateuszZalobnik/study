public class Printer {
    public static void main(String[] args) {
        print_even(10);
    }

    public static void print_even(int N) {
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
