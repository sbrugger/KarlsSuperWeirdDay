package com.company;

/**
 * Base for both Karl and NPCs
 * Created by Sarah on 8/6/18.
 */
public interface Character {
    String getName();
    int getCurrentHealth();
    int getMaxHealth();
    void takeDamage(int dmg);
}
