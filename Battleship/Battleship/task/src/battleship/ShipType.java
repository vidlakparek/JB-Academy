package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ShipType {
    AirCraftCarrier(5, "AirCraft Carrier"),
    BattleShip(4, "Battleship"),
    Submarine(3, "Submarine"),
    Cruiser(3, "Cruiser"),
    Destroyer(2, "Destroyer");

    final int length;
    final String name;
    final List<int[]> locations = new ArrayList<>();
    boolean sunk;
    static int lode = 0;

    ShipType(int length, String name) {
        this.length = length;
        this.name = name;
        sunk = false;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public void addLocation(int[] location) {
        locations.add(location);
    }

    public static boolean allSunken() {
        for (ShipType shipType : values()) {
            if (!shipType.isSunk()) return false;
        }
        return true;
    }


    public static boolean shoot(int[] location) {
        for (ShipType shipType : values()) {
            if (!shipType.isSunk()) {
                for (int i = 0; i < shipType.length; i++) {
                    if (Arrays.equals(location, shipType.locations.get(i))) {
                        for (int j = 0; j < 2; j++) {
                            shipType.locations.get(i)[j] = 0;
                        }
                    }
                }
                if (isEmpty(shipType)) {
                    shipType.setSunk(true);
                    lode++;
                }
                if (lode==5) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    return true;
                }
                if (shipType.isSunk() && !allSunken()) {
                    System.out.println("You sank a ship! Specify a new target:");
                    return true;
                }
            }
        }
        return false;
    }

    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }

    public boolean isSunk() {
        return sunk;
    }

    private static boolean isEmpty(ShipType shipType) {
        for (int[] locs : shipType.locations) {
            for (int loc : locs) {
                if (loc != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
