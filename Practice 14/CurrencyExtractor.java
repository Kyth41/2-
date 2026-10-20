import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyExtractor {
    public static void main(String[] args) {
        String text = "Прайс-лист: 25.98 USD, 1500 RUB, 44 ERR, 0.004 EsaeU, " +
                      "10.5 EU, 999 USDT, 3.14 RUB.";

        String regex = "\\b\\d+(\\.\\d{1,2})?\\s+(USD|RUB|EU)\\b";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные корректные цены:");
        while (matcher.find()) {
            System.out.println("- " + matcher.group());
        }
    }
}