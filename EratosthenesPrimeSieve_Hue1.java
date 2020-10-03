/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eratosthenesprimesieve_hue1;

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
        for (int i = 0; i * i <= max; i++) {
            if (prime[i] == true) {
                for (int j = i * i; j <= max; j += i) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        int max = 2342;

        EratosthenesPrimeSieve_Hue1.printPrimes(EratosthenesPrimeSieve_Hue1.EratosthenesPrimeSieve(max), max);

    }

}
