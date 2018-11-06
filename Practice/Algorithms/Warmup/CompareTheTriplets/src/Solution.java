/**
 * @author CousinsJ
 *	Desc: Comparing index's of two different Arrays
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

    
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	List<Integer> aliceVbob = new ArrayList<Integer>();

    	//aliceVbob [Alice's Score,Bob' Score]
    	aliceVbob.add(0);
    	aliceVbob.add(0);
        
        //store the size of the largest array
        int n = a.size() >= b.size()? a.size(): b.size();
        
        
        for(int i =0; i < n; i++) {
        	
        	//if Alice has less elements than b
        	if(i > a.size()) {
        		
        		//Bob wins by default
        		aliceVbob.set(1, aliceVbob.get(1) + 1);
        		
    		
        	}//if b has less elements than a
        	else if(i > b.size()){
        		
        		//Alice wins by default
        		aliceVbob.set(0, aliceVbob.get(0) + 1);
        		
        	}//either both lists are the same size or not reached end of either index
        	else {
        		
        		//Alice wins
        		if(a.get(i) > b.get(i)) {
        			
        			//update Alice's total
        			aliceVbob.set(0, aliceVbob.get(0) + 1);
        		
        		}//Bob wins
        		else if(b.get(i) > a.get(i)){
        			
        			//update Bob's total
        			aliceVbob.set(1, aliceVbob.get(1) + 1);
        			
        		}
        		
        	}
        }

        return aliceVbob;

    }

    //modified BufferedWriter to output to System.out
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> a = Stream.of(bufferedReader.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
