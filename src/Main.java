// Lab11avst.java
// The "Sieve of Eratosthenes" Program
// This lab returns all the prime numbers from 2 to a specified upper bound
// Evin Lodder
// 3/5/2024
import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
// This main method needs additions for the 100 point version.
        System.out.print("Enter the primes upper bound ===>> ");
        final int MAX = input.nextInt();
        boolean[] primes = new boolean[MAX]; //create array of desired size
        Arrays.fill(primes, true); //set all numbers to prime
        primes[0] = false; //set 1 to be not prime
        computePrimes(primes);
        displayPrimes(primes);
    }
    public static void computePrimes(boolean[] primes)
    {
        System.out.println("\nCOMPUTING PRIME NUMBERS");
        for(int i = 1; i < primes.length / 2; i++) { //we only have to check up to length/2 because anything after is redundant
            if(primes[i]) { //if current number is designated as prime
                for(int j = i * 2 + 1; j < primes.length; j += i + 1) {
                    //loop starting at next multiple of current number, count up until
                    //all multiples have been counted
                    primes[j] = false;
                }
            }
        }
    }
    public static void displayPrimes(boolean[] primes)
    {
        DecimalFormat format = new DecimalFormat("0000"); //make sure that all nums print at least four digits
        System.out.println("\n\nPRIMES BETWEEN 1 AND "+ primes.length);
        int numsOnLine = 0;
        for(int i = 0; i < primes.length; i++) {
            if(primes[i]) {
                System.out.print(format.format(i + 1) + " ");
                numsOnLine++;
                if(numsOnLine % 15 == 0) { //if we have 15 numbers on line, create newline
                    System.out.println("");
                }
            }
        }
    }
}