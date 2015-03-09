/**
 * Basic sorting mech. 
 * Only left side of the array is seen by the program.
 * Every element on left side of i pointer is compared with its previous element.
 * An element is exchanged only if the prev element is greater than current element in the iteration.
 * N2 comparison and N2 exchange in worst case - Runnigng time
 * If element is partially sorted then insertion sort can be used.
 */
package com.algorithm.sort;

/**
 *
 * @author ashwin
 */
public class InsertionSort {
    
    public static void sort(int a[]) {
        for(int i=0; i<a.length; i++) {
            for(int j=i; j>0 && a[j] < a[j-1]; j--) {
                exchange(a,j,j-1);
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
