package tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String name = input[0] + " " + input[1];
        String city = input[2];
        Tuple<String, String> firstTuple = new Tuple<>(name, city);

        input = scanner.nextLine().split(" ");
        String firstName = input[0];
        Integer liters = Integer.parseInt(input[1]);
        Tuple<String,Integer> firstNameLiters = new Tuple<>(firstName,liters);

        input = scanner.nextLine().split(" ");
        Integer numbers = Integer.parseInt(input[0]);
        Double decimal = Double.parseDouble(input[1]);
        Tuple<Integer,Double> thirdTuple = new Tuple<>(numbers,decimal);

        System.out.println(firstTuple);
        System.out.println(firstNameLiters);
        System.out.println(thirdTuple);
    }
}
