public class PhoneFormatter {

    public static String formatPhoneNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер не может быть пустым");
        }

        String phone = input.trim();
        
        String countryCode;
        String mainNumber;

        if (phone.startsWith("8")) {
            if (phone.length() != 11) {
                throw new IllegalArgumentException("Неверная длина российского номера (ожидается 11 цифр)");
            }
            countryCode = "7"; 
            mainNumber = phone.substring(1); 
        } else if (phone.startsWith("+")) {
            if (phone.length() < 12) { 
                throw new IllegalArgumentException("Слишком короткий международный номер");
            }
            mainNumber = phone.substring(phone.length() - 10);
            countryCode = phone.substring(1, phone.length() - 10);
        } else {
            throw new IllegalArgumentException("Неизвестный формат номера. Должен начинаться с '+' или '8'");
        }

        if (!mainNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Номер должен содержать ровно 10 цифр");
        }

        String formattedBody = mainNumber.substring(0, 3) + "-" 
                             + mainNumber.substring(3, 6) + "-" 
                             + mainNumber.substring(6);

        return "+" + countryCode + formattedBody;
    }

    public static void main(String[] args) {
        String[] testNumbers = {
            "+79175655655",
            "+104289652211",
            "88005553535",
            "8 917 565 56 55" 
        };

        for (String num : testNumbers) {
            try {

                String cleanNum = num.replaceAll("\\s+", ""); 
                String result = formatPhoneNumber(cleanNum);
                System.out.printf("Входной номер: %-15s -> Выходной формат: %s%n", num, result);
            } catch (IllegalArgumentException e) {
                System.out.printf("Входной номер: %-15s -> Ошибка: %s%n", num, e.getMessage());
            }
        }
    }
}