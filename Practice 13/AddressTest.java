public class AddressTest {
    public static void main(String[] args) {
        
        System.out.println("--- Тест 1: Метод split() (только запятая) ---");
        String addressStr1 = "Россия, Московская область, Москва, Тверская, 1, 2, 3";
        System.out.println("Исходная строка: " + addressStr1);
        Address addr1 = Address.parseWithSplit(addressStr1);
        System.out.println(addr1);

        System.out.println("--- Тест 2: Метод split() (лишние пробелы, мало данных) ---");
        String addressStr2 = "  Беларусь  ,   Минская обл. , Минск   ,  пр. Независимости  , 10 ";
        System.out.println("Исходная строка: " + addressStr2);
        Address addr2 = Address.parseWithSplit(addressStr2);
        System.out.println(addr2);

        System.out.println("--- Тест 3: Метод StringTokenizer (запятые и точки с запятой) ---");
        String addressStr3 = "Казахстан; Алматинская обл.; Алматы, Абая; 15 - 3, 45";
        System.out.println("Исходная строка: " + addressStr3);
        Address addr3 = Address.parseWithTokenizer(addressStr3);
        System.out.println(addr3);

        System.out.println("--- Тест 4: Метод StringTokenizer (тире и точки с запятой) ---");
        String addressStr4 = "Германия - Бавария; Мюнхен - Мариенплац; 1 - А - 101";
        System.out.println("Исходная строка: " + addressStr4);
        Address addr4 = Address.parseWithTokenizer(addressStr4);
        System.out.println(addr4);
    }
}