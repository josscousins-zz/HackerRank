/*
* @Author: CousinsJ
* Desc: Return the number of positive and negative and zero values
*
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void plusMinus(int[] arr) {
    	
    	//counters
        double posC =0;
        double negC =0;
        double zeroC =0;
       
        
        double n = (double) arr.length;
        
        for(int i : arr) {
			if (i > 0) {
				posC++;
			} else if (i < 0) {
				negC++;
			} else {
				zeroC++;
			}
        }
        
        //overwrite counters with their freq as a fraction of the array
        posC = posC / n;
        negC = negC / n;
        zeroC = zeroC / n;
        
        System.out.printf("%6f\n%6f\n%6f", posC, negC, zeroC);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
