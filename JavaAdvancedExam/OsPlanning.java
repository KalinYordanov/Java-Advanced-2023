package ExamPrep17october22;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OsPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //LIFO order
        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);
        //FIFO
        ArrayDeque<Integer> treads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        int endTask = Integer.parseInt(scanner.nextLine());

        int task = tasks.peek();
        int tread = treads.peek();

        while (task != endTask) {
            if (tread >= task) {
                tasks.pop();
            }

            treads.poll();
            task = tasks.peek();
            tread = treads.peek();
        }

        System.out.println("Thread with value " + treads.peek() + " killed task " + endTask);
        String leftThreads = treads.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(leftThreads);

    }
}
