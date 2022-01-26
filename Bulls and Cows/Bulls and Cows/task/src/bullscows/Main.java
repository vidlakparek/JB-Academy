package bullscows;

import java.util.Scanner;

public class Main {
    //private static int[] secretCode = {9, 3, 0, 5};
    //private static int[] guess = new int[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int guess = sc.nextInt();
        switch(guess) {
            case 9305: System.out.println("")
        }

    }

    /*public static int[] check(int input) {
        int cows = 0;
        int bulls = 0;
        for (int i = 3; i >= 0;i--){
            guess[i]=input%10;
            input /= 10;
        }
        for(int i = 0;i<secretCode.length;i++){
            for(int j = 0; j<guess.length;j++){
                if(guess[j]==secretCode[i] && j==i){
                    bulls++;
                } else if(guess[j]==secretCode[i])cows++;
            }
        }
        return new int[]{cows, bulls};
    }*/
}
