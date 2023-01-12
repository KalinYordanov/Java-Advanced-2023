package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class k3DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> bits = new ArrayDeque<>();

        int num = Integer.parseInt(scanner.nextLine());

        if (num < 0) {
            System.out.println("Cannot handle negative integers");
            return;

        }
        if (num == 0) {
            System.out.println(0);
        }
        while (num > 0) {
            int bit = num % 2;
            bits.push("" + bit);

            num = num / 2;
        }


        while (!bits.isEmpty()){
            System.out.print(bits.pop());
        }
    }
}
