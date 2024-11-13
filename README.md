
# Discovery:
lets talk about how idea came.
take any mersanne prime number.
let's say 31
now convert it to hex
hex of 31 -> 1f
now take next mersenne prime which is 127
hex of 127 -> 7f
next mersenne prime is 8191
hex of 8191 -> 1fff
can you ses pattern
yes. mersanne prime number is nothing but combination 1,7,f
we can create mersanne prime number by combining one prefix 1,7
and lot of f 
now we can check if generated number is prime or not 
if it is then you have got your mersenne prime number 

as we know if you have mersanne prime number
you can get perfect number by using this formula
p= ((m^2)+m)/2
whare 
p: perfect number 
m: mersanne prime number 
that's why we have created Get perfect number
enter prefix 
enter f count 
that it...

# BGMP-algorithm
BGMP stands for Bhole Gopal Mersanne Prime algorithm is very efficient for generating candidates for mersanne prime numbers
as we discussed above we can create algorithm 
we are using java

Input:
The algorithm starts with an initial set of numbers and uses two key parameters:
A set of base hexadecimal digits (e.g., "1", "7").
A string (post) which starts with a single "f" and is incrementally extended in the search process.
Steps:
Initialize the prime list: The algorithm begins by manually adding two known Mersenne primes to the list: 
3
7


Generate Hexadecimal Numbers: The algorithm iteratively generates new potential Mersenne primes by appending "f" to the post string. It uses this string combined with the predefined hexadecimal digits ("1" and "7") to form a hex number. For example:

With post = "f", the hex numbers generated would be "1f" and "7f".
With post = "ff", the numbers would be "1ff" and "7ff". The process continues by adding more "f"s to the post string for each iteration.


Convert Hexadecimal to Decimal: Each generated hexadecimal string is converted to a BigInteger object, representing the number in decimal form.


Check for Primality: Each candidate number is checked for primality using the isProbablePrime() function with a certainty factor of 13. If the number is prime, it is added to the list of Mersenne primes.


Repeat Until Desired Count: The algorithm continues generating new candidates and testing for primality until the list contains the desired number of Mersenne primes (in this case, 22).


#Samay jatilta(time complexity):
Prime Checking: The isProbablePrime() method uses a probabilistic primality test, which works efficiently for large numbers but can have a non-deterministic performance depending on the number's size. In general, this test takes 
𝑂(𝑘⋅log⁡^3 𝑛)time where n is the size of the number being checked, and k is the number of rounds of testing (13 in this case).


Hexadecimal Generation: The loop generates new hexadecimal strings by incrementing the post string, which grows in size. Each new number generated involves the conversion of a hex string to a BigInteger, which can be done in 𝑂(log 𝑛) time, where n is the value represented by the hex number.


Overall Complexity: The algorithm's time complexity is roughly 𝑂(𝑚⋅𝑘⋅log^3 𝑛)
m is the number of generated candidates (which grows with the length of the post string), k is the certainty factor of the primality test, and n is the size of the number being checked.


# Mathematical Background

Mersenne Primes: A Mersenne prime is a prime number of the form (2^𝑛)−1
n is a prime number. These numbers are named after the French monk Marin Mersenne, who studied them in the early 17th century. Mersenne primes have been of particular interest in number theory due to their connection with perfect numbers, as every Mersenne prime corresponds to a perfect number.


Prime Testing: The algorithm uses the Miller-Rabin primality test, a probabilistic test that determines whether a number is prime with high probability. For the purpose of this algorithm, a certainty factor of 13 is used to balance performance and accuracy.
# Use Case

This algorithm is designed for:
Finding Mersenne Primes: The main use case is to find large Mersenne primes efficiently. While it may not directly generate 
(2^n)−1 in the traditional sense, it explores numbers of a similar form.

Primality Testing for Large Numbers: It demonstrates the practical application of primality tests on very large numbers using BigInteger.
