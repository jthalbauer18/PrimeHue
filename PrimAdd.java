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
public class PrimAdd {

    public int u = 4;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max;
        max = in.nextInt();
        Rechner(max);

    }

    public static void Rechner(int obergrenze) {
        for (int i = 4; i <= obergrenze; i = i + 2) {
            testNumber(i, obergrenze);
        }
    }

    public static void testNumber(int evenNumber, int obergrenze) {
        boolean boolWert1;
        boolean boolWert2;
        boolean gefunden = false;
        int primeAdd1 = 2;
        int primeAdd2;

        while (primeAdd1 < obergrenze - 2 && !gefunden) {
            boolWert1 = isPrime(primeAdd1);
            if (boolWert1) {
                primeAdd2 = 2;
                while (primeAdd2 < evenNumber && !gefunden) {
                    boolWert2 = isPrime(primeAdd2);
                    if (boolWert2) {
                        if (primeAdd1 + primeAdd2 == evenNumber) {
                            gefunden = true;
                            System.out.println(primeAdd1 + " + " + primeAdd2 + " = " + evenNumber);

                        }
                    }
                    primeAdd2++;
                }
            }
            primeAdd1++;
        }
    }

    public static boolean isPrime(int x) {
        if (x == 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
