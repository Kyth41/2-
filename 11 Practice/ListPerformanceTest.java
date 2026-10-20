import java.util.*;

public class ListPerformanceTest {

    private static final int N = 100_000;
    private static final int REPEATS = 5;

    public static void main(String[] args) {
        System.out.printf("Тестирование на %,d элементах, усреднение по %d прогонам%n%n", N, REPEATS);

        System.out.println("=============================================================");
        System.out.printf("%-35s %15s %15s%n", "Операция", "ArrayList (мс)", "LinkedList (мс)");
        System.out.println("=============================================================");

        measure("add() в конец",          ListPerformanceTest::addToEnd);
        measure("add(0, ...) в начало",   ListPerformanceTest::addToStart);
        measure("add(N/2, ...) в середину", ListPerformanceTest::addToMiddle);
        measure("get(index) поиск по индексу", ListPerformanceTest::getByIndex);
        measure("contains() поиск по образцу", ListPerformanceTest::containsValue);
        measure("remove(0) из начала",    ListPerformanceTest::removeFromStart);
        measure("remove(N/2) из середины", ListPerformanceTest::removeFromMiddle);
        measure("remove(объект) поиск+удаление", ListPerformanceTest::removeByValue);

        System.out.println("=============================================================");
    }


    private interface Operation {
        long run(List<Integer> list, int fillCount);
    }

    private static void measure(String name, Operation op) {
        long arrayListTime  = timeIt(() -> op.run(new ArrayList<>(),  N));
        long linkedListTime = timeIt(() -> op.run(new LinkedList<>(), N));

        System.out.printf("%-35s %15d %15d%n", name, arrayListTime, linkedListTime);
    }

    private static long timeIt(java.util.function.LongSupplier supplier) {
        long total = 0;
        for (int i = 0; i < REPEATS; i++) {
            long start = System.nanoTime();
            supplier.getAsLong();
            total += System.nanoTime() - start;
        }
        return (total / REPEATS) / 1_000_000; 
    }


    private static long addToEnd(List<Integer> list, int fillCount) {
        for (int i = 0; i < fillCount; i++) list.add(i);
        return list.size();
    }

    private static long addToStart(List<Integer> list, int fillCount) {
        for (int i = 0; i < fillCount; i++) list.add(0, i);
        return list.size();
    }

    private static long addToMiddle(List<Integer> list, int fillCount) {
        for (int i = 0; i < fillCount; i++) list.add(list.size() / 2, i);
        return list.size();
    }

    private static long getByIndex(List<Integer> list, int fillCount) {
        for (int i = 0; i < fillCount; i++) list.add(i);
        long sum = 0;
        for (int i = 0; i < fillCount; i++) sum += list.get(i);
        return sum;
    }

    private static long containsValue(List<Integer> list, int fillCount) {
        for (int i = 0; i < fillCount; i++) list.add(i);
        int found = 0;
        for (int i = 0; i < 1000; i++) {
            if (list.contains(fillCount - 1)) found++; 
        }
        return found;
    }

    private static long removeFromStart(List<Integer> list, int fillCount) {
        for (int i = 0; i < fillCount; i++) list.add(i);
        for (int i = 0; i < fillCount; i++) list.remove(0);
        return list.size();
    }

    private static long removeFromMiddle(List<Integer> list, int fillCount) {
        for (int i = 0; i < fillCount; i++) list.add(i);
        for (int i = 0; i < fillCount; i++) list.remove(list.size() / 2);
        return list.size();
    }

    private static long removeByValue(List<Integer> list, int fillCount) {
        for (int i = 0; i < fillCount; i++) list.add(i);
        for (int i = 0; i < fillCount; i++) list.remove(Integer.valueOf(i));
        return list.size();
    }
}