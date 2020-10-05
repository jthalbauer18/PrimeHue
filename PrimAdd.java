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
        int untergrenze = 4;
        int o;
        o = 10;
        Rechner(o);
        in.close();
    }

    public static void Rechner(int obergrenze) {
        for (int i = 4; i <= obergrenze; i = i + 2) {
            pruefeZahlen(i, obergrenze);
        }
    }

    public static void pruefeZahlen(int gZahl, int obergrenze) {
        boolean boolWert1;
        boolean boolWert2;
        boolean gefunden = false;
        int erstePrim = 2;
        int zweitePrim = 2;

        while (erstePrim < obergrenze - 2 && !gefunden) {
            boolWert1 = pruefeAufPrimzahl(erstePrim);
            if (boolWert1) {
                zweitePrim = 2;
                while (zweitePrim < gZahl && !gefunden) {
                    boolWert2 = pruefeAufPrimzahl(zweitePrim);
                    if (boolWert2) {
                        if (erstePrim + zweitePrim == gZahl) {
                            gefunden = true;
                            System.out.println(erstePrim + " + " + zweitePrim
                                    + " = " + gZahl);
                        }
                    }
                    zweitePrim++;
                }
            }
            erstePrim++;
        }
    }

    public static boolean pruefeAufPrimzahl(int erstePrim) {
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
