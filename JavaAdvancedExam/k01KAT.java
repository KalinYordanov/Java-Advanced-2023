package JavaAdvancedExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class k01KAT {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Long> registrationPlateAsQueue = Arrays.stream(reader.readLine().split(", "))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Long> carsAsStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(", ")).map(Long::parseLong).forEach(carsAsStack::push);

        long countOfRegisteredCars = 0;
        long countOfInstallDays = 0;

        while (!registrationPlateAsQueue.isEmpty() && !carsAsStack.isEmpty()) {
            countOfInstallDays++;
            long currentNumberOfPlate = 0;
            for (int i = 0; i < 1; i++) {
                currentNumberOfPlate = registrationPlateAsQueue.poll();
            }
            long currNumberOfCars = 0;
            for (int i = 0; i < 1; i++) {
                currNumberOfCars = carsAsStack.pop();
            }
            if (currentNumberOfPlate > (currNumberOfCars * 2)) {
                registrationPlateAsQueue.addLast(currentNumberOfPlate - (currNumberOfCars * 2));
                countOfRegisteredCars += currNumberOfCars;
            } else if (currentNumberOfPlate < (currNumberOfCars * 2)) {
                long leftCar = currNumberOfCars - (currentNumberOfPlate / 2);
                carsAsStack.addLast(leftCar);
                countOfRegisteredCars += (currentNumberOfPlate /2);

            }else {
                countOfRegisteredCars += currNumberOfCars;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", countOfRegisteredCars ,countOfInstallDays);
        if (!registrationPlateAsQueue.isEmpty()){
            long sumOfUnplacedPlates = 0;
            while (!registrationPlateAsQueue.isEmpty()){
                sumOfUnplacedPlates += registrationPlateAsQueue.poll();
            }
            System.out.printf("%d license plates remain!",sumOfUnplacedPlates);
        }else if (!carsAsStack.isEmpty()){
            long sumOfCarsWithoutPlate = 0;
            while (!carsAsStack.isEmpty()){
                sumOfCarsWithoutPlate += carsAsStack.pop();
            }
            System.out.printf("%d cars remain without license plates!",sumOfCarsWithoutPlate);
        }else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

    }
}
