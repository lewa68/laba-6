package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        int[] array = createRandomArray(10);
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        Collections.sort(list);
        System.out.println("Sorted list (ascending): " + list);
        Collections.reverse(list);
        System.out.println("Sorted list (descending): " + list);
        Collections.shuffle(list);
        System.out.println("Shuffled list: " + list);
        List<Integer> shiftedList = cyclicShift(list);
        System.out.println("Cyclically shifted list: " + shiftedList);
        Set<Integer> uniqueSet = new HashSet<>(list);
        System.out.println("Unique elements: " + uniqueSet);
        Set<Integer> duplicatesSet = new HashSet<>();
        for (Integer num : list) {
            if (Collections.frequency(list, num) > 1) {
                duplicatesSet.add(num);
            }
        }
        System.out.println("Duplicate elements: " + duplicatesSet);
        Integer[] arrayFromList = list.toArray(new Integer[0]);
        System.out.println("Array from list: " + Arrays.toString(arrayFromList));

        // Задание 2
        PrimesGeneratorTest.testPrimesGenerator(10);

        // Задание 3
        List<Human> humans = Arrays.asList(
                new Human("John", "Doe", 30),
                new Human("Jane", "Doe", 25),
                new Human("John", "Smith", 35)
        );
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet: " + hashSet);
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet: " + treeSet);
        Set<Human> treeSetWithComparator = new TreeSet<>(new HumanComparatorByLastName());
        treeSetWithComparator.addAll(humans);
        System.out.println("TreeSet with comparator: " + treeSetWithComparator);
        Set<Human> treeSetWithAnonymousComparator = new TreeSet<>(Comparator.comparing(Human::getAge));
        treeSetWithAnonymousComparator.addAll(humans);
        System.out.println("TreeSet with anonymous comparator: " + treeSetWithAnonymousComparator);

        // Задание 4
        String text = "This is a test. This test is only a test.";
        Map<String, Integer> wordFrequency = WordFrequencyCounter.countWordFrequency(text);
        System.out.println("Word frequency: " + wordFrequency);

        // Задание 5
        Map<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "One");
        originalMap.put(2, "Two");
        originalMap.put(3, "Three");
        Map<String, Integer> reversedMap = WordFrequencyCounter.reverseMap(originalMap);
        System.out.println("Reversed map: " + reversedMap);
    }

    private static int[] createRandomArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }

    private static List<Integer> cyclicShift(List<Integer> list) {
        if (list.isEmpty()) {
            return list;
        }
        Integer first = list.remove(0);
        list.add(first);
        return list;
    }
}