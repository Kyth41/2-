import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateComparator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        sdf.setLenient(false);85 25 26
        

        Date userDate = null;

        while (userDate == null) {
            System.out.print("Введите дату и время (формат dd.MM.yyyy HH:mm:ss): ");
            String input = scanner.nextLine().trim();
            try {
                userDate = sdf.parse(input);
            } catch (ParseException e) {
                System.out.println("Ошибка: неверный формат или несуществующая дата. Попробуйте снова.\n");
            }
        }

        Date now = new Date();

        System.out.println("\n--- Результат сравнения ---");
        System.out.println("Введённая дата:   " + sdf.format(userDate));
        System.out.println("Текущее время:    " + sdf.format(now));


        int cmp = userDate.compareTo(now);

        if (cmp < 0) {
            System.out.println("→ Введённая дата находится в ПРОШЛОМ относительно текущего времени.");
        } else if (cmp > 0) {
            System.out.println("→ Введённая дата находится в БУДУЩЕМ относительно текущего времени.");
        } else {
            System.out.println("→ Введённая дата СОВПАДАЕТ с текущим временем.");
        }

        long diffMillis = Math.abs(now.getTime() - userDate.getTime());
        long seconds = diffMillis / 1000;
        long days    = seconds / 86400;
        long hours   = (seconds % 86400) / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs    = seconds % 60;

        System.out.printf("Разница: %d дн. %02d:%02d:%02d%n", days, hours, minutes, secs);

        scanner.close();
    }
}