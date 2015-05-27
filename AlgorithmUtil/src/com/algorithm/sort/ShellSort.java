/**
 * Basic sort mech
 * Very useful for medium size arrays
 * Uses insertion sort to h-sort the array
 * Start from computed h value and compare the elements left of h
 */
package com.algorithm.sort;


/**
 *
 * @author ashwin
 */
public class ShellSort {
    
    public static void sort(int[] a) {
        int h = 1;
        int n = a.length;
        
        while(h < n/3)  h = 3 * h + 1;
        
        while(h >= 1) {
            for(int i = h; i < n; i++) {
                for(int j = i; j > 0 && a[j] < a[j-1]; j -= h) {
                    exchange(a, j, j-1);
                }
            }
            
            h /= 3;
        } 
    }
    
    private static void exchange(int[] a, int i, int min) {
        int temp =a[i];
        a[i] = a[min];
        a[min] = temp; 
    }
    
    public static void main(String args[]) {
        int [] a = {34,121,1123,23456,1786,23,42,34,12345,19879,89202};
        sort(a);
        for (int i : a) {
            System.out.println(i+"\r\n");
        }
    }
}
