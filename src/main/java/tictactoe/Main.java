package tictactoe;

import java.util.Scanner;

public class Main {
    public static int moveCounter = 0;
    public static boolean isXWin = false;
    public static boolean isOWin = false;
    public static boolean isExit = false;
    public static int column = 0;
    public static int raw = 0;
    static Scanner scanner = new Scanner(System.in);

    // Print table
    public static void printTable(char[][] charArray) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(charArray[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Count number of X, O, _
    public static int countNumberOf_(char[][] charArray) {
        int count_ = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (charArray[i][j] == '_') {
                    count_++;
                }
            }
        }
        return count_;
    }

    // Is X wins?
    public static boolean isXWins(char[][] charArray) {
        if (charArray[0][0] + charArray[0][1] + charArray[0][2] == 264 ||
                charArray[1][0] + charArray[1][1] + charArray[1][2] == 264 ||
                charArray[2][0] + charArray[2][1] + charArray[2][2] == 264 ||
                charArray[0][0] + charArray[1][0] + charArray[2][0] == 264 ||
                charArray[0][1] + charArray[1][1] + charArray[2][1] == 264 ||
                charArray[0][2] + charArray[1][2] + charArray[2][2] == 264 ||
                charArray[0][0] + charArray[1][1] + charArray[2][2] == 264 ||
                charArray[0][2] + charArray[1][1] + charArray[2][0] == 264) {
            isXWin = true;
        }
        return isXWin;
    }

    // Is O wins?
    public static boolean isOWins(char[][] charArray) {
        if (charArray[0][0] + charArray[0][1] + charArray[0][2] == 237 ||
                charArray[1][0] + charArray[1][1] + charArray[1][2] == 237 ||
                charArray[2][0] + charArray[2][1] + charArray[2][2] == 237 ||
                charArray[0][0] + charArray[1][0] + charArray[2][0] == 237 ||
                charArray[0][1] + charArray[1][1] + charArray[2][1] == 237 ||
                charArray[0][2] + charArray[1][2] + charArray[2][2] == 237 ||
                charArray[0][0] + charArray[1][1] + charArray[2][2] == 237 ||
                charArray[0][2] + charArray[1][1] + charArray[2][0] == 237) {
            isOWin = true;
        }
        return isOWin;
    }

    public static void showStart(char[][] charArray) {
        while (!isExit) {
            System.out.print("Enter the coordinates: ");
            String[] in = scanner.nextLine().split(" ");

            try {
                column = Integer.parseInt(in[0]) - 1;
                raw = Integer.parseInt(in[1]) - 1;

                if (column > 2 || column < 0 || raw > 2 || raw < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (charArray[raw][column] != '_') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (moveCounter % 2 == 0) {
                            charArray[raw][column] = 'X';
                        } else {
                            charArray[raw][column] = 'O';
                        }
                        moveCounter++;
                        printTable(charArray);

                        if (isXWins(charArray)) {
                            System.out.println("X wins");
                            isExit = true;
                        } else if (isOWins(charArray)) {
                            System.out.println("O wins");
                            isExit = true;
                        } else if (countNumberOf_(charArray) == 0 && !isOWin && !isXWin) {
                            System.out.println("Draw");
                            isExit = true;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    public static void main(String[] args) {

        String input = "_________";

        char[] firstRaw = input.substring(0, 3).toCharArray();
        char[] secondRaw = input.substring(3, 6).toCharArray();
        char[] thirdRaw = input.substring(6, 9).toCharArray();
        char[][] charArray = {firstRaw, secondRaw, thirdRaw};

        // Print table
        printTable(charArray);

        // Execute game
        showStart(charArray);
    }
}