package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class k06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        long n = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(fibonacci, n));

    }

    private static Long getFibonacci(ArrayDeque<Long> fibonacci, Long N) {
        if (N == 1 || N < 2) {
            return 1L;
        } else {
            fibonacci.offer(0L);
            fibonacci.offer(1L);
            for (int i = 0; i < N; i++) {
                long sum = fibonacci.poll() + fibonacci.peek();
                fibonacci.offer(sum);
            }
        }
        fibonacci.poll();
        return fibonacci.peek();
    }
}
