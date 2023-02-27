package tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String name = input[0] + " " + input[1];
        String address = input[2];
        String city = input[3];
        Tuple<String, String, String> firstTuple = new Tuple<>(name, address, city);

        input = scanner.nextLine().split(" ");
        String firstName = input[0];
        Integer liters = Integer.parseInt(input[1]);
        boolean isDrunk = input[2].equals("drunk");
        Tuple<String, Integer, Boolean> firstNameLiters = new Tuple<>(firstName, liters, isDrunk);

        input = scanner.nextLine().split(" ");
        String realName = input[0];
        Double decimal = Double.parseDouble(input[1]);
        String bankName = input[2];
        Tuple<String, Double, String> thirdTuple = new Tuple<>(realName, decimal, bankName);

        System.out.println(firstTuple);
        System.out.println(firstNameLiters);
        System.out.println(thirdTuple);
    }

}
