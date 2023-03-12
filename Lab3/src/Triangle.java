public class Triangle {
    public static void print_triangle(int N) {
        if (N < 2) { //jeżeli liczba rzędów jest mniejsza niż 2 to blad
            System.out.println("zla liczba");
            return;
        }
        int[][] rows = new int[N][(2 * N - 1)]; //deklaracja tablicy rzedow o wilekosci [liczba rzedow][liczba rzedow * 2 -1]
        rows[0][((2 * N) / 2 - 1)] = 1; // dodanie pierwszych wartosci do trojkata
        rows[1][(2 * N) / 2 - 2] = 1;
        rows[1][(2 * N) / 2] = 1;

        //wersja z zerami wszędzie
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
        //wersja z zermai w trojkacie
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (2 * N - 1); j++) {
                // if (rows[i][j] == 0) {
                    // System.out.printf("   ");
                // } else {

                    System.out.printf("%3d", rows[i][j]);
                // }
            }
            System.out.println("");
        }
        for (int i = 0; i < N; i++) {

            for(int k = 0; k<(N-i-1); k++){
                System.out.printf("   ");
            }
            for (int j = N-i-1; j < (N+i); j++) {
                    System.out.printf("%3d", rows[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        print_triangle(8);
    }
}
