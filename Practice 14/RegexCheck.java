public class RegexCheck {
    public static void main(String[] args) {
        String regex = "^abcdefghijklmnopqrstuv18340$";

        String validStr = "abcdefghijklmnopqrstuv18340";
        
        String invalidStr = "abcdefghijklmnoasdfasdpqrstuv18340.";

        boolean isValid = validStr.matches(regex);
        boolean isInvalid = invalidStr.matches(regex);

        System.out.println("Строка: \"" + validStr + "\"");
        System.out.println("Соответствует регулярному выражению? " + isValid); // true
        System.out.println();
        
        System.out.println("Строка: \"" + invalidStr + "\"");
        System.out.println("Соответствует регулярному выражению? " + isInvalid); // false
    }
}