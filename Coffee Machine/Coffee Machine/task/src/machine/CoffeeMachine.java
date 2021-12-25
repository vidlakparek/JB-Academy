package machine;

import java.util.Scanner;


public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffee = 120;
    private static int cups = 9;
    private static int cash = 550;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Write action (buy, fill, take): ");
            switch (sc.nextLine()) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    status();
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
            System.out.println();
        }

    }

    private static void take() {
        System.out.println();
        System.out.println("I gave you $" + cash);
        cash = 0;
    }

    private static void fill() {
        System.out.println();
        System.out.println("Write how many ml of water you want to add: ");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffee += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cups += sc.nextInt();
    }

    private static void buy() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: : ");
        switch (sc.nextLine()) {
            case "1":
                if (water < 250) System.out.println("Sorry, not enough water!");
                else {
                    if (coffee < 16) System.out.println("Sorry, not enough coffee!");
                    else {
                        if (cups < 1) System.out.println("Sorry, not enough cups!");
                        else espresso();

                    }
                }
                break;

            case "2":
                if (water < 350) System.out.println("Sorry, not enough water!");
                else {
                    if (coffee < 20) System.out.println("Sorry, not enough coffee!");
                    else {
                        if (cups < 1) System.out.println("Sorry, not enough cups!");
                        else {
                            if (milk < 75) System.out.println("Sorry, not enough milk!");
                            else latte();
                        }
                    }
                }
                break;

            case "3":
                if (water < 200) System.out.println("Sorry, not enough water!");
                else {
                    if (coffee < 12) System.out.println("Sorry, not enough coffee!");
                    else {
                        if (cups < 1) System.out.println("Sorry, not enough cups!");
                        else {
                            if (milk < 100) System.out.println("Sorry, not enough milk!");
                            else cappucino();
                        }
                    }
                }
                break;
            case "back":
                break;
        }
    }

    private static void espresso() {
        water -= 250;
        coffee -= 16;
        cups--;
        cash += 4;
    }

    private static void latte() {
        water -= 350;
        milk -= 75;
        coffee -= 20;
        cups--;
        cash += 7;
    }

    private static void cappucino() {
        water -= 200;
        milk -= 100;
        coffee -= 12;
        cups--;
        cash += 6;

    }

    private static void status() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + cash + " of money");
    }
}
