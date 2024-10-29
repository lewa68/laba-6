package org.example;

import java.util.Iterator;

public class PrimesGeneratorTest {
    public static void testPrimesGenerator(int count) {
        PrimesGenerator primesGenerator = new PrimesGenerator(count);
        System.out.println("Generated primes (forward):");
        for (int prime : primesGenerator) {
            System.out.print(prime + " ");
        }
        System.out.println();

        System.out.println("Generated primes (reverse):");
        Iterator<Integer> iterator = primesGenerator.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}