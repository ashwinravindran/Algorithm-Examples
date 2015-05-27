package math.questions.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import math.questions.GeneralMath;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ashwin
 */
public class GeneralMathTest {
    
    GeneralMath math = new GeneralMath();
    
    @Test
    public void powTest() {
        assertEquals(2015993900449.0, math.helperPow(17, 10),0);
    }
    
    @Test
    public void factTest() {
        assertEquals(120, math.getFact(5));
    }
    
    @Test
    public void expoTest() throws Exception {
        //TODO fix the method and test
        System.out.println("e^x is "+math.expo(2));
//        assertEquals(2.718281828459045, math.expo(1),0);
    }
    
    @Test
    public void absTest() {
        assertEquals(56, math.abs(-56));
    }
    
    @Test
    public void divisionTest() throws Exception {
        assertEquals(1232/212334, math.division(1232, 212334));
    }
    
}
