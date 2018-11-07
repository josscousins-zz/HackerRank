/*
 * @Author: CousinsJ
 * Desc: print the number of candles that can be blown out
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    static int birthdayCakeCandles(int[] ar) {

        
        int tallestCandle = Integer.MIN_VALUE;
        int candleCounter = 0;
        
        //loop through array
        for (int i = 0; i < ar.length; i++) {

            //save the tallest candle
            if (ar[i] > tallestCandle) {
                tallestCandle = ar[i];

                //reset counter
                candleCounter = 1;

            //increment counter
            } else if (ar[i] == tallestCandle) {
                candleCounter++;
            }
        }
        return candleCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
