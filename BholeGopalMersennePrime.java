import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.Scanner;

public class BholeGopalMersennePrime {
	// precomputed merssenn primes
	public static Map<Integer, int[]> createMap() {
		Map<Integer, int[]> map = new HashMap<>();

		map.put(1, new int[] { 1, 0 });
		map.put(2, new int[] { 7, 0 });
		map.put(3, new int[] { 1, 1 });
		map.put(4, new int[] { 7, 1 });
		map.put(5, new int[] { 1, 3 });
		map.put(6, new int[] { 1, 4 });
		map.put(7, new int[] { 7, 4 });
		map.put(8, new int[] { 7, 7 });
		map.put(9, new int[] { 1, 15 });
		map.put(10, new int[] { 1, 22 });
		map.put(11, new int[] { 7, 26 });
		map.put(12, new int[] { 7, 31 });
		map.put(13, new int[] { 1, 130 });
		map.put(14, new int[] { 7, 151 });
		map.put(15, new int[] { 7, 319 });
		map.put(16, new int[] { 7, 550 });
		map.put(17, new int[] { 1, 570 });
		map.put(18, new int[] { 1, 804 });
		map.put(19, new int[] { 1, 1063 });
		map.put(20, new int[] { 7, 1105 });
		map.put(21, new int[] { 1, 2422 });
		map.put(22, new int[] { 1, 2485 });
		map.put(23, new int[] { 1, 2803 });
		map.put(24, new int[] { 1, 4984 });
		map.put(25, new int[] { 1, 5425 });
		map.put(26, new int[] { 1, 5802 });
		
		
		return map;
	}

	public static String getPrefixFValue(int n) {
		Map<Integer, int[]> map = createMap();
		int[] result = map.get(n); // Get the array {prefix, f_value} for the given n

		if (result != null) {
			return result[0] + "," + result[1]; // Return prefix and f value as "prefix,f_value"
		} else {
			return "Not found";
		}
	}

	// Function to check if a number is prime
	public static boolean isPrime(BigInteger n, String hxnum) {
		System.out.println("abhajya janch rha " + hxnum);
		Boolean parin = n.isProbablePrime(13);
		System.out.println("prinaam:" + parin);
		return parin;
	}

	public static void saveFile(int n, String data) {

		n = Integer.parseInt(String.valueOf(n));
		String path = "Mersenne prime.txt";
		File file = new File(path);
		if (file.getParentFile() != null) {
			file.getParentFile().mkdirs();
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { // 'true' for append mode
			writer.write(n + " vaan Mersenne prime number \n");
			writer.write(data);
			writer.newLine();
			System.out.println("Jankary likhi gyi Safaltapoorvak.");
		} catch (IOException e) {
			System.err.println("An error occurred while writing to the file: " + e.getMessage());
		}
	}
	
	public static int lastmeessen(){
		int max=0;
		String result;
		while (true){
			result = getPrefixFValue(max+1);
			if(result.equals("Not found")){
				
				break;
			}
			max++;
		}
		
		return max;
	}
	
	
	public static String getmersn(int n) {
		String[] op = { "1", "7" };
		String post = "f";
		int maxn = lastmeessen();
		int banne = 0;
		long postlen = 0;
		int mapsenik = 0;
		String result;
		String mersen = "Error";
		while (banne < n) {
			if (mapsenik < maxn) {
				// sari value map se lao
				result = getPrefixFValue(mapsenik + 1);
				String[] parts = result.split(",");
				banne++;
				post = "f".repeat(Integer.parseInt(parts[1]));
				postlen = post.length();
				System.out.println("Mila " + banne + ". " + result);
				mersen = result;
				mapsenik++;

			} else {
				// nayi value yahan bnao
				post += "f"; // n=(n*16)+15
				postlen += 1;
				for (String option : op) {

					// Create the Mersenne number in the form 0x{option} + f*
					String hexNum = option + post;
					// hex to biginteger
					BigInteger num = new BigInteger(hexNum, 16);
					if (isPrime(num, option+","+postlen)) {
						long fCount = postlen;
						mersen = option + "," + fCount;
						banne++;
						System.out.println("bnaya " + banne + ". Found: " + option + " f: " + fCount);
						// System.out.println(num);

					}
				}

			}

		}
		return mersen;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("kaunsa merssprime number?");
		int katte = sc.nextInt();
		sc.close();
		long startTime = System.nanoTime();

		if (katte > 0) {
			// Finding up to k Mersenne primes
			String mrsn = getmersn(katte);
			System.out.println(mrsn);
			saveFile(katte, mrsn);
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1_000_000;
		System.out.println("Time taken by the function: " + duration + " milliseconds");

	}
}
