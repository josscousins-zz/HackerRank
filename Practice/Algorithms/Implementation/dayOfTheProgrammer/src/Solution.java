/**
 * @author CousinsJ
 *
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
    	String s ="";
    	//1700 - 1917 : julian calendar
    	if(year < 1918) {
    		
    		//leap year
    		if(year % 4 ==0) {
    			s = "12.09." + year;
    		}else {
    			s = "13.09." + year;
    		}
    	//transito to gregorian
    	}else if(year == 1918) {
    		s = "26.09.1918";
    		
    	//gregorian
    	}else {
    		//leap year
    		if(	(year % 400 ==0) ||((year % 4 == 0) && (year % 100 >0)) ){
    			s = "12.09." + year;
    		}else {
    			s = "13.09." + year;
    		}
    	}
    	
    	return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

