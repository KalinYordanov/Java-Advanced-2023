package multidimensionalArraysExercises;

import java.util.Scanner;

public class k08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double heiganHitPoints = 3000000.0;
        int playerPoints = 18500;

        int startPlayerRow = 7;
        int startPlayerCol = 7;

        String lastSpell = "";
        boolean activeCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (playerPoints > 0 && heiganHitPoints > 0) {
            heiganHitPoints -= damage;
            if (activeCloud) {
                playerPoints -= 3500;
                activeCloud = false;
                if (playerPoints < 0) {
                    break;
                }
            }
            if (heiganHitPoints < 0) {
                break;
            }
            String[] input = scanner.nextLine().split("\\s+");
            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            boolean[][] chamber = new boolean[15][15];
            fillDamageHeigan(row, col, chamber);
            //----> moving
            if (chamber[startPlayerRow][startPlayerCol]) {
                if (isValidRow(chamber, startPlayerRow - 1) && !chamber[startPlayerRow - 1][startPlayerCol]) {
                    startPlayerRow--;
                } else if (isValidCol(chamber, startPlayerCol + 1) && !chamber[startPlayerRow][startPlayerCol + 1]) {
                    startPlayerCol++;
                } else if (isValidRow(chamber, startPlayerRow + 1) && !chamber[startPlayerRow + 1][startPlayerCol]) {
                    startPlayerRow++;
                } else if (isValidCol(chamber, startPlayerCol - 1) && !chamber[startPlayerRow][startPlayerCol - 1]) {
                    startPlayerCol--;
                }
            }
            if (chamber[startPlayerRow][startPlayerCol]) {
                switch (spell) {
                    case "Cloud":
                        playerPoints -= 3500;
                        activeCloud = true;
                        lastSpell = "Plague cloud";
                        break;
                    case "Eruption":
                        playerPoints -= 6000;
                        lastSpell = "Eruption";
                        break;
                }
            }

        }
        if (heiganHitPoints > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
        } else {
            System.out.printf("Heigan: Defeated!%n");
        }
        if (playerPoints > 0){
            System.out.printf("Player: %d%n",playerPoints);
        }else {
            System.out.printf("Player: Killed by %s%n",lastSpell);
        }
        System.out.printf("Final position: " + startPlayerRow + ", " + startPlayerCol);

    }

    private static void fillDamageHeigan(int row, int col, boolean[][] chamber) {
        for (int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < chamber.length) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (j >= 0 && j < chamber[row].length) {
                        chamber[i][j] = true;
                    }
                }
            }

        }
    }

    private static boolean isValidRow(boolean[][] chamber, int startRow) {
        return startRow >= 0 && startRow < chamber[startRow].length;
    }

    private static boolean isValidCol(boolean[][] chamber, int startCol) {
        return startCol >= 0 && startCol < chamber.length;
    }
}
