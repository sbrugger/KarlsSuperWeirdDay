package com.company;

import java.util.Random;

/**
 * Created by Sarah on 8/6/18.
 */
public class Enemy implements Character {
    String name;
    String description;
    int damageMax;
    int maxHP;
    int currentHP;
    boolean defeated;

    public Enemy(String name, String description, int maxHealth, int damageMax) {
        this.name = name;
        this.description = description;
        this.maxHP = maxHealth;
        this.currentHP = maxHealth;
        this.damageMax = damageMax;
        this.defeated = false;
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
            System.out.printf(this.name + " is hit for %d damage! " + this.name + "'s health is now at %d/%d!\n\n", dmg, currentHP, maxHP);
        } else {
            currentHP = 0;
            defeated = true;
            System.out.printf(this.name + " is hit for %d damage! " + this.name + "'s health is now at %d/%d!\n", dmg, currentHP, maxHP);
            System.out.println("Victory!!! " + this.name + " is defeated!!\n\n");
        }
    }

    public int attack() {
        Random r = new Random();

        System.out.println(name + " is attacking!");

        return r.nextInt(damageMax + 1);
    }
}
