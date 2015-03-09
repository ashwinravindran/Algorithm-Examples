/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.misc;



/**
 *
 * @author ARavindran
 */
public class Partition {

    public static void partition(int n) {
        partition(n, n, "");
    }

    public static void partition(int n, int max, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = java.lang.Math.min(max, n); i > 0; i--) {
            partition(n - i, i, prefix + " " + i);
        }
    }


    public static void main(String[] args) { 
        partition(4);
    }

    
}
