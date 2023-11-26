import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] rectangleArr = new int[n][m];
        int[][] rotatedArr = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                rectangleArr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedArr[j][n - 1 - i] = rectangleArr[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rotatedArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}