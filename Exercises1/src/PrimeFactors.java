/**
 * Created by evazamudio on 2014-04-18.
 */

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;

/**Prime Factors Exercise

Write a method generate(int n) that given an integer N will return a list of integers such that the numbers are the factors of N and are arranged in increasing numerical order.

        For example, generate(1) should return an empty list and generate(30) should return the numbers: 2,3,5.

 Factor Numbers: The factors of a number are all those numbers that can divide evenly into the number with no remainder.
                 The greatest factor of a number is the number itself, so you can always list all the factors of any number because you have a stopping point.
 Prime Numbers: A Prime Number can be divided evenly only by 1 or itself.  And it must be a whole number greater than 1.
*/

public class PrimeFactors {
    public static void main(String[] args) {
        int n;
        n = parseInt(args[0]);
        drawPrimeFactors(n);

        for (Integer integer : drawPrimeFactors(n)) {
            System.out.println(integer);
        }
    }

        public static List<Integer> drawPrimeFactors(int numbers) {
            int n = numbers;
            List<Integer> factors = new ArrayList<Integer>();
            for (int i = 2; i <= n / i; i++) {
                while (n % i == 0) {
                    factors.add(i);
                    n /= i;
                }
            }
            if (n > 1) {
                factors.add(n);
            }
            return factors;
        }
}


