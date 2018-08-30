package com.company;

/**
 * Created by Sarah on 8/6/18.
 */
public class Karl implements Character {

    private String name;
    public Backpack backpack;
    private int maxHP;
    private int currentHP;
    private int coffeeHeal = 5;

    public Karl() {
        this.name = "Karl";
        this.backpack = new Backpack();
        this.maxHP = 20;
        this.currentHP = 20;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCurrentHealth() {
        return currentHP;
    }

    @Override
    public int getMaxHealth() {
        return maxHP;
    }

    @Override
    public void takeDamage(int dmg) {
        if (currentHP - dmg > 0) {
            currentHP -= dmg;
            System.out.printf("Ouch! Karl took %d damage! Karl's health is now at %d/%d!\n", dmg, currentHP, maxHP);
        } else {
            passOut();
        }
    }

    public void drinkCoffee() {
        if (currentHP + coffeeHeal > maxHP)
            currentHP = maxHP;
        else
            currentHP += coffeeHeal;
        System.out.printf("Yum!!! Coffee!!!!! It gives Karl %d HP.\nKarl now has %d/%d HP\n", coffeeHeal, currentHP, maxHP);
    }


    public class Backpack {
        Item coffee = new Item("Coffee", "Thermos full of coffee. Restores health.");
        private Weapon commonSense = new Weapon("Common Sense", "Duh.", 5);
        public Weapon[] weapons = {commonSense};

        public void printWeapons() {
            for (int i = 0; i < weapons.length; i++)
                System.out.println(i + ") " + weapons[i].getName());
        }

        public void addWeapon(Weapon weapon) {
            Weapon[] temp = weapons.clone();
            weapons = new Weapon[temp.length + 1];
            for (int i = 0; i < temp.length; i++)
                weapons[i] = temp[i];
            weapons[temp.length] = weapon;
        }

        public Weapon getWeaponAtIndex(int i) {
            try {
                return weapons[i];
            } catch (Exception e) {
                return null;
            }
        }
    }

    public void heal() {
        currentHP = maxHP;
    }

    public void passOut() {
        System.out.println("Karl has passed out from exhaustion! :(");
        Helpers.waitForMilliseconds(2000);
        System.out.println("...");
        System.out.println("But look! Weird...");
        Helpers.waitForMilliseconds(500);
        System.out.println("Is that a spaceship?!?!");
        Helpers.waitForMilliseconds(500);
        System.out.printf("\nOh dang. It IS a spaceship! It's... "); Helpers.waitForMilliseconds(500); System.out.printf("the MOTHERSHIP!\n");
        Helpers.waitForMilliseconds(500);
        System.out.println("A delegate from the mothership comes out and restores Karl to full health!");
        heal();
    }
}


