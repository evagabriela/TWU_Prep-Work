import static java.lang.Integer.parseInt;

/**
 * Created by evazamudio on 2014-04-18.
 */

//Given a number n, print a centered diamond with your name in place of the middle line. Example for n=3:
//
//         *
//        ***
//        Bill
//        ***
//         *

//    n = 3
//    # of Lines = 5
//          *               i = 0,  Spaces: n - i -1 = 2  #Asterisks: 1 = 2i + 1
//         ***              i = 1   Spaces: n - i -1 = 1  #Asterisks: 3 = 2i + 1
//        Bill            i = 2   Spaces: n - i -1 = 0  #Asterisks: 5 = 2i + 1
//         ***              i = 3   Spaces: n - i -1 = -1 #Asterisks: 3 : when I am after n then use 3 = -2i + ((2 * #Lines) -1)
//          *               i = 4   Spaces: n - i -1 = -2 #Asterisks: 1

//    n = 4
//    #Lines = 7
//          *               i = 0,
//         ***              i = 1
//        *****             i = 2
//      Bill           i = 3
//        *****             i = 4  when I am after n then use 3 = -2i + ((2 * #Lines) - 1)
//         ***              i = 5
//          *               i = 6

//    n = 5
//    #Lines = 9
//          *               i = 0,
//         ***              i = 1
//        *****             i = 2
//       *******            i = 3
//     Bill          i = 4
//       *******            i = 5  # Ast = 6 when I am after n then use -2i + ((2 * #Lines) -1)
//        *****             i = 6
//         ***              i = 7
//          *               i = 8

public class DrawDiamondName {
    public static void main(String[] args) {
        int n;
        n = parseInt(args[0]);
        drawDiamond(n);
    }

    public static void drawDiamond(int n){
//        find number of lines
//        print them using *
//        print name in the middle of the diamond
        int numLines = findNumberLines(n);
        for (int i = 0; i < numLines; i++){
            drawAline(n,i);
        }
    }

    public static int findNumberLines(int n){
        return n + (n - 1);
    }

    private static void drawAline(int n, int i) {
//        I need:
//        How many asterisks
//        how many spaces
//        the name to print in the middle
        drawSpace(n,i);
        if (n == (i+1)){
//        drawName(n, i);
            drawName(n,i);
        } else {
//        drawAsterisk(n,i);
            drawAsterisk(n,i);
        }
        System.out.println();
    }

    private static void drawSpace(int n, int i) {
//        I need to know how many spaces
//        int abs(int i)
        int numSpaces = Math.abs( n - i -1);
        for (int a = 0; a < numSpaces ; a++){
            System.out.print(" ");
        }
    }

    private static void drawAsterisk(int n, int i){
 //        I need to know how many asterisks
        int number = findNumberOfAsterisks(n, i);
        for (int a = 0; a < number ; a++){
            System.out.print("*");
        }
    }

    private static void drawName(int n, int i){
//        based on n and i, draw name in the right place
//        when n is ... and i is ... print "Gaby"
        int middle_point = i + 1;
        if (n == middle_point){
            System.out.print("Gaby");
        }
    }

    private static int findNumberOfAsterisks(int n, int i){
        int numAsterisk;

        if (n <= i) {
            numAsterisk = (-2 * i) + ((2 * findNumberLines(n)) - 1);
        } else {
            numAsterisk = (2 * i) + 1;
        }
        return numAsterisk;
    }
}
