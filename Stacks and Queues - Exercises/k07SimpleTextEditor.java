package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class k07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();


        for (int commandArr = 1; commandArr <= n; commandArr++) {
            String command = scanner.nextLine();
            if (command.startsWith("1")) {
                textStack.push(currentText.toString());
                String text = command.split("\\s+")[1];
                currentText.append(text);

            } else if (command.startsWith("2")) {
                textStack.push(currentText.toString());
                int count = Integer.parseInt(command.split("\\s+")[1]);
                int startIndexForDelete = currentText.length() - count;
                currentText.delete(startIndexForDelete,currentText.length());

            } else if (command.startsWith("3")) {

                int positions = Integer.parseInt( command.split("\\s+")[1]);

                System.out.println(currentText.charAt(positions - 1));

            } else if (command.equals("4")) {
                if (!textStack.isEmpty()) {
                    String last = textStack.pop();
                    currentText = new StringBuilder(last);
                }
            }
        }
    }
}
