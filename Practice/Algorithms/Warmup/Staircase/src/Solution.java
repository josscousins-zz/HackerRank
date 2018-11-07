/**
 * @author CousinsJ
 * Desc: print out a staircase of n treads
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static void staircase(int n) {
    	
    	//formating for the printf that lets us specify how much space the string can fill
    	String format = "%" + n + "s\n"; 
    	
    	String s = "";

    	for(int i = 0; i < n;i++) {
    		s = s + "#";
    		System.out.printf(format,s);
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
