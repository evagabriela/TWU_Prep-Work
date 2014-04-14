import static java.lang.Integer.parseInt;

/**
 * Created by gabyzamudio on 2014-04-05.
 */
public class DrawRightTriangle {
    public static void main (String [] args){
        int n;
        n = parseInt(args[0]);
        drawVertical(n);
    }

//    Given a number n, print n lines, each with one asterisks
    public static void drawVertical(int n){
        for(int i = 0; i <n; i++){
            draw(i + 1);
            System.out.println("");
        }
    }

//    given a number n, print n number of "*" in one line
    public static void draw(int n){
        for(int i = 0; i < n; i++) {
            System.out.print("*");
        }
    }
}
