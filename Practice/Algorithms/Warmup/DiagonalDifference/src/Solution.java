/**
 * @author CousinsJ
 * Desc: calculate the difference between the sum of two corner diagonals
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	
	//[0,0][1,0][2,0]		for \ diag x == y
	//[0,1][1,1][2,0]		for / diag x + y = arr.length -1
	//[0,2][1,2][2,2]

	
    static int diagonalDifference(int[][] arr) {
        int sum1 =0;
        int sum2 =0;
        
        for(int i = 0;i < arr.length;i++) {
            for(int j = 0; j < arr[i].length; j++) {
                
                // "\" diagonal
                if(i == j) {
                    sum1 += arr[i][j];
                }
                // "/" diagonal
                if(i + j == arr.length -1){
                    sum2 += arr[i][j];
                }
                
            }

        }
        
        //difference has to be positive
        return Math.abs(sum1 - sum2);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

