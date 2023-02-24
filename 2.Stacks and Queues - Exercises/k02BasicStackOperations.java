package stacksAndQueuesExercises;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
public class k02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int  x = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int count = 1; count <= n; count++) {
            stack.push(scanner.nextInt());
        }
        for (int count = 1; count <= s; count++) {
            stack.pop();
        }
        if (stack.contains(x)){
            System.out.println("true");
        }else {
            if (stack.isEmpty()){
                System.out.println(0);
            }else {
                System.out.println(Collections.min(stack));
            }
        }


        }
    }

