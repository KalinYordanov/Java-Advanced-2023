package stacksAndQueuesLab;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class k07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");
        int steps = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> kids = new PriorityQueue<>();
        Collections.addAll(kids, names);
        int currentSteps = 1;

        while (kids.size() > 1) {
            for (int i = 1; i < steps; i++) {
                String kid = kids.poll();
                kids.offer(kid);
            }
            if (isPrime(currentSteps)) {
                System.out.println("Prime " + kids.peek());
            } else {
                String removeChild = kids.poll();
                System.out.println("Removed " + removeChild);
            }
            currentSteps++;
        }
        System.out.println("Last is " + kids.poll());
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

