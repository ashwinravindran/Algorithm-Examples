/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.utils;

/**
 *
 * @author ARavindran
 */
public class MergeSort {
    
    
    public static void mergeSort(int[] a, int[] aux, int low, int high) {
        if(low >= high) return;
            /** Swapping **/
        if(a[low] > a[high]) {
            a[high] = a[low] + a[high];
            a[low] = a[high] - a[low];
            a[high] = a[high] - a[low]; 
        }
        
        int mid = low + (high - low) /2;
        mergeSort(a, aux, low, mid);
        mergeSort(a, aux, mid+1, high);
        mergeArray(a,aux,low,mid,high);
    }
    
    private static void mergeArray(int[] a, int[] aux, int low, int mid, int high) {
        
        for(int i=low; i <=high; i++) {
           aux[i]  = a[i];
        }
        
        int i = low; int j = mid + 1;
        for(int k = low; k <= high; k++) {
            if(i > mid)                 a[k] = aux[j++];
            else if(j > high)           a[k] = aux[i++];
            else if(aux[j] < aux[i])    a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }
    
    public static void main(String args[]) {
        int a[] = {4,5,99,23,45,2,3};
        
        System.out.println("Array before merge sort.......\n");
        for(int i : a) {
            System.out.println(i);
        }
        
        int aux[] = new int[a.length];
        mergeSort(a, aux,0,a.length-1);
        
        System.out.println("Array after merge sort.......\n");
        for(int i : a) {
            System.out.println(i);
        }
    }

    
}
