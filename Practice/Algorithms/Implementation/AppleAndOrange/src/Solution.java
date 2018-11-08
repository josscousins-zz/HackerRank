/**
 * @author CousinsJ
 *	Desc: counts the number of fruit that lands in a given area (on the house)
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleX, orangeX; // x co-ordinate of fruit
        int appleC = 0, orangeC = 0; // number of apples and oranges that hit the house

        int n = apples.length > oranges.length ? apples.length : oranges.length;

        // loops as many times as the largest array length
        for (int i = 0; i < n; i++) {

            // ensures array is within bounds
            if (i < apples.length) {

                // loc of apple = treeX + distance apple fell
                appleX = a + apples[i];

                // if the apple is within the house co-ords
                if (appleX >= s && appleX <= t) {
                    appleC++;
                }

            }
            // ensures array is within bounds
            if (i < oranges.length) {

                orangeX = b + oranges[i];

                // if the orange is within the house co-ords
                if (orangeX >= s && orangeX <= t) {
                    orangeC++;
                }

            }
        }

        System.out.printf("%d\n%d",appleC,orangeC);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}

