/**
 * @author CousinsJ
 *	Desc: TO check if two objects will meet
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {

        String s = "";

        //as long as the trailing kangaroo has greater velocity
        if (x1 < x2 && v1 > v2) {

            // x1 is gaining
            while (x1 < x2) {

                // kangaroos jump
                x1 += v1;
                x2 += v2;

                // if new loc is the same
                if (x1 == x2) {
                    return s = "YES";
                }

            }
            // x1 overtook x2
            s = "NO";
            
        // same for kangaroo 2
        } else if (x2 < x1 && v2 > v1) {

            while (x1 > x2) {
                x1 += v1;
                x2 += v2;

                if (x1 == x2) {
                    return s = "YES";
                }
            }
            s = "NO";
            
        //trailing kangaroo is not catching up
        } else {
            return s = "NO";

        }

        return s;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

