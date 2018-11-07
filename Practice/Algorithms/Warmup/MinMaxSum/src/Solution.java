/*
 * Author: CousinsJ
 * Desc: find the smallest and largest sum of values
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void miniMaxSum(int[] arr) {

        long totalSum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (long i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
            totalSum += i;
        }
        //smallest sum = total sum minus the largest value;
        //largest sum = total sum minus the smallest value;
        System.out.printf("%d %d", totalSum - max, totalSum - min);


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

