package battleship;

public class Sea {
    private final char[][] field = new char[11][11];
    private final char[][] foggedField = new char[11][11];

    public Sea() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 && j == 0) {
                    field[i][j] = ' ';
                    foggedField[i][j] = ' ';
                } else if (i == 0) {
                    field[0][j] = (char) (j + 48);
                    foggedField[0][j] = (char) (j + 48);
                } else if (j == 0) {
                    field[i][0] = (char) (i + 64);
                    foggedField[i][0] = (char) (i + 64);
                } else {
                    field[i][j] = '~';
                    foggedField[i][j] = '~';
                }
            }
        }
    }

    public void printFogged() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (foggedField[i][j] == ':') System.out.print("10");
                else System.out.print(foggedField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void print() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (field[i][j] == ':') System.out.print("10");
                else System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void insert(int x1, int y1, int x2, int y2, ShipType shipType) {
        if (x1 == x2) {
            if (y1 < y2) {
                checkForSurroundingsX(x1, y1, y2, shipType);
            } else {
                checkForSurroundingsX(x1, y2, y1, shipType);
            }

        } else if (y1 == y2) {
            if (x1 < x2) {
                checkForSurroundingsY(x1, y1, x2, shipType);
            } else {
                checkForSurroundingsY(x2, y1, x1, shipType);
            }
        } else {
            System.out.println("Error! Wrong ship location! Try again:");
            System.out.println();
            Main.addBattleShip(shipType);
        }
        print();
    }

    private void checkForSurroundingsY(int x1, int y1, int x2, ShipType shipType) {
        for (int i = x1; i <= x2; i++) {
            if (i == 10 && y1 == 10) {
                if (field[i - 1][y1 - 1] == 'O' ||
                        field[i - 1][y1] == 'O' ||
                        field[i][y1 - 1] == 'O' ||
                        field[i][y1] == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    Main.addBattleShip(shipType);
                }
            } else if (i == 10) {
                if (field[i - 1][y1 + 1] == 'O' ||
                        field[i][y1 + 1] == 'O' ||
                        field[i - 1][y1 - 1] == 'O' ||
                        field[i - 1][y1] == 'O' ||
                        field[i][y1 - 1] == 'O' ||
                        field[i][y1] == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    Main.addBattleShip(shipType);
                }
            } else if (y1 == 10) {
                if (field[i + 1][y1 - 1] == 'O' ||
                        field[i + 1][y1] == 'O' ||
                        field[i - 1][y1 - 1] == 'O' ||
                        field[i - 1][y1] == 'O' ||
                        field[i][y1 - 1] == 'O' ||
                        field[i][y1] == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    Main.addBattleShip(shipType);
                }
            } else {
                if (field[i][y1 + 1] == 'O' ||
                        field[i + 1][y1] == 'O' ||
                        field[i + 1][y1 + 1] == 'O' ||
                        field[i - 1][y1 + 1] == 'O' ||
                        field[i + 1][y1 - 1] == 'O' ||
                        field[i - 1][y1 - 1] == 'O' ||
                        field[i - 1][y1] == 'O' ||
                        field[i][y1 - 1] == 'O' ||
                        field[i][y1] == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    Main.addBattleShip(shipType);
                }
            }

        }
        for (int i = x1; i <= x2; i++) {
            field[i][y1] = 'O';
            shipType.addLocation(new int[]{i, y1});
        }
    }

    private void checkForSurroundingsX(int x1, int y1, int y2, ShipType shipType) {
        for (int i = y1; i <= y2; i++) {
            if (x1 == 10 && i == 10) {
                if (field[x1 - 1][i - 1] == 'O' ||
                        field[x1][i - 1] == 'O' ||
                        field[x1 - 1][i] == 'O' ||
                        field[x1][i] == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    Main.addBattleShip(shipType);
                }
            } else if (x1 == 10) {
                if (field[x1 - 1][i + 1] == 'O' ||
                        field[x1][i + 1] == 'O' ||
                        field[x1 - 1][i - 1] == 'O' ||
                        field[x1][i - 1] == 'O' ||
                        field[x1 - 1][i] == 'O' ||
                        field[x1][i] == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    Main.addBattleShip(shipType);
                }
            } else if (i == 10) {
                if (field[x1 + 1][i - 1] == 'O' ||
                        field[x1 + 1][i] == 'O' ||
                        field[x1 - 1][i - 1] == 'O' ||
                        field[x1][i - 1] == 'O' ||
                        field[x1 - 1][i] == 'O' ||
                        field[x1][i] == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    Main.addBattleShip(shipType);
                }
            } else {
                if (field[x1 + 1][i] == 'O' ||
                        field[x1][i + 1] == 'O' ||
                        field[x1 + 1][i + 1] == 'O' ||
                        field[x1 + 1][i - 1] == 'O' ||
                        field[x1 - 1][i + 1] == 'O' ||
                        field[x1 - 1][i - 1] == 'O' ||
                        field[x1][i - 1] == 'O' ||
                        field[x1 - 1][i] == 'O' ||
                        field[x1][i] == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    Main.addBattleShip(shipType);
                }
            }

        }
        for (int i = y1; i <= y2; i++) {
            field[x1][i] = 'O';
            shipType.addLocation(new int[]{x1, i});
        }
    }

    public void shoot(int[] destination) {
        if (field[destination[0]][destination[1]] == 'O'||field[destination[0]][destination[1]] == 'X') {
            field[destination[0]][destination[1]] = 'X';
            foggedField[destination[0]][destination[1]] = 'X';
            System.out.println();
            printFogged();
            if (!ShipType.shoot(destination)) {
                System.out.println("You hit a ship! Try again:");
            }
        } else {
            field[destination[0]][destination[1]] = 'M';
            foggedField[destination[0]][destination[1]] = 'M';
            System.out.println();
            printFogged();
            System.out.println("You missed! Try again:");
        }
    }
}
