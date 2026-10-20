import java.util.*;
import java.text.SimpleDateFormat;

public class DateAndCalendarFromInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        System.out.println("Введите данные в формате: <Год> <Месяц> <Число> <Часы> <Минуты>");
        System.out.print("Например: 2026 10 10 09 30\n> ");

        int year   = sc.nextInt(); 
        int month  = sc.nextInt(); 
        int day    = sc.nextInt(); 
        int hour   = sc.nextInt();  
        int minute = sc.nextInt();  

        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);       
        cal.clear();  

        cal.set(year, month - 1, day, hour, minute, 0);
        cal.set(Calendar.MILLISECOND, 0);

        try {
            Date dateFromCalendar = cal.getTime();

            @SuppressWarnings("deprecation")
            Date dateDirect = new Date(year - 1900, month - 1, day, hour, minute);

            System.out.println("\n--- Результат ---");
            System.out.println("Calendar:              " + fmt.format(cal.getTime()));
            System.out.println("Date из Calendar:      " + fmt.format(dateFromCalendar));
            System.out.println("Date (конструктор):    " + fmt.format(dateDirect));
            System.out.println("Миллисекунды Calendar: " + cal.getTimeInMillis());
            System.out.println("Миллисекунды Date:     " + dateDirect.getTime());

        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка: введена несуществующая дата или неверное время.");
        }

        sc.close();
    }
}