public class StringTask {

    public static void main(String[] args) {
        String text = "I like Java!!!";
        System.out.println("Исходная строка: \"" + text + "\"\n");

        analyzeString(text);
    }

    public static void analyzeString(String str) {
        
        char lastChar = str.charAt(str.length() - 1);
        System.out.println("2. Последний символ строки: '" + lastChar + "'");

        boolean endsWith = str.endsWith("!!!");
        System.out.println("3. Строка заканчивается на \"!!!\": " + endsWith);

        boolean startsWith = str.startsWith("I like");
        System.out.println("4. Строка начинается с \"I like\": " + startsWith);


        boolean contains = str.contains("Java");
        System.out.println("5. Строка содержит \"Java\": " + contains);

        int indexOfJava = str.indexOf("Java");
        System.out.println("6. Позиция (индекс) подстроки \"Java\": " + indexOfJava);

        String replaced = str.replace('a', 'o');
        System.out.println("7. Замена всех 'a' на 'o': \"" + replaced + "\"");

        String upperCase = str.toUpperCase();
        System.out.println("8. Верхний регистр: \"" + upperCase + "\"");

        String lowerCase = str.toLowerCase();
        System.out.println("9. Нижний регистр: \"" + lowerCase + "\"");


        String javaSubstring = str.substring(indexOfJava, indexOfJava + 4);
        System.out.println("10. Вырезанная подстрока: \"" + javaSubstring + "\"");
    }
}