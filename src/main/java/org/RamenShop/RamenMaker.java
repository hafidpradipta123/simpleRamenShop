package org.RamenShop;

import java.util.HashMap;

public class RamenMaker {
    private HashMap<String, Integer> resources;

    public RamenMaker() {
        resources = new HashMap<>();
        resources.put("broth", 6);
        resources.put("mushroom", 2);
        resources.put("egg", 4);
        resources.put("noodle", 1);
        resources.put("seaweed", 1);
        resources.put("chili", 4);

    }

    public void report(){
        System.out.println("Broth:  "  + resources.get("broth") +" portion");
        System.out.println("Mushroom:  "  + resources.get("mushroom") +" portion");
        System.out.println("Egg:  "  + resources.get("egg") +" portion");
        System.out.println("Noodle:  "  + resources.get("noodle") +" portion");
        System.out.println("Seaweed:  "  + resources.get("seaweed") +" portion");
        System.out.println("Chili:  "  + resources.get("chili") +" portion");


    }

    public boolean isResourcesSufficient(HashMap<String, Integer> ramenIngredients){
        boolean canMake = true;
        for(String item : ramenIngredients.keySet()){
            if(ramenIngredients.get(item)> resources.getOrDefault(item,0)){
                System.out.println("There is not enough " + item);
                canMake= false;
            }
        }
        return canMake;

    }

    public void makeRamen(RamenItem order){
        for(String item: order.getIngredients().keySet()){
            resources.put(item, resources.get(item)- order.getIngredients().get(item));
        }
        System.out.println("Here is your " + order.getName() + " ramen. Enjoy!");

    }

}
