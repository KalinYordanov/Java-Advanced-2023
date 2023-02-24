package stacksAndQueuesExercises;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class k04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int count = 1; count <= n; count++) {
                deque.offer(scanner.nextInt());
        }
        for (int count = 1; count <= s; count++) {
            deque.poll();
        }
        if (deque.contains(x)){
            System.out.println("true");
        }else {
            if (deque.isEmpty()){
                System.out.println(0);
            }else {
                System.out.println(Collections.min(deque));
            }
        }
    }
}
