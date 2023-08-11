package org.RamenShop;

import java.util.HashMap;

public class RamenItem {
    private String name;
    private int cost;
    private HashMap<String, Integer> ingredients;

    public RamenItem(String name, int cost, int broth, int mushroom, int egg, int noodle, int seaweed, int chili) {
        this.name = name;
        this.cost = cost;
        ingredients = new  HashMap<>();
        ingredients.put("broth", broth);
        ingredients.put("mushroom", mushroom);
        ingredients.put("egg", egg);
        ingredients.put("noodle", noodle);
        ingredients.put("seaweed", seaweed);
        ingredients.put("chili", chili);


    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
