package battleship;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Sea s1 = new Sea();


    public static void main(String[] args) {
        // Write your code here
        s1.print();
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        System.out.println();
        addBattleShip(ShipType.AirCraftCarrier);
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        System.out.println();
        addBattleShip(ShipType.BattleShip);
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        System.out.println();
        addBattleShip(ShipType.Submarine);
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        System.out.println();
        addBattleShip(ShipType.Cruiser);
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        System.out.println();
        addBattleShip(ShipType.Destroyer);
        System.out.println("The game starts!");
        System.out.println();
        s1.printFogged();
        System.out.println("Take a shot!");
        while (!ShipType.allSunken()) {
            shoot();
        }
    }

    public static void shoot() {
        System.out.println();
        int[] destination = stringToInt(sc.nextLine().trim());
        boolean recursive = true;
        for (int i : destination) {
            if (i < 1 || i > 10) {
                System.out.println("Error! Wrong ship location! Try again:");
                System.out.println();
                recursive = false;
                shoot();
            }
        }
        if (recursive) s1.shoot(destination);
    }

    public static void addBattleShip(ShipType shipType) {
        int[] coordinates = stringToInt(sc.nextLine().trim().split(" "));
        for (int i : coordinates) {
            if (i < 1 || i > 10) {
                System.out.println("Error! Wrong ship location! Try again:");
                System.out.println();
                addBattleShip(shipType);
            }
        }
        boolean recursive = true;
        if (coordinates[0] == coordinates[2]) {
            if (!(coordinates[1] - coordinates[3] == (shipType.getLength() - 1) || coordinates[3] - coordinates[1] == (shipType.getLength() - 1))) {
                System.out.println("Error! Wrong length of the " + shipType.getName() + "! Try again:");
                System.out.println();
                recursive = false;
                addBattleShip(shipType);
            }
        } else if (coordinates[1] == coordinates[3]) {
            if (!(coordinates[0] - coordinates[2] == (shipType.getLength() - 1) || coordinates[2] - coordinates[0] == (shipType.getLength() - 1))) {
                System.out.println("Error! Wrong length of the " + shipType.getName() + "! Try again:");
                System.out.println();
                recursive = false;
                addBattleShip(shipType);
            }
        }
        if (recursive) {
            s1.insert(coordinates[0], coordinates[1], coordinates[2], coordinates[3], shipType);
        }
    }

    private static int[] stringToInt(String[] coordinates) {
        int x1 = coordinates[0].charAt(0) - 64;
        int y1 = coordinates[0].charAt(1) - 48;
        if (coordinates[0].length() == 3) y1 = (y1 * 10) + (coordinates[0].charAt(2) - 48);
        int x2 = coordinates[1].charAt(0) - 64;
        int y2 = coordinates[1].charAt(1) - 48;
        if (coordinates[1].length() == 3) y2 = (y2 * 10) + (coordinates[1].charAt(2) - 48);
        return new int[]{x1, y1, x2, y2};
    }

    private static int[] stringToInt(String coordination) {
        int x1 = coordination.charAt(0) - 64;
        int y1 = coordination.charAt(1) - 48;
        if (coordination.length() == 3) y1 = (y1 * 10) + (coordination.charAt(2) - 48);
        return new int[]{x1, y1};
    }
}
