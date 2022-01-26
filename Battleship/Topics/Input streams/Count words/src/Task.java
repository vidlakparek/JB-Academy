import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String temp = reader.readLine();
        temp = temp.trim();
        reader.close();
        if (temp.isEmpty()) {
            System.out.println("0");
        } else {
            String[] a = temp.split("\\s+");
            System.out.println(a.length);
        }

    }
}