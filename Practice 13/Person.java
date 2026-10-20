public class Person {
    private final String surname;
    private final String firstName;
    private final String middleName;
    
    private final String cachedFIO; 

    public Person(String surname, String firstName, String middleName) {
        this.surname = (surname != null) ? surname : "";
        this.firstName = firstName;
        this.middleName = middleName;
        
        this.cachedFIO = buildFIO();
    }

    private String buildFIO() {

        StringBuilder sb = new StringBuilder(this.surname.length() + 5);
        sb.append(this.surname);

        boolean hasFirst = isNotEmpty(this.firstName);
        boolean hasMiddle = isNotEmpty(this.middleName);

        if (hasFirst) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(this.firstName.trim().charAt(0)).append('.');
        }
        
        if (hasMiddle) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }
            sb.append(this.middleName.trim().charAt(0)).append('.');
        }

        return sb.toString();
    }


    private static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public String getFIO() {
        return cachedFIO;
    }

    public static void main(String[] args) {
        Person p1 = new Person("<Иванов>", "Иван", "Иванович");
        Person p2 = new Person("Петров", "Петр", null); 
        Person p3 = new Person("Сидоров", "", "Сидорович");   
        Person p4 = new Person("Смирнов", null, null);       
        
        System.out.println(p1.getFIO());
        System.out.println(p2.getFIO());
        System.out.println(p3.getFIO());
        System.out.println(p4.getFIO()); 
    }
}