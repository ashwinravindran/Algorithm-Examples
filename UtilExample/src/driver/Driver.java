/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 *
 * @author ARavindran
 */
public class Driver {
    
    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException, FileNotFoundException, IOException
    {	
        FileInputStream test = test();
        int content;
        while ((content = test.read()) != -1) {
            // convert to char and display it
            System.out.print((char) content);
        }
    }
    
    private static FileInputStream test() throws FileNotFoundException, IOException {
        File f = new File("d:\\abc.txt");
        FileInputStream fis = new FileInputStream(f);
        if(!f.delete()) {
            System.out.println("The file didnt get deleted");
        }
        return fis;
    }
}
