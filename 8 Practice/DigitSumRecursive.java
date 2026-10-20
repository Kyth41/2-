//Задание 5
import java.util.Scanner;

public class DigitSumRecursive {

    public static long sumDigits(long n) {
        if (n < 10) {
            return n;
        }
        return (n % 10) + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число N: ");
        long n = scanner.nextLong();

        System.out.println("Сумма цифр числа " + n + " = " + sumDigits(n));

        scanner.close();
    }
}