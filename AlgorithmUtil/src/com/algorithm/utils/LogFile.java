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
public class LogFile {
    
    public String customerId;
    public String pageId;

    public LogFile() {};
    
    public LogFile(String customerId, String pageId) {
        this.customerId = customerId;
        this.pageId = pageId;
    }
    
    public List<String> getPageSeqList(List<LogFile> logFileList) {
        
        if(logFileList == null) {
            return new ArrayList();
        }
        
        Map<String,StringBuilder> map = new HashMap();
        
        for(LogFile line : logFileList) {
            StringBuilder str;
            if(map.containsKey(line.customerId)) {
                str = map.get(line.customerId);
                str.append(line.pageId);
                str.append(",");
            } else {
                str = new StringBuilder();
                str.append(line.pageId);
                str.append(",");
                map.put(line.customerId, str);
            }
        }
        
        return getPageSeqList(map);
    }
    
    private List<String> getPageSeqList(Map<String,StringBuilder> map) {
        
        if(map == null || map.isEmpty()) {
            return new ArrayList();
        }
        
        List<String> result = new ArrayList();
        HashMap<String,Integer> mem = new HashMap();
        
        for(String key : map.keySet()) {
             StringBuilder obj = map.get(key);
             StringTokenizer token = new StringTokenizer(obj.toString(),",");
             StringBuilder patternGen = new StringBuilder();
             
             while(token.hasMoreTokens()) {
                 String prevString = patternGen.toString();
                 prevString = !prevString.isEmpty() ? prevString.substring(0, prevString.length() -1) : prevString;
                 String currentString = token.nextToken();
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
            token = new StringTokenizer(prevString,",");
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
