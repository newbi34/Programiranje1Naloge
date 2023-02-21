import java.util.Scanner;

public class NaSejkovemDvoru {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberMW = sc.nextInt();
        int sum = sc.nextInt();
        Long[] numbersOfMW = new Long[numberMW];
    
        for (int i = 0; i < numbersOfMW.length; i++) {
            numbersOfMW[i] = sc.nextLong();
        }

        sc.close();
        int counter = 0;

        for (int i = 0; i < numbersOfMW.length; i++) {
            for (int j = 0; j < numbersOfMW.length; j++) {
                if ((numbersOfMW[i] + numbersOfMW[j]) == sum) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
