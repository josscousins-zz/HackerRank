/**
 * @author CousinsJ
 *	Desc: check if a string is valid
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	//returns "YES" if the frequency of all chars is the same after 0 or 1 modifications
	static String isValid(String s) {
        int max = 1;
        
        // map each character with the frequency
        Map<Character, Integer> countChar = new HashMap<Character, Integer>();
        //map the frequencies, with their occurance
        Map<Integer, Integer> countCount = new LinkedHashMap<Integer, Integer>();

        // loop through string
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            
            //update frequency of char if it is already in the map
            if (countChar.containsKey(c)) {
                countChar.put(c, countChar.get(c) + 1);
                
                //if this char occurs the most save its freq
                if (countChar.get(c) > max) {
                    max++;
                }

            //add a unique character to the map
            } else {
                countChar.put(c, 1);
            }
        }

        //map the frequencies with occurences
        for (Map.Entry<Character, Integer> entry : countChar.entrySet()) {
            if (countCount.containsKey(entry.getValue())) {
                countCount.put(entry.getValue(), countCount.get(entry.getValue()) + 1);
            } else {
                countCount.put(entry.getValue(), 1);

            }

        }
        
        //if all chars occur the same amount e.g; s = {(a),(a,b,c),(aa,bb,cc)...}
        if (countCount.size() == 1) {
            s = "YES";
            
        //if only 2 different frequencies
        } else if (countCount.size() == 2) {
        	
        	//if there is a freq that occurs only once
            if (countCount.containsValue(1)) {
            	
            	//aaabbbc
                s = "YES";
                
                //if the max freq occurs only once
                if (countCount.get(max) == 1) {
                	
                	//and the next highest freq is 1 less
                    if (countCount.containsKey(max - 1)) {
                    	
                    	//take 1 of the max chars to make it valid; aaaabbbccc -> aaabbbccc
                        s = "YES";
                    } else {
                    	//charfreq >1 :. removing 1 char is not enough
                        s = "NO";
                    }
                }

            } else {
                s = "NO";
            }
        //>2 different frequencies means removing 1 will still give us 2 different freqs :. not valid
        } else {
            s = "NO";
        }
        return s;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

