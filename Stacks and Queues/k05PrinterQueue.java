package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class k05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String currentInput = scanner.nextLine();
        ArrayDeque<String> printer = new ArrayDeque<>();

        while (!currentInput.equals("print")) {
            if (currentInput.equals("cancel")) {
                String firstTask = printer.poll();

                if (firstTask == null) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + firstTask);
                }
            } else {
                printer.offer(currentInput);
            }

            currentInput = scanner.nextLine();
        }
        while (!printer.isEmpty()) {
            System.out.println(printer.poll());
        }
    }
}
