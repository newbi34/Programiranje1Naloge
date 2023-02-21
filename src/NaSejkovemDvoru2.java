import java.util.Scanner;
import java.lang.Math;

public class NaSejkovemDvoru2 { 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberMW = sc.nextInt();
        
        //Has to be less than 20
        int sum = sc.nextInt();
        sc.close();

        Long[] numbersOfMW = new Long[numberMW];

        randomize(numbersOfMW);
        System.out.println(countPairs(numbersOfMW, sum));
    }

    public static void randomize(Long[] numbersOfMW) {
        for (int i = 0; i < numbersOfMW.length; i++) {
            numbersOfMW[i] = Long.valueOf((int) (Math.random() * 10));
        }
    }

    public static int countPairs(Long[] numbersOfMW, int sum) {
        int counter = 0;
        for (int i = 0; i < numbersOfMW.length; i++) {
            for (int j = 0; j < numbersOfMW.length; j++) {
                if ((numbersOfMW[i] + numbersOfMW[j]) == sum) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
