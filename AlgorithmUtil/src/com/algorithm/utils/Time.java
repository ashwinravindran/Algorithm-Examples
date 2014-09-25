/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.utils;

/**
 *
 * @author ARavindran
 */
public class Time {
    
    long time;
    
    public Time(long time) {
        this.time = time;
    }
    
    public int getSeconds() {
        return (int) ((time / 1000) % 60);
    }
    
    public int getMinutes() {
        return (int) ((time / 1000 * 60) % 60);
    }
    
    public int getHours() {
        return (int) ((time / 1000 * 60 * 60) % 24);
    }
    
    public static String convertSecondsToHMmSs(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;
        return String.format("%d:%02d:%02d", h,m,s);
    }
    
    public static void main(String agrs[]) {
        Time time = new Time(60);
        System.out.println("The time is "+convertSecondsToHMmSs(60));
        
    }
}
