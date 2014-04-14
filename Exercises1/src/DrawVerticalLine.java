import static java.lang.Integer.parseInt;

/**
 * Created by evazamudio on 2014-04-05.
 */
public class DrawVerticalLine {
    public static void main(String [] args){
        int n;
        n = parseInt(args[0]);
        draw(n);
    }

    public static void draw(int n){
        for(int i = 0; i < n; i++) {
            System.out.println("*");
        }
    }
}
