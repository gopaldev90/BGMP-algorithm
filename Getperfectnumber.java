import java.math.BigInteger;
import java.util.Scanner;

public class Getperfectnumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Reading input from the user
		System.out.print("ichha : ");
		String ichha = scanner.nextLine().trim();

		if (ichha.equals("a")) {
			automake();
		} else {
			mannualmake(scanner);
		}
	}

	public static void mannualmake(Scanner scanner) {
		// Getting prefix input from the user
		System.out.print("prefix : ");
		char prefix = scanner.nextLine().trim().charAt(0);

		// Getting fgananna input from the user
		System.out.print("katte f : ");
		int fgananna = Integer.parseInt(scanner.nextLine().trim());
		String fladi = "f";

		if (fgananna >= 0) {

			if (fgananna == 0 && prefix == '1') {
				System.out.println("perfect number");
				System.out.println("6");
			} else {

				String perfcnum = getPerfectnum(getMersannePrime(prefix, fgananna));
				int p = 6;
				System.out.println("perfect number");
				System.out.println("Starting ke " + p + " akshar");
				System.out.println(perfcnum.substring(0, p));
				System.out.println("Ending ke " + p + " akshar");
				System.out.println(perfcnum.substring(perfcnum.length() - p));
			}
		}
	}

	public static String getPerfectnum(String m) {
		BigInteger n = new BigInteger(m);
		System.out.println("getting perfect number ");
		// Pf = (N * N + N) / 2
		BigInteger pf = (n.multiply(n).add(n)).divide(BigInteger.valueOf(2));

		// Return the string representation of the perfect number
		return pf.toString();
	}



	public static String getMersannePrime(char prefix, int fcount) {
		BigInteger n;
		System.out.println("getting mersanne prime ");
		// Construct hex number by prefixing `fladi` with the given prefix
		if (prefix == '1') {
			// Calculate 2 * 16^fcount - 1 using BigInteger
			BigInteger base = BigInteger.valueOf(16);
			BigInteger power = base.pow(fcount); // 16^fcount
			n = power.multiply(BigInteger.valueOf(2)).subtract(BigInteger.ONE); // 2 * 16^fcount - 1
		} else if (prefix == '7') {
			BigInteger base = BigInteger.valueOf(16);
			BigInteger power = base.pow(fcount); // 16^fcount
			n = power.multiply(BigInteger.valueOf(7)).add(power.subtract(BigInteger.ONE)); // 7 * 16^fcount + (16^fcount - 1)

			// Parse hexnum as a BigInteger in base 16
		} else {
			throw new ArithmeticException("invalid prefix");

		}
		return n.toString();
	}


	public static void automake() {
		// length of mersenne prime
		int limit = 41024320;
	
		int fcount = limit - 3;
		// ye mersanne prime number ke tukde hone chahiye

		String anumanitstart = "881694";
		String anumanitend = "871551";

		char[] op = {'1', '7'};
		int mrsnln, diff, chakkar;
		mrsnln = diff = chakkar = 0;

		while (true) {
			System.out.print("\n");
			chakkar++;
			System.out.println("Chakkar: " + chakkar);
			for (char prefix : op) {
				System.out.println("Matching prefix: " + prefix);
				System.out.println("Matching fCount: " + fcount);
				String result = getMersannePrime(prefix, fcount);
				mrsnln = result.length();
				System.out.println("Generated Mersenne prime length: " + mrsnln);
				diff = mrsnln - limit;
				System.out.println("diff : " + diff);
				if (((result.startsWith(anumanitstart))&&(result.endsWith(anumanitend))) || (mrsnln == limit && prefix == '7')) {
					if ((result.startsWith(anumanitstart)) && (result.endsWith(anumanitend))) {
						System.out.println("-----matched-----");
						System.out.println("prefix: " + prefix);
						System.out.println("fCount: " + fcount);
						/*
						String perfcnum = getPerfectnum(result);
						int p = 6;
						System.out.println("perfect number");
						System.out.println("Starting ke " + p + " akshar");
						System.out.println(perfcnum.substring(0, p));
						System.out.println("Ending ke " + p + " akshar");
						System.out.println(perfcnum.substring(perfcnum.length() - p));
						*/
					} else {
						System.out.println("Limit length and Mersenne prime length are the same");
						System.out.println("prefix: " + prefix);
						System.out.println("fCount: " + fcount);

					}
					return;
				}
			}
			if (diff == -1 || diff == 1) {
				if (diff == 1) {
					fcount--;
				} else {
					fcount++;
				}
			} else {
				if (diff > 1) {
					fcount -= (diff / 2) + (diff % 2);
				} else if (diff < -1) {
					fcount += (-diff / 2) + (-diff % 2);
				}
			}

		}

	}
}
