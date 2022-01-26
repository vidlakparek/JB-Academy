import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split("\\s+");
        List<String> list = Arrays.asList(values).stream().collect(Collectors.toList());
        System.out.println(list);
    }
}