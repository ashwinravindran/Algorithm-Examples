/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ashwin
 */
public class Helper {
    
    static char[] c = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
        'q','r','s','t','u','v','w','x','y','z'};
    
    public static List<String> getRandomString(long n) {
        List<String> r = new ArrayList();
        Random rand = new Random();
        while(n >= 1) {
            String s = "";
            for(int i=0; i<10; i++) {
                s+=c[rand.nextInt(26)];
            }
            r.add(s);
            n = n-1;
        }
        return r;
    }
}
