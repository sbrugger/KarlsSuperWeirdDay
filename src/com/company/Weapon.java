package com.company;

import java.util.Random;

/**
 * Created by Sarah on 8/6/18.
 */
public class Weapon extends Item {
    private int damageMax;

    public Weapon(String Name, String Description, int dmgMax) {
        super(Name, Description + " Does up to " + dmgMax + " damage!");
        this.damageMax = dmgMax;
    }

    public Weapon(String Name, int dmgMax) {
        super(Name, "Does up to " + dmgMax + " damage!");
        this.damageMax = dmgMax;
    }

    public int doDamage() {
        Random r = new Random();
        return r.nextInt(damageMax + 1);
    }
}
