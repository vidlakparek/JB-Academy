
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split("\\s+");
        List<Integer> list = Arrays.asList(values).stream().map(Integer::parseInt).collect(Collectors.toList());
        for (int i = list.size(); i > 0; i--) {
            if (i % 2 == 0) System.out.print(list.get(i - 1) + " ");
        }
    }
}