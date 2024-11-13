import java.util.Scanner;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("prefix ?");
		char prefix = sc.next().charAt(0);
		System.out.println("katte f ?");
		int fgananna = sc.nextInt();
		sc.close();
		BigInteger Pf;
		String hexnum;
		String fladi = "f";
		if (fgananna >= 0) {
			if (fgananna == 0) {
				if ((String.valueOf(prefix).equals("1"))||(String.valueOf(prefix).equals("7"))) {
					fladi = "";
				}
			} else {
				fladi = fladi.repeat(fgananna);
			}
			if (fgananna == 0 && String.valueOf(prefix).equals("1")) {
				hexnum = "1";
				Pf = BigInteger.valueOf(6);
			} else {
				hexnum = String.valueOf(prefix) + fladi;
				BigInteger N = new BigInteger(hexnum, 16);
				System.out.println("Mersenne prime\n" + N);
				Pf = ((N.multiply(N)).add(N)).divide(BigInteger.valueOf(2));
			}
			System.out.println("Perfect number ");
			System.out.println(Pf);
		}

	}
}
