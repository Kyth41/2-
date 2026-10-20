import java.math.BigInteger;
import java.util.Scanner;

public class PrimeTestSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n > 1: ");
        BigInteger n = scanner.nextBigInteger();
        if (n.isProbablePrime(20)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}