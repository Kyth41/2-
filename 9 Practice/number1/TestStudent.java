public class TestStudent {
    public static void main(String[] args) {
        Student1[] students = {
                new Student1("Алиса", 4),
                new Student1("Борис", 2),
                new Student1("Павел", 5),
                new Student1("Дмитрий", 1),
                new Student1("Ева", 3)
        };

        System.out.println("Исходный массив:");
        printArray(students);

        insertionSort(students);

        System.out.println("\nОтсортированный массив (по iDNumber):");
        printArray(students);
    }

    public static void insertionSort(Student1[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Student1 key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getIDNumber() > key.getIDNumber()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(Student1[] arr) {
        for (Student1 s : arr) {
            System.out.println(s);
        }
    }
}