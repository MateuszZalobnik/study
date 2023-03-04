public class Triangle {
    public static void main(String[] args) {
        print_triangle(8);
    }

    public static void print_triangle(int N) {
        int[][] rows = new int[N][(2 * N - 1)];
        rows[0][((2 * N) / 2 - 1)] = 1;
        rows[1][(2 * N) / 2 - 2] = 1;
        rows[1][(2 * N) / 2] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j < (2 * N - 1); j++) {
                if (j == 0) {
                    if (i == (N - 1)) {
                        rows[i][j] = 1;
                    }
                } else if (j == (2 * N - 1) - 1) {
                    if (i == (N - 1)) {
                        rows[i][j] = 1;
                    }
                } else {
                    rows[i][j] = rows[i - 1][j - 1] + rows[i - 1][j + 1];
                }
            }
        }

        for (

                int i = 0; i < N; i++) {
            for (int j = 0; j < (2 * N - 1); j++) {
                System.out.printf("%3d", rows[i][j]);
            }
            System.out.println("");
        }
    }
}
