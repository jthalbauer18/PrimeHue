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
                System.out.print(i + " ");
            }
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int untergrenze = 4;
        long obergrenze;
        System.out.println("Programm zum Uberpruefen der Goldbachschen Vermutung.");
        System.out.println("Bitte geben Sie eine ganze gerade Zahl fuer die Obergrenze ein: ");
        obergrenze = in.nextLong();
        giugaRechner(untergrenze, obergrenze);
        in.close();
    }

    public static void giugaRechner(long untergrenze, long obergrenze) {
        for (long i = untergrenze; i <= obergrenze; i = i + 2) {
            pruefeZahlen(i, untergrenze, obergrenze);
        }
    }

    public static void pruefeZahlen(long geradeZahl, long untergrenze, long obergrenze) {
        boolean ersterCheck = false;
        boolean zweiterCheck = false;
        boolean gefunden = false;
        long erstePrim = 2;
        long zweitePrim = 2;

        while (erstePrim < obergrenze - 2 && !gefunden) {
            ersterCheck = pruefeAufPrimzahl(erstePrim);
            if (ersterCheck) {
                zweitePrim = 2;
                while (zweitePrim < geradeZahl && !gefunden) {
                    zweiterCheck = pruefeAufPrimzahl(zweitePrim);
                    if (zweiterCheck) {
                        if (erstePrim + zweitePrim == geradeZahl) {
                            gefunden = true;
                            System.out.println(erstePrim + " + " + zweitePrim
                                    + " == " + geradeZahl);
                        }
                    }
                    zweitePrim++;
                }
            }
            erstePrim++;
        }
    }

    public static boolean pruefeAufPrimzahl(long erstePrim) {
        boolean prim = true;
        long teiler = erstePrim - 1;
        while (teiler > 1 && prim) {
            if (erstePrim % teiler == 0) {
                prim = false;
            }
            teiler--;
        }
        return prim;
    }
}
