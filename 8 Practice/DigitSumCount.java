//Задание 4
import java.util.Scanner;

public class DigitSumCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите k (количество цифр): ");
        int k = sc.nextInt();

        System.out.print("Введите s (искомая сумма цифр): ");
        int s = sc.nextInt();

        long result = countNumbers(k, s);
        System.out.println("Количество " + k + "-значных чисел с суммой цифр " + s + ": " + result);

        sc.close();
    }
    public static long countNumbers(int k, int s) {
        if (k <= 0) {
            return 0;
        }
        if (s < 1 || s > 9 * k) {
            return 0;
        }
        long[] prev = new long[s + 1];
        prev[0] = 1;

        for (int pos = 0; pos < k - 1; pos++) {
            long[] cur = new long[s + 1];
            for (int sum = 0; sum <= s; sum++) {
                if (prev[sum] == 0) continue;
                for (int digit = 0; digit <= 9 && sum + digit <= s; digit++) {
                    cur[sum + digit] += prev[sum];
                }
            }
            prev = cur;
        }
        long total = 0;
        for (int first = 1; first <= 9; first++) {
            if (s - first >= 0) {
                total += prev[s - first];
            }
        }
        return total;
    }
}