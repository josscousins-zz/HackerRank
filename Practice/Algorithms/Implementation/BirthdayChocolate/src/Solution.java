/**
 * @author CousinsJ
 *	Desc: Calculate how many times the chocolate can be divided appropriately,
 *	using sliding window approach
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

    static int birthday(List<Integer> s, int d, int m) {
        int total = 0;
        int counter = 0;

        // (1)assign the first m items of s to pieces
        for (int i = 0; i < m; i++) {
            total += s.get(i);
        }
        if (total == d) {
            counter++;
        }

        //loop through the array until there is less than m index's left
        for (int i = 1; i < (s.size() - m) + 1; i++) {

            // remove the value of the first piece
            total = (total - s.get(i - 1));
            
            //add the value of the new last piece
            total+= s.get(i + m - 1);
            
            if (total == d) {
                counter++;
            }
        }

        return counter;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

