import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class TaskInfo {

    public static void main(String[] args) throws Exception {

        String developer = "Botsmanov";

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date receivedDate = sdf.parse("10.10.2026 09:00:00");

        Date submitDate = new Date();  

        System.out.println("Фамилия разработчика:            " + developer);
        System.out.println("Дата и время получения задания: " + sdf.format(receivedDate));
        System.out.println("Дата и время сдачи задания:     " + sdf.format(submitDate));
    }
}