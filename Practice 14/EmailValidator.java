import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)*[a-zA-Z0-9-]+$";
        
        String[] emails = {
            "user@example.com",  
            "root@localhost",     
            "myhost@@@com.ru",   
            "@my.ru",             
            "Julia String"        
        };

        System.out.println("Проверка e-mail адресов:\n");

        for (String email : emails) {
            boolean isValid = Pattern.matches(regex, email);
            String status = isValid ? "Допустимый" : "Неверный";
            System.out.printf("%-20s -> %s%n", email, status);
        }
    }
}