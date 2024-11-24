import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class BholeGopalMersennePrime {

	public static List<Integer> apvaad = new ArrayList<>();

	static {
		apvaad.add(9);
		apvaad.add(11);
		apvaad.add(15);
		apvaad.add(23);
		apvaad.add(29);
		apvaad.add(37);
		apvaad.add(41);
		apvaad.add(43);
		apvaad.add(47);
	}

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
		map.put(27, new int[] { 1, 11124 });
		map.put(28, new int[] { 7, 21560 });
		map.put(29, new int[] { 7, 27625 });
		map.put(30, new int[] { 1, 33012 });
		map.put(31, new int[] { 7, 54022 });
		map.put(32, new int[] { 7, 189209 });
		map.put(33, new int[] { 1, 214858 });
		map.put(34, new int[] { 7, 314446 });
		map.put(35, new int[] { 1, 349567 });
		map.put(36, new int[] { 1, 744055 });
		map.put(37, new int[] { 1, 755344 });
		map.put(38, new int[] { 1, 1743148 });
		map.put(39, new int[] { 1, 3366729 });
		map.put(40, new int[] { 7, 5249002 });
		map.put(41, new int[] { 7, 6009145 });
		map.put(42, new int[] { 7, 6491237 });
		map.put(43, new int[] { 1, 7600614 });
		map.put(44, new int[] { 1, 8145664 });
		map.put(45, new int[] { 7, 9289166 });
		map.put(46, new int[] { 1, 10660950 });
		map.put(47, new int[] { 1, 10778152 });
		map.put(48, new int[] { 1, 14471290 });
		map.put(49, new int[] { 1, 18551820 });
		map.put(50, new int[] { 1, 19308229 });
		map.put(51, new int[] { 1, 20647483 });
		map.put(52, new int[] { 1, 34069960 });
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
		Boolean parin;
		
		Boolean alas = false;
		try {
			if (!alas) {
				parin = n.isProbablePrime(13);
			} else {
				int p = logBase2(n.add(BigInteger.ONE));
				System.out.println("p=" + p);
				parin = BigInteger.valueOf(p).isProbablePrime(20);
				if (parin) {
					parin = !(apvaad.contains(p));
				}
				if (parin) {
					System.out.println(n);
					System.out.println(p);
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			parin = false;
		}
		// System.out.println("prinaam:" + parin);
		return parin;
	}

	public static int logBase2(BigInteger value) {
		if (!isPowerOfTwo(value)) {
			throw new IllegalArgumentException("Value is not a power of 2.");
		}
		return value.bitLength() - 1;
	}

	public static boolean isPowerOfTwo(BigInteger value) {
		return value.and(value.subtract(BigInteger.ONE)).equals(BigInteger.ZERO);
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

	public static int lastmeessen() {
		int max = 0;
		String result;
		while (true) {
			result = getPrefixFValue(max + 1);
			if (result.equals("Not found")) {

				break;
			}
			max++;
		}

		return max;
	}

	public static BigInteger fastPower(BigInteger base, long exp) {
		BigInteger result = BigInteger.ONE;
		BigInteger power = base;

		while (exp > 0) {
			if (exp % 2 == 1) { // If exp is odd
				result = result.multiply(power);
			}
			power = power.multiply(power); // Square the base
			exp /= 2; // Divide exp by 2
		}

		return result;
	}

	public static String getmersn(int n) {
		String[] op = { "1", "7" };

		int maxn = lastmeessen();
		int banne = 0;
		long fCount = 0;
		long jarirak = 34069961;
		// jarirak = 20647488;maxn = 51;
		int mapsenik = 0;
		String result;
		BigInteger num;
		String mersen = "Error";
		while (banne < n) {
			if (mapsenik < maxn) {
				// sari value map se lao
				result = getPrefixFValue(mapsenik + 1);
				String[] parts = result.split(",");
				banne++;
				fCount = (Integer.parseInt(parts[1]));

				System.out.println("Mila " + banne + ". " + result);
				mersen = result;
				mapsenik++;
				if (mapsenik == maxn) {
					fCount = jarirak;
				}
			} else {
				// nayi value yahan bnao
				// n=(n*16)+15
				fCount += 1;
				for (String option : op) {

					// Create the Mersenne number in the form 0x{option} + f*

					if (option == "1") {
						BigInteger base = BigInteger.valueOf(16);
						BigInteger power = fastPower(base, fCount);
						num = power.multiply(BigInteger.valueOf(2)).subtract(BigInteger.ONE);
						// 2 * 16^fcount - 1
					} else if (option == "7") {
						BigInteger base = BigInteger.valueOf(16);
						BigInteger power = fastPower(base, fCount);
						num = power.multiply(BigInteger.valueOf(7)).add(power.subtract(BigInteger.ONE));
						// 7 * 16^fcount + (16^fcount - 1)
					} else {
						throw new ArithmeticException("invalid prefix");
					}
					if (isPrime(num, option + "," + fCount)) {
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
