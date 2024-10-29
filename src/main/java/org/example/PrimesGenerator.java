package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimesGenerator implements Iterable<Integer> {
    private final int count;

    public PrimesGenerator(int count) {
        this.count = count;
    }

    public static List<Integer> generatePrimes(int count) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < count) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }
        return primes;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private final List<Integer> primes = generatePrimes(count);

            @Override
            public boolean hasNext() {
                return index < primes.size();
            }

            @Override
            public Integer next() {
                return primes.get(index++);
            }
        };
    }
}