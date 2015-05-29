/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.string;

import java.util.Map;

/**
 *
 * @author ashwin
 */
public class EasyStringQuestions {
    
    public int minDistBetTwoWordsInDic(String w1, String w2 , Map<String,Integer> dictionary){
        if(dictionary == null || dictionary.isEmpty()) {
            return -1;
        }
        
        if(!dictionary.containsKey(w1) || !dictionary.containsKey(w2)) {
            return 0;
        }
        
        return Math.abs((dictionary.get(w1) - dictionary.get(w2)));
    }
    
    public static String toLowerCase(String s) {
        String r = "";
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                char c = (char) (s.charAt(i) + 32);
                r += c;
            } else {
                r += s.charAt(i);
            }
        }
        
        return r;
    }
}
