import static java.lang.Integer.parseInt;

/**
 * Created by evazamudio on 2014-04-08.
 */

//Isosceles Triangle
//        Given a number n, print a centered triangle. Example for n=3:
//          *      i = 0  numSpaces = 2
//         ***     i = 1  numSpaces = 1
//        *****    i = 2  numSpaces = 0

//        Given a number n, print a centered triangle. Example for n=4:
//          *      i = 0  numSpaces = 3
//         ***     i = 1  numSpaces = 2
//        *****    i = 2  numSpaces = 1
//       *******   i = 3  numSpaces = 0

//        Given a number n, print a centered triangle. Example for n=5:
//          *      i = 0  numSpaces = 4
//         ***     i = 1  numSpaces = 3
//        *****    i = 2  numSpaces = 2
//       *******   i = 3  numSpaces = 1
//      *********  i = 4  numSpaces = 0


public class IsoscelesTriangle {
    public static void main(String [] args){
        int n;
        n = parseInt(args[0]);
        drawCenteredTriangle(n);
    }


    public static void drawCenteredTriangle(int n){
        for(int i = 0; i < n; i++) {
            drawCenteredLine(i, n);
        }
    }

    public static void drawCenteredLine(int i, int n){
        int numberOfSpaces = numberOfSpaces(i, n);
        int numAsterisk = findNumAsterisk(i);
        printSpaces(numberOfSpaces);
        printAsterisks(numAsterisk);
        System.out.println();
    }


    public static int findNumAsterisk(int i){
        return 2 * i + 1;
    }



    public static int numberOfSpaces(int i, int n){
        return n - i - 1;
    }

    public static void printSpaces(int numSpaces){
        for(int i=1; i <= numSpaces; i++){
            System.out.print(" ");
        }
    }

    public static void printAsterisks(int numAsterisk){
        for(int i=1; i <= numAsterisk; i++){
            System.out.print("*");
        }

    }

}
