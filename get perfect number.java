import java.math.BigInteger;
import java.util.ArrayList;

public class BholeGopalMersennePrime {

    // Function to check if a number is prime
    public static boolean isPrime(BigInteger n) {
        return n.isProbablePrime(13);
    }

    public static void main(String[] args) {
        String[] op = {"1", "7"};
        String post = "f";
        ArrayList<BigInteger> mersennePrimes = new ArrayList<>();
        mersennePrimes.add(BigInteger.valueOf(3));  // Adding the initial primes manually
        mersennePrimes.add(BigInteger.valueOf(7)); 
        int mersenneCount = mersennePrimes.size();
        long startTime = System.nanoTime();
        
        // Finding up to 11 Mersenne primes
        while (mersennePrimes.size() < 22) {
            for (int j = 0; j < 2; j++) {
                String option = op[j];
                // Create the Mersenne number in the form 0x{option} + f*
                String hexNum = option + post;
                // Convert the hex number t
                BigInteger num = new BigInteger(hexNum,16);
                
                if (isPrime(num)) {
                    mersenneCount++;
                    long fCount = post.length();
                    System.out.println(" " + mersenneCount + ". Found: " +"0x"+ option + " f: " + fCount);
                    mersennePrimes.add(num);
                }
            }
            post += "f";  // Add more 'f's
        }

        // 
        long endTime = System.nanoTime();
        
        // Cal
        long duration = (endTime - startTime) / 1_000_000;
        
        System.out.println("Time taken by the function: " + duration + " milliseconds");
    
    }
}
