import java.util.Scanner;
import java.lang.Math;

public class Ploscicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        
        int temp = 0;
        if (h > w) {
            temp = w;
            w = h;
            h = temp;
        }

        int leftoverH = h;
        int maxSizeInRow = h;
        int powerCounter = k;
        int tileCounter = 0;
        int someCounter = 0;
        int RowCounter = 0;
        int smallingCounter = 1;

        while (leftoverH > 1) {
            RowCounter++;
            while (leftoverH < (int) Math.pow(2, powerCounter) && powerCounter > 0) {
                powerCounter--;
            }
            int leftoverW = w - (int) Math.pow(2, powerCounter);
            leftoverH = leftoverH - (int) Math.pow(2, powerCounter);
            maxSizeInRow = (int) Math.pow(2, powerCounter);
            while (leftoverW > 0) {
                while (leftoverW < maxSizeInRow) {
                    maxSizeInRow = (maxSizeInRow / 2);
                    someCounter++;
                }
                smallingCounter = (int) Math.pow(2, someCounter);
                leftoverW = leftoverW - maxSizeInRow;
                tileCounter = tileCounter + smallingCounter;
            }
            someCounter = 0;
        }
        tileCounter = tileCounter + RowCounter;
        System.out.println(tileCounter);
    }
}
