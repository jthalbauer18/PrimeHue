/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eratosthenesprimesieve_hue1;

import java.util.Scanner;

/**
 *
 * @author Jonny
 */
public class EratosthenesPrimeSieve_Hue1 {

    public static interface PrimeSieve {

        public boolean isPrime(int p);

        public void prinPrimes();
    }

    public static boolean[] EratosthenesPrimeSieve(int max) {
        boolean prime[] = new boolean[max + 1];
        for (int i = 0; i < max; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= max; p++) {

            if (prime[p] == true) {

                for (int i = p * p; i <= max; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;

    }

    public static void printPrimes(boolean[] b, int max) {
        for (int i = 2; i <= max; i++) {
            if (b[i] == true) {
                System.out.println(i + " ");
            }
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int max;
        max = in.nextInt();
        printPrimes(EratosthenesPrimeSieve(max), max);
    }

}
