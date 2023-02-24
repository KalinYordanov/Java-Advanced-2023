package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class k08InfixToPostfix {
    public static String lowPrecedenceOperators = "+-";
    public static String highPrecedenceOperators = "/*";
    public static String brackets = "()";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> deque = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");
        Map<String, Integer> operators = new HashMap<>();
        populateMap(operators);

        for (int i = 0; i < input.length; i++) {
            String current = input[i];
            if (Character.isDigit(current.charAt(0)) || Character.isLetter(current.charAt(0))) {
                deque.offer(current);
            } else if (operators.containsKey(current)) {
                while (!stack.isEmpty()
                        && operators.containsKey(stack.peek())
                        && operators.get(current) <= operators.get(stack.peek())) {
                    deque.offer(stack.pop());
                }
                stack.push(current);
            } else if (brackets.contains(String.valueOf(current))) {
                if (current.equals("(")) {
                    stack.push(current);
                } else {
                    while (!stack.isEmpty()
                            && !stack.peek().equals("(")) {
                        deque.offer(stack.pop());
                    }
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            deque.offer(stack.pop());
        }
        for (String character :
                deque) {
            System.out.print(character + " ");
        }
        System.out.println();
    }
    public static void populateMap(Map<String , Integer> operators){
        operators.put("+",0);
        operators.put("-",0);
        operators.put("*",1);
        operators.put("/",1);
    }
}
