import java.util.Arrays;

public class Main {
    private static int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};
    private static int sum = 0;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int number : numbers) {
                sum += number;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Phan tu lon nhat trong mang la: " + max);
        System.out.println("Tong cua cac phan tu trong mang la: " + sum);
    }
}
