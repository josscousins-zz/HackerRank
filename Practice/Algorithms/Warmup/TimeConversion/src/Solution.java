/**
 * 
 */

/**
 * @author CousinsJ
 *
 */
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
//could import java.time however the challenge is to only modify the timeConversion method

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
	
    static String timeConversion(String s) {
        //add a seperator before the AM or PM
        s = s.substring(0, 8) + ";" +  s.substring(8,s.length());
        
        //used to store the hours, minutes, and seconds separately
		String[] hhmmss = null;
		
		int hh = 0;

        String[] ampm = s.split(";");
        
        //no longer need s so we can overwrite it with the result
        s = "";
        
        
                
        hhmmss = ampm[0].split(":");
        hh = Integer.parseInt(hhmmss[0]);

        
        //check for am/pm
        if(ampm[1].equals("AM")) {
            
            //12AM in 24hr = 00AM
            if( hh == 12) {
                hhmmss[0] = "00";
            }
        }else if(ampm[1].equals("PM")){
        	
            if(hh < 12) {
                hh = hh + 12;
                hhmmss[0] =  Integer.toString(hh);

            }
                
        }else {
            System.out.println("wheres AM/PM???");
        }


        //rejoin the strings
        for(int i =0; i < hhmmss.length;i++) {
            if(i < hhmmss.length -1) {
                s = s + hhmmss[i] + ":";
            }else {
                s = s + hhmmss[i];
            }
            
            
        }
        return s;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
