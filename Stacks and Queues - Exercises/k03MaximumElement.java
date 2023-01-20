package stacksAndQueuesExercises;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class k03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> elementsDeque = new ArrayDeque<>();


        for (int i = 0; i < numberOfCommands; i++) {
            String input = scanner.nextLine();
            int command = Integer.parseInt(input.split("\\s+")[0]);

            if (command == 1){
                int number = Integer.parseInt(input.split("\\s+")[1]);
                elementsDeque.push(number);
            }else if (command == 2){
                elementsDeque.pop();
            }else if (command == 3){
                System.out.println(Collections.max(elementsDeque));
            }
        }
    }
}
