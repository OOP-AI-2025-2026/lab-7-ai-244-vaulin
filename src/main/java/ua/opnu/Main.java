package ua.opnu;

import java.util.function.*;
import java.util.*;

public class Main {
    static Student[] filter(Student[] students, Predicate<Student> p) {
        return Arrays.stream(students)
                .filter(p)
                .toArray(Student[]::new);
    }

    static int[] filter(int[] arr, Predicate<Integer> p1, Predicate<Integer> p2) {
        return java.util.Arrays.stream(arr)
                .filter(i -> p1.test(i) && p2.test(i))
                .toArray();
    }

    static void doIf(int[] arr, Predicate<Integer> condition, Consumer<Integer> action) {
        for (int n : arr)
            if (condition.test(n))
                action.accept(n);
    }

    static int[] process(int[] arr, Function<Integer, Integer> func) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            res[i] = func.apply(arr[i]);
        return res;
    }

    static String[] stringify(int[] arr, Function<Integer, String> func) {
        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
            res[i] = func.apply(arr[i]);
        return res;
    }

    public static void main(String[] args) {
        // task1
        Predicate<Integer> isPrime = n -> {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };

        int[] testNumbers = {1, 2, 3, 4, 5, 10, 13, 17, 18};

        for (int n : testNumbers) {
            System.out.printf("%d -> %b%n", n, isPrime.test(n));
        }

        // task2
        Student[] students = {
                new Student("S1", "G1", new int[]{80, 90, 75}),
                new Student("S2", "G2", new int[]{50, 40, 70}),
                new Student("3", "G3", new int[]{60, 60, 60})
        };

        Predicate<Student> hasDebt = s -> {
            for (int mark : s.getMarks())
                if (mark < 60) return true;
            return false;
        };

        Student[] filtered = filter(students, hasDebt);
        for (Student s : filtered)
            System.out.println(s.getName());


        // task3
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Predicate<Integer> even = n -> n % 2 == 0;
        Predicate<Integer> greaterThan3 = n -> n > 3;

        int[] result = filter(nums, even, greaterThan3);
        System.out.println(java.util.Arrays.toString(result));

        // task4

        // task5
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Consumer<Integer> printer = n -> System.out.println("Even: " + n);

        doIf(nums2, isEven, printer);

        // task6
        Function<Integer, Integer> powerOfTwo = n -> (int) Math.pow(2, n);

        int[] nums3 = {0, 1, 2, 3, 4, 5};
        int[] result2 = process(nums3, powerOfTwo);

        System.out.println(java.util.Arrays.toString(result2));


        // task7
        Function<Integer, String> numToWord = n -> switch (n) {
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "ten";
        };

        int[] nums4 = {0,1,2,3,4,5,6,7,8,9};
        String[] result3 = stringify(nums4, numToWord);
        System.out.println(Arrays.toString(result3));
    }
}
