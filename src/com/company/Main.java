package com.company;

import java.util.Scanner;

/**
 * This project is completely unfinished :)
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Main Function
     * @param args args
     */
    public static void main(String[] args) {
        boolean wrongKey = true;
        String s;
        printTitle();

        Karl karl = new Karl();

        //while (!scanner.next().equalsIgnoreCase("n"));

        narrate("It's a beautiful day in Keyes Point, Alaska. Karl has made coffee, but is having a hard time motivating his sleepy self to go get stuff done! Looks like he's got to fight.... himself.");
        Enemy sleepyKarl = new Enemy("Sleepy Karl", "You but sleepy", 5, 1);

        combat(karl, sleepyKarl);

        narrate("Neat, it looks like Karl's woken up for the day! Guess he better go to work.");
        narrate("As he walks out the door to go to work, a gremlin in a trench coat blocks his way.");
        narrate("\"Hello, sir! Would you like to take a look at my wares??\"");

        System.out.println("What should Karl say?");
        System.out.println("\"What do you have?\" (W)");
        System.out.println("\"Go away.\" (G)");

        while (wrongKey) {
            s = scanner.next();

            if (s.equalsIgnoreCase("w")) {
                narrate("\"Why, here's a nice big two by four! It's enchanted! Great for bonking heads!\"");
                narrate("Karl doesn't have any Money yet. He has go to work and fight The Man to get Money.");
                wrongKey = false;

            } else if (s.equalsIgnoreCase("g")) {
                narrate("\"Oh... well... okay then. I'll catch you later. :(\"");
                narrate("Karl doesn't have any Money yet for whatever this stupid gremlin has, anyway. He has go to work and fight The Man to get Money.");
                wrongKey = false;
            } else {
                System.out.println("Whoops! You didn't match any dialogue option! Try (W) or (G) ");
                wrongKey = true;
            }
        }
        wrongKey = true;

        narrate("Karl heads to work. There, he encounters The Man, who is getting him down.");
        combat(karl, new Enemy("The Man", "He's getting Karl down", 17, 7));

        karl.backpack.addWeapon(new Weapon("Money", "It can't buy happiness, but it CAN buy cake.", 10));
        narrate("Look what Karl won from The Man! It's Money!");
        System.out.println("Greg the Gremlin poofs into existence in front of Karl.\n\"Wanna buy a magic two by four?\"\n");
        narrate("Since Karl has Money now, he can buy a magic two buy four!");
        narrate("Karl buys the two by four.");

        karl.backpack.addWeapon(new Weapon("Magic 2 x 4", "Big whack.", 10));
        System.out.println("Karl's weapons, currently:");
        for (Weapon w: karl.backpack.weapons)
            System.out.println(w.getName() + ": " + w.getDescription());
        narrate();
    }

    /**
     * Runs combat sequence
     * @param karl Karl
     * @param enemy Enemy to fight
     */
    private static void combat(Karl karl, Enemy enemy) {
        boolean wrongKey = true;
        boolean wrongIndex = true;
        String s;

        narrate("Karl is now in combat with " + enemy.getName() + "!" );

        while (karl.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0) {

            System.out.println("\nKarl's health: " + karl.getCurrentHealth() + "/" + karl.getMaxHealth());
            System.out.println(enemy.getName() + "'s health: " + enemy.getCurrentHealth() + "/" + enemy.getMaxHealth() + "\n");
            System.out.println("What should Karl use?");
            System.out.println("Weapon (press W)");
            System.out.println("Coffee (press C)");

            while (wrongKey) {
                s = scanner.next();

                if (s.equalsIgnoreCase("w")) {
                    System.out.println("Pick a weapon:");
                    while (wrongIndex){
                        karl.backpack.printWeapons();

                        if (scanner.hasNextInt()) {
                            Weapon w = karl.backpack.getWeaponAtIndex(scanner.nextInt());
                            if (w != null) {
                                wrongIndex = false;
                                enemy.takeDamage(w.doDamage());
                            } else {
                                System.out.println("Whoops! You didn't match any option in weapons! Try again!");
                                wrongIndex = true;
                            }
                        } else {
                            System.out.println("Whoops! You didn't match any option in weapons! Try again!");
                            scanner.next();
                            wrongIndex = true;
                        }

                    }
                    wrongKey = false;

                } else if (s.equalsIgnoreCase("c")) {
                    karl.drinkCoffee();
                    wrongKey = false;
                }
                else {
                    System.out.println("Whoops! You didn't match any combat option! Try (C) or (W) ");
                    wrongKey = true;
                }

            }
            wrongIndex = true;
            wrongKey = true;

            if (enemy.getCurrentHealth() > 0)
                karl.takeDamage(enemy.attack());

            if (karl.getCurrentHealth() <= 0)
                karl.passOut();
        }

        if (karl.getCurrentHealth() < karl.getMaxHealth()) {
            System.out.println("Karl drinks coffee until he regains all his energy. He's back to full health!!");
            karl.heal();
        }
        narrate();
    }

    /**
     * Prints the title card to the company
     */
    private static void printTitle() {
        System.out.printf("\n" +
                "\n" +
                "   ##########   ###   ############################################\n" +
                "                ##                                               # \n" +
                "    #####      ##   #######################################  ##  #\n" +
                "   ##   ##    ##                                          #   #  #\n" +
                "    ##   ##  ##                          #                #      #\n" +
                "         ## ##                           #                #####  #\n" +
                "   #     ####                            #    ###             #  #\n" +
                "   #  #  ####                            #     ##             #  #\n" +
                "   #  #  ## ##                           #     #              #  #\n" +
                "   #  #  ##  ##      #    ###    # ###   #         ####       #  #\n" +
                "   #  #  ##   ##     ##  #   #    #   #  #        ##          #  #\n" +
                "   #  #  ##    ##   ###  #  ##    #      ##         ###       #  #\n" +
                "   #  #  ##     ######    ## ##  ##       ###    #####        #  #\n" +
                "   #  #  ##                                                   #  #\n" +
                "   #  #  ##                                                   #  #\n" +
                "   #  #  ##    #####    #   #    #####    #####    ####       #  #\n" +
                "   #  #  ##    #        #   #    #   #    #        #   #      #  #\n" +
                "   #  #  ##    #####    #   #    #####    ###      ####       #  #\n" +
                "   #  #  #         #    #   #    #        #        #   #      #  #\n" +
                "   #  #        #####    #####    #        #####    #   #      #  #\n" +
                "   #  #                                                       #  #\n" +
                "   #  #        #   #    #####    #####    ####     ####       #  #\n" +
                "   #  #        #   #    #          #      #   #    #   #      #  #\n" +
                "   #  #        #   #    ###        #      ####     #   #      #  #\n" +
                "   #  #        # # #    #          #      #   #    #   #      #  #\n" +
                "   #  #        #####    #####    #####    #   #    ####       #  #\n" +
                "   #  #                                                       #  #\n" +
                "   #  #        #########        ########       #       #      #  #\n" +
                "   #  #        #        #      #        #      #       #      #  #\n" +
                "   #  #        #        #      #        #      #       #      #  #\n" +
                "   #  #        #        #      #        #       #     #       #  #\n" +
                "   #  #        #        #      ##########        #####        #  #\n" +
                "   #  #        #        #      #        #          #          #  # \n" +
                "   #  #        #        #      #        #          #          #  #\n" +
                "   #  #        #        #      #        #          #          #  #\n" +
                "   #  #        #########       #        #          #          #  #\n" +
                "   #  #####                                               #####  #\n" +
                "   #      #                                               #      #\n" +
                "   #  #   #                                               #   #  #\n" +
                "   #  ##  #################################################  ##  #\n" +
                "   #                                                             #\n" +
                "   ###############################################################\n\n");
        narrate();
    }

    /**
     * Asks user to press n to move on
     */

    private static void narrate() {
        System.out.println("[press (n) to continue]");
        if (scanner.nextLine().equalsIgnoreCase("n"))
            return;
        else
            narrate();
    }

    /**
     * Asks user to press n to move on after printing a string
     * @param s string to print before asking user to press n
     */
    private static void narrate(String s) {
        System.out.println(s);
        narrate();
    }
}
