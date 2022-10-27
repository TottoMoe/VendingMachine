package com.VendingMachine;
import java.util.Scanner;
public class VendingMachine {

    public static void main(String[] args) {
        /** items' price */
        final int POTATO_CHIP = 125;
        final int COOKIES = 85;
        final int CANDIES = 95;

        /** items' name */
        String item1 = "Potato Chip";
        String item2 = "Cookies";
        String item3 = "Candies";

        /** Number of each item's quantity inside the vending machine. */
        int item1Quantity = 1;
        int item2Quantity = 1;
        int item3Quantity = 1;

        /** money and choice indicators */
        int choice, money, change;
        int quarters, dimes, nickels;

        boolean finishPurchase = false;

        Scanner in = new Scanner(System.in);

        while (true) {

            /** Message prompt for the buyer to enter the amount */
            System.out.print("Please enter the amount in cent (Dollar = 100 , Quarter = 25, Dime = 10, Nickel = 5): ");
            money = in.nextInt();

            do {
                /** Present a selection menu for the foods. */
                System.out.print("Please enter your selection (Potato Chip 125 cents Press 1, Cookies 85 cents Press 2, Candies 95 cents Press 3): ");
                choice = in.nextInt();

                /** Buyer makes the selection of the food. */
                switch (choice) {

                    /** Buyer selected 1 for Potato Chip. */
                    case 1:
                        if (item1Quantity <= 0) {                                  // Potato chip sold out, back to the main menu.
                            System.out.println("Sorry, " + item1 + " is Sold out. Please make another choice.\n");
                        } else if (money < POTATO_CHIP) {                          // Potato chip available, buyer enter with less money than price.
                            System.out.println("You must enter an amount over " + POTATO_CHIP + " cents.\n");
                        } else if (money == POTATO_CHIP) {                         // Potato chip available, buyer enter exact amount as the price.
                            System.out.println("Please take your " + item1 + " .\n");
                            item1Quantity--;
                            money -= POTATO_CHIP;                                  // Food dispensed, no more money to buy other items.
                        } else {                                                   // Potato chip available, buyer enter more money than price.
                            System.out.println("Please take your " + item1 + " .");
                            item1Quantity--;
                            change = money - POTATO_CHIP;
                            money -= POTATO_CHIP - change;                         // Food and change dispensed, no more money to buy other items.
                            System.out.println("Your change is " + change + " cents.");

                            /** Giving the change for left money */
                            quarters = change / 25;
                            change = change % 25;
                            dimes = change / 10;
                            change = change % 10;
                            nickels = change / 5;
                            System.out.println("Change in coins can be given as: " + quarters + " quarter(s), " + dimes + " dime(s) and " + nickels + " nickel(s).\n");
                        }
                        finishPurchase = true;
                        break;

                    /** Buyer selected 2 for Cookies. */
                    case 2:
                        if (item2Quantity <= 0) {
                            System.out.println("Sorry, " + item2 + " is Sold out. Please make another choice.\n");
                        } else if (money < COOKIES) {
                            System.out.println("You must enter an amount over " + COOKIES + " cents.\n");
                        } else if (money == COOKIES) {
                            System.out.println("Please take your " + item2 + " .\n");
                            item2Quantity--;
                            money -= COOKIES;
                        } else {
                            System.out.println("Please take your " + item2 + " .");
                            item2Quantity--;
                            change = money - COOKIES;
                            money -= COOKIES - change;
                            System.out.println("Your change is " + change + " cents.");
                            /** Giving the change for left money */
                            quarters = change / 25;
                            change = change % 25;
                            dimes = change / 10;
                            change = change % 10;
                            nickels = change / 5;
                            System.out.println("Change in coins can be given as: " + quarters + " quarter(s), " + dimes + " dime(s) and " + nickels + " nickel(s).\n");
                        }
                        finishPurchase = true;
                        break;

                    /** Buyer selected 3 for Candies. */
                    case 3:
                        if (item3Quantity <= 0) {
                            System.out.println("Sorry, " + item3 + " is Sold out. Please make another choice.\n");
                        } else if (money < CANDIES) {
                            System.out.println("You must enter an amount over " + CANDIES + " cents.\n");
                        } else if (money == CANDIES) {
                            System.out.println("Please take your " + item3 + ".\n");
                            item3Quantity--;
                            money -= CANDIES;
                        } else {
                            System.out.println("Please take your " + item3 + ".");
                            item3Quantity--;
                            change = money - CANDIES;
                            money -= CANDIES - change;
                            System.out.println("Your change is " + change + " cents.");

                            /** Giving the change for left money */
                            quarters = change / 25;
                            change = change % 25;
                            dimes = change / 10;
                            change = change % 10;
                            nickels = change / 5;
                            System.out.println("Change in coins can be given as: " + quarters + " quarter(s), " + dimes + " dime(s) and " + nickels + " nickel(s).\n");
                        }
                        finishPurchase = true;
                        break;

                    /** Buyer selects a food that does not exist. */
                    default:
                        System.out.println("The select food is not exist, you must enter a selection between 1 to 3. Thank you!\n");
                        finishPurchase = true;
                }
            } while (!finishPurchase);
        }
    }
}
