package stacksAndQueuesExercises;

import java.util.*;

public class k10Robotics {
    public static class Robot {
        private String name;
        private int processTime;

        public Robot(String name, int processTime) {
            this.name = name;
            this.processTime = processTime;
        }

        public String getName() {
            return name;
        }

        public int getProcessTime() {
            return processTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robots = scanner.nextLine().split(";");
        Map<Robot, Integer> robotsProcess = new LinkedHashMap<>();
        for (String entry : robots) {
            String name = entry.split("-")[0];
            int processTime = Integer.parseInt(entry.split("-")[1]);
            Robot robot = new Robot(name, processTime);
            robotsProcess.put(robot, 0);
        }
        String time = scanner.nextLine();
        int startTime = getStartedTimeInSeconds(time);

        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            productsQueue.offer(input);
            input = scanner.nextLine();
        }
        while (!productsQueue.isEmpty()) {
            String currentProduct = productsQueue.poll();
            startTime++;
            boolean isBusy = false;
            workingTime(robotsProcess);
            for (Map.Entry<Robot, Integer> entry :
                    robotsProcess.entrySet()) {
                if (entry.getValue() == 0) {
                    entry.setValue(entry.getKey().getProcessTime());
                    System.out.printf("%s - %s [%s]%n", entry.getKey().name, currentProduct, getTime(startTime));
                    isBusy = true;
                    break;
                }
            }
            if (!isBusy) {
                productsQueue.offer(currentProduct);
            }
        }
    }

    private static void workingTime(Map<Robot, Integer> robotsInProcess) {
        for (Map.Entry<Robot, Integer> entry :
                robotsInProcess.entrySet()) {
            if (entry.getValue() > 0) {
                robotsInProcess.put(entry.getKey(), entry.getValue() - 1);
            }
        }
    }

    private static int getStartedTimeInSeconds(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static String getTime(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
