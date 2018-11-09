
/**
 * @author CousinsJ
 * Desc: To find the bird with the most sightings
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

	
	
	
	static int migratoryBirds(List<Integer> arr) {
		
		Map<Integer, Integer> birdFreq = new HashMap<Integer, Integer>();
		int max =0;
		int index =0;
		
		//sort arr in ascending order
		Collections.sort(arr);
		
		//iterate through array
		for(int a : arr) {
			
			if(birdFreq.containsKey(a)) {
				//update freq
				birdFreq.replace(a, birdFreq.get(a)+ 1);
				
				//save highest freq
				if(birdFreq.get(a) > max) {
					max = birdFreq.get(a);
					index = a;
				}
			}else {
				birdFreq.put(a, 1);
			}
			
		}
		return index;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = migratoryBirds(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
