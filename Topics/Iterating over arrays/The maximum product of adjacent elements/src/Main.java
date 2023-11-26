import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = createArr(size, scanner);
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] arr) {
            int max = 0;
            int product = 0;
            if (arr.length > 1) {
                for (int i = 0; i < arr.length - 1; i++) {
                    product = arr[i] * arr[i+1];
                    if (max < product) {
                        max = product;
                    }
                }
            }
            return max;
        }
    public static int[] createArr(int size, Scanner scanner) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}