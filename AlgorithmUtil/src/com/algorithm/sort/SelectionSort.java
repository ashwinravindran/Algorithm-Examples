/**
 * Basic sorting mech. 
 * Every element is exchanged with either to next lowest element or to itself.
 * Running time - N2 comparisons and N2 exchange.
 * Can be used for very small array but insertion sort is preferred.
 */
package com.algorithm.sort;

/**
 *
 * @author ashwin
 */
public class SelectionSort {
    
    public static void sort(int[] a) {
        
        for(int i=0; i < a.length; i++) {
            for(int j=i+1; j< a.length; j++) {
                int min = i;
                if(a[j] < a[i]) {
                   min = j;
                }
                exchange(a, i, min);
            }
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
