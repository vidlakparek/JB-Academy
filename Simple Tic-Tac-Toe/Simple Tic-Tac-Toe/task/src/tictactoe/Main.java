package tictactoe;

import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    static char[][] cells = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
    };
    private static boolean turn = true;

    public static void main(String[] args) {
        // write your code here
        //cells = readChar();
        print(cells);
        while (checkForResult(cells)) {
            readCordinates();
            print(cells);
        }
    }

    private static void readCordinates() {
        System.out.print("Enter the coordinates: ");
        String[] coordinates = SC.nextLine().split("\\s+");
        if (coordinates.length < 2) {
            System.out.print("You should enter two numbers!");
            readCordinates();
        } else if (isNotInteger(coordinates[0]) || isNotInteger(coordinates[1])) {
            System.out.println("You should enter numbers!");
            readCordinates();
        } else {
            int row = Integer.parseInt(coordinates[0]) - 1;
            int col = Integer.parseInt(coordinates[1]) - 1;
            if (row < 0 || 2 < row || col < 0 || 2 < col) {
                System.out.println("Coordinates should be from 1 to 3!");
                readCordinates();
            } else if (!isEmpty(row, col)) {
                System.out.println("This cell is occupied! Choose another one!");
                readCordinates();
            } else {
                if(turn) {
                    cells[row][col] = 'X';
                    turn=false;
                }
                else {
                    cells[row][col] = 'O';
                    turn=true;
                }
            }
        }
    }

    private static boolean isEmpty(int row, int col) {
        return cells[row][col] == '_';
    }

    private static boolean isNotInteger(String coordinate) {
        try {
            Integer.parseInt(coordinate);
            return false;
        } catch (Exception e) {
            return true;
        }
    }


    private static char[][] readChar() {
        System.out.print("Enter cells: ");
        String input = SC.nextLine().trim();
        char[][] cells = new char[3][3];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = input.charAt(j + (i * 3));
            }
        }
        return cells;
    }

    private static void print(char[][] cells) {
        System.out.println("---------");
        for (char[] cell : cells) {
            System.out.print("| ");
            for (char c : cell) {
                System.out.print(c);
                System.out.print(" ");

            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    private static boolean checkForResult(char[][] cells) {
        String winner = checkIfThereIsWinner(cells);
        if (!checkForPossibility(cells)) {
            System.out.println("Impossible");
            return false;
        } else if (winner != null) {
            System.out.println(winner);
            return false;
        } else {
            if (checkForDraw(cells)) {
                System.out.println("Draw");
                return false;
            } else {
                return true;
            }
        }
    }

    private static boolean checkForPossibility(char[][] cells) {
        int x = 0;
        int o = 0;
        int threes = 0;
        for (char[] cell : cells) {
            for (char c : cell) {
                if (c == 'X') x++;
                if (c == 'O') o++;
            }
        }
        if (Math.abs(x) - Math.abs(o) > 1 || Math.abs(o) - Math.abs(x) > 1) return false;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) if(cells[i][0]!='_')threes++;
        }
        for (int i = 0; i < cells.length; i++) {
            if (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) if(cells[i][0]!='_')threes++;
        }
        if (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) if(cells[0][0]!='_')threes++;
        if (cells[2][0] == cells[1][1] && cells[1][1] == cells[0][2]) if(cells[2][0]!='_')threes++;
        return threes <= 1;
    }

    private static boolean checkForDraw(char[][] cells) {
        for (char[] cell : cells) {
            for (char c : cell) {
                if (c == '_') return false;
            }
        }
        return true;
    }

    private static String checkIfThereIsWinner(char[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) if(cells[i][0]!='_') return (cells[i][0] + " wins");
        }
        for (int i = 0; i < cells.length; i++) {
            if (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) if(cells[0][i]!='_') return (cells[0][i] + " wins");
        }
        if (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) if(cells[0][0]!='_') return (cells[0][0] + " wins");
        if (cells[2][0] == cells[1][1] && cells[1][1] == cells[0][2]) if(cells[0][2]!='_') return (cells[0][2] + " wins");
        return null;
    }
}

