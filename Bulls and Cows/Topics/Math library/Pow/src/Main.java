import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split("\\s+");
        double a = Double.parseDouble(values[0]);
        double b = Double.parseDouble(values[1]);
        System.out.println(Math.pow(a,b));
        Random rand = new Random();
        rand.nextInt();
    }
}