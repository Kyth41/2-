package number2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

class Student {
    private String name;
    private int iDNumber;
    private double gpa;
    private String spec;
    private String course;
    private String group;
    private LocalDate birthDate; 

    public Student(String name, int iDNumber, double gpa, String spec, String course, String group, LocalDate birthDate) {
        this.name = name;
        this.iDNumber = iDNumber;
        this.gpa = gpa;
        this.spec = spec;
        this.course = course;
        this.group = group;
        this.birthDate = birthDate;
    }

    public String getName() { return name; }
    public int getIDNumber() { return iDNumber; }
    public double getGpa() { return gpa; }
    public String getSpec() { return spec; }
    public String getCourse() { return course; }
    public String getGroup() { return group; }
    public LocalDate getBirthDate() { return birthDate; }
    
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    /**
     * @param formatType 
     */
    public String getFormattedBirthDate(String formatType) {

        Locale ruLocale = new Locale("ru", "RU");
        DateTimeFormatter formatter;

        switch (formatType.toLowerCase()) {
            case "short":

                formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(ruLocale);
                break;
            case "medium":
                formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(ruLocale);
                break;
            case "full":
                formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(ruLocale);
                break;
            default:

                try {
                    formatter = DateTimeFormatter.ofPattern(formatType).withLocale(ruLocale);
                } catch (IllegalArgumentException e) {
                    formatter = DateTimeFormatter.ISO_LOCAL_DATE; 
                }
        }
        return birthDate.format(formatter);
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', iDNumber=%d, gpa=%.2f, spec='%s', course='%s', group='%s', birthDate='%s'}", 
                name, iDNumber, gpa, spec, course, group, getFormattedBirthDate("short"));
    }
}


public class Main {
    private Student[] iDNumber;

    private final Comparator<Student> gpaComparator = (s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa());

    public void setArray() {
        iDNumber = new Student[]{
            new Student("Алиса", 101, 4.5, "Инженер", "2 Курс", "КРБО-25-25", LocalDate.of(2004, 5, 15)),
            new Student("Борис", 102, 3.2, "Программист", "4 Курс", "ВПБО-14-23", LocalDate.of(2002, 11, 3)),
            new Student("Чарли", 103, 4.9, "Медик", "1 Курс", "ММБО-03-26", LocalDate.of(2005, 1, 22)),
            new Student("Дмитрий", 104, 2.8, "Повар", "2 Курс", "КЛБО-16-25", LocalDate.of(2003, 8, 9)),
            new Student("Ева", 105, 3.7, "Биолог", "3 Курс", "РЗХЗ-23-24", LocalDate.of(2001, 12, 30)),
            new Student("Фёдор", 106, 4.1, "Программист", "1 Курс", "АМВО-24-26", LocalDate.of(2005, 7, 14))
        };
    }

    public void outArray() {
        for (Student s : iDNumber) {
            if (s != null) {
                System.out.println("  " + s);
            }
        }
    }

    public void quicksort() {
        if (iDNumber == null || iDNumber.length < 2) return;
        quickSort(0, iDNumber.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        Student pivot = iDNumber[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (gpaComparator.compare(iDNumber[j], pivot) <= 0) {
                i++;
                Student temp = iDNumber[i];
                iDNumber[i] = iDNumber[j];
                iDNumber[j] = temp;
            }
        }
        Student temp = iDNumber[i + 1];
        iDNumber[i + 1] = iDNumber[high];
        iDNumber[high] = temp;
        return i + 1;
    }

    public void mergeSort() {
        if (iDNumber == null || iDNumber.length < 2) return;
        mergeSortRecursive(iDNumber);
    }

    private void mergeSortRecursive(Student[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        Student[] left = new Student[mid];
        Student[] right = new Student[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        mergeSortRecursive(left);
        mergeSortRecursive(right);
        merge(arr, left, right);
    }

    private void merge(Student[] result, Student[] left, Student[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (gpaComparator.compare(left[i], right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
    }

    public void sortByName() {
        Arrays.sort(iDNumber, Comparator.comparing(Student::getName));
    }

    public static void main(String[] args) {
        Main tester = new Main();
        
        tester.setArray();
        
        System.out.println("=== Исходный список студентов (с датой рождения) ===");
        tester.outArray();

        System.out.println("\n=== Демонстрация форматов даты для первого студента ===");
        Student firstStudent = tester.iDNumber[0];
        System.out.println("Короткий формат: " + firstStudent.getFormattedBirthDate("short"));
        System.out.println("Средний формат:  " + firstStudent.getFormattedBirthDate("medium"));
        System.out.println("Полный формат:   " + firstStudent.getFormattedBirthDate("full"));
        System.out.println("Свой формат:     " + firstStudent.getFormattedBirthDate("dd/MM/yyyy"));

        tester.quicksort();
        System.out.println("\n=== После быстрой сортировки (QuickSort) по GPA (убывание) ===");
        tester.outArray();
    }
}