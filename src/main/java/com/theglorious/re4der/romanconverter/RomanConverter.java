package com.theglorious.re4der.romanconverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Karol "Re4derTheGlorious" Kozak
 *
 * Conversion rules file composition:
 * First line - max convertable value allowed
 * Second line - min convertable value allowed
 * Then any amount of conversion rules in form of two values (int and String) separated with commas. For example: "1,I" or "40,XL"
 *
 */
public class RomanConverter {
    
    private Map<Integer, String> rules;
    private int maxValue;
    private int minValue;
    private final String rulesLocation = "src\\main\\java\\com\\theglorious\\re4der\\romanconverter\\res\\conversionRules";
    
    public RomanConverter() throws Exception{
        loadRules();
    }
    //Loading conversion rules from default location, or..
    public void loadRules() throws Exception{
        load(rulesLocation);
    }
    //..custom location
    public void loadRules(String customLocation) throws Exception{
        load(customLocation);
    }
    //inner method for loading
    protected void load(String location) throws Exception{
        try {
            Scanner scan = new Scanner(new File(location));
            rules = new LinkedHashMap<>();
            maxValue = Integer.valueOf(scan.nextLine());
            minValue = Integer.valueOf(scan.nextLine());
            while(scan.hasNext()){
                String[] line = scan.nextLine().split(",");
                rules.put(Integer.valueOf(line[0]), line[1]);
            }
            scan.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RomanConverter.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Unable to load conversion rules!");
        }
    }
    
    //actual conversion method
    public String arToRom(int arabicNum) throws Exception{
        //initialize
        String romanNum = "";
        if(rulesLocation==null){
            loadRules(rulesLocation);
        }
        
        //check if the inserted value is valid
        if(arabicNum>maxValue)
            throw new Exception("Value too high!");
        else if(arabicNum<minValue)
            throw new Exception("Value too small!");
        
        //convert using loaded rules
        for(Map.Entry<Integer, String> rule : rules.entrySet()){
            for(; arabicNum>=rule.getKey(); arabicNum-=rule.getKey())
                romanNum+=rule.getValue();
        }
        
        return romanNum;
    }
}
