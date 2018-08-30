package com.company;

/**
 * Created by Sarah on 8/6/18.
 */
public class Item {
    private String name;
    private String description;

    public Item(String Name, String Description) {
        this.name = Name;
        this.description = Description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
