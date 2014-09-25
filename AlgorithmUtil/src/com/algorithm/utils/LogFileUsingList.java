/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author ARavindran
 */
public class LogFileUsingList {
    
    public String customerId;
    public String pageId;

    public LogFileUsingList() {};
    
    public LogFileUsingList(String customerId, String pageId) {
        this.customerId = customerId;
        this.pageId = pageId;
    }
    
    public List<String> getPageSeqList(List<LogFileUsingList> logFileList) {
        
        if(logFileList == null) {
            return new ArrayList();
        }
        
        Map<String,List<String>> map = new HashMap();
        
        for(LogFileUsingList line : logFileList) {
            List<String> list;
            if(map.containsKey(line.customerId)) {
                list = map.get(line.customerId);
            } else {
                list = new ArrayList();
            }
            list.add(line.pageId);
            map.put(line.customerId, list);
        }
        
        return getPageSeqList(map);
    }
    
    private List<String> getPageSeqList(Map<String,List<String>> map) {
        
        if(map == null || map.isEmpty()) {
            return new ArrayList();
        }
        
        List<String> result = new ArrayList();
        HashMap<String,Integer> mem = new HashMap();
        
        for(String key : map.keySet()) {
             List<String> list = map.get(key);
             StringBuilder patternGen = new StringBuilder();
             
             for(String currentString : list) {
                 String prevString = patternGen.toString();
                 prevString = !prevString.isEmpty() ? prevString.substring(0, prevString.length() -1) : prevString;
                 if (!currentString.equalsIgnoreCase(prevString)) {
                     if (prevString.contains(currentString)) {
                         if (mem.containsKey(prevString)) {
                             Integer i = mem.get(prevString);
                             mem.put(prevString, i+1);
                         } else {
                             mem.put(prevString, 1);
                         }
                         patternGen = new StringBuilder();
                     } 
                     patternGen.append(currentString);
                     patternGen.append(",");
                 }
             }
             
            String prevString = patternGen.toString();
            prevString = prevString.substring(0, prevString.length() - 1);
            StringTokenizer token = new StringTokenizer(prevString,",");
            if(token.countTokens() > 1) {
                if (mem.containsKey(prevString)) {
                    Integer i = mem.get(prevString);
                    mem.put(prevString, i+1);
                } else {
                    mem.put(prevString, 1);
                }
            }
        }
        
        for(String key : mem.keySet()) {
            if(mem.get(key) > 1) {
                result.add(key);
            }
        }
        
        return result;
    }
}
