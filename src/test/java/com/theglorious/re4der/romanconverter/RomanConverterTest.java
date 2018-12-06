package com.theglorious.re4der.romanconverter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import junit.framework.Assert;
import junit.framework.TestCase;

/*
 * @author Karol "Re4derTheGlorious" Kozak
 */
public class RomanConverterTest extends TestCase {

    public void testRomanConverter(){
        try{
            //load test data from a simple csv file containing two values separated with comma onto HashMap.
            Scanner scan = new Scanner(new File("src\\test\\java\\com\\theglorious\\re4der\\romanconverter\\res\\testData.csv"));
            Map<Integer, String> testData = new HashMap<>();
            while(scan.hasNext()){
                String[] line = scan.nextLine().split(",");
                int key = Integer.valueOf(line[0]);
                String value = line[1];
                testData.put(key, value);
            }
            
            //test - comparing conversion results with a chart of valid results
            RomanConverter arToRom = new RomanConverter();
            try{
                for(int i = 1; i<testData.size(); i++){
                    Assert.assertEquals(testData.get(i), arToRom.arToRom(i));
                }
                String value = arToRom.arToRom(20);
                Assert.assertEquals("XX", value);
            }catch(Exception e){
                fail(e.getMessage());
            }
        }catch(Exception e){
            fail(e.getMessage());
        }
    }
    
}
