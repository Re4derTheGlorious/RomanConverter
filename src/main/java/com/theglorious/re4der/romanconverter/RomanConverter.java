package com.theglorious.re4der.romanconverter;

/*
 * @author Karol "Re4derTheGlorious" Kozak
 */
public class RomanConverter {

    public String arToRom(int arabicNum) throws Exception{
        //initialize
        String romanNum = "";
        
        //Check if the inserted value is valid
        if(arabicNum>3000)
            throw new Exception("Value too high!");
        else if(arabicNum<0)
            throw new Exception("Negative values not allowed!");
        else if(arabicNum==0)
            throw new Exception("Zero cannot be converted!");
        
        //stage 1: counting  number of 1000s, 100s, 10s......
        for(; arabicNum>=1000; arabicNum-=1000)
            romanNum+="M";
        for(; arabicNum>=100; arabicNum-=100)
            romanNum+="C";
        for(; arabicNum>=10; arabicNum-=10)
            romanNum+="X";
        for(; arabicNum>0; arabicNum--)
            romanNum+="I";
        
        //stage 2: simplifying resulting String
        romanNum = romanNum.replace("CCCCC", "D");  //500
        romanNum = romanNum.replace("CCCC", "CD");  //400
        romanNum = romanNum.replace("XXXXX", "L");  //50
        romanNum = romanNum.replace("XXXX", "XL");  //40                                   
        romanNum = romanNum.replace("IIIII", "V");  //5
        romanNum = romanNum.replace("IIII", "IV");  //4
        
        romanNum = romanNum.replace("DCD", "CM");   //900
        romanNum = romanNum.replace("LXL", "XC");   //90
        romanNum = romanNum.replace("VIV", "IX");   //9

        return romanNum;
    }
}
