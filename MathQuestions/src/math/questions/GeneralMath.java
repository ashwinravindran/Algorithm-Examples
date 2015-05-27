/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.questions;

/**
 *
 * @author ashwin
 */
public class GeneralMath {
    
    public double pow(double a, int b) throws Exception {
        
        if(a == 0) {
            return 0;
        }
        
        if(b == 0) {
            return 1; 
        }
        
        if(b == 1) {
            return a;
        }
        
        if(b < 0) {
            throw new Exception("The power is less than 0");
        }
        
        return helperPow(a,b);
        
    }
    
    public double helperPow(double a, int b) {
        if(b == 1) {
            return a;
        }
        
        return a * helperPow(a,b-1);
    }
    
    /**
     * 1 + x^1/1! + x^2/2! +.....
     * x^0/0! + x^1/1! + x^2/2! +.....
     * @param x
     * @return 
     * TODO FixMe
     */
    public double expo(int x) throws Exception {
        
        double ex =1.0;
        for(int i = 0; i < x; i++) {
            ex += pow(x,i) / getFact(i);
        }
        
        return ex;
    }
    
    public long getFact(int n) {
        long fact = 1;
        for(int i = n ; i > 0 ; i--) {
            fact *= i;
        }
        
        return fact;
    }
    
    public long abs(long x) {
        return x < 0 ? x * (-1) : x;
    }
    
    public int division(int x, int y) throws Exception {
       int result = 0;
       
       if(y == 0) {
           throw new Exception("The number is tend to infinity");
       }
       
       while (x > 0 && x >= y) {
           x -= y;
           result++;
       }
       
       return result;
    }
}
