package ua.opnu;

import java.util.function.Predicate;

public class Main {
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
    }
}