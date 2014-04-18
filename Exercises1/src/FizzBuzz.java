/**
 * Created by evazamudio on 2014-04-18.
 */



public class FizzBuzz {
    public static void main(String[] args) {
        drawFizzBuzz();
    }

    private static void drawFizzBuzz() {
//      Instead of numbers divisible by three print "Fizz".
//      Instead of numbers divisible by five print "Buzz".
//      Instead of numbers divisible by three and five print "FizzBuzz".

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 ==0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
