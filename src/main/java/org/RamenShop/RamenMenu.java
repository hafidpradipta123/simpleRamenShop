package org.RamenShop;

import java.util.ArrayList;

public class RamenMenu {
    private final ArrayList<RamenItem> ramenMenu;

    public RamenMenu() {
        ramenMenu = new ArrayList<>();
        ramenMenu.add(new RamenItem("Pork", 800, 2, 1, 1, 1, 1, 0));
        ramenMenu.add(new RamenItem("Spicy Pork", 900, 2, 1, 1, 1, 1, 1));
        ramenMenu.add(new RamenItem("Spicy Spc Pork", 1200, 3, 1, 2, 1, 2, 1));

    }

    public String getItems() {
        StringBuilder options = new StringBuilder();
        for (RamenItem item : ramenMenu) {
            options.append(item.getName()).append("/");
        }
        return options.toString();

    }

    public RamenItem findMenu(String ordername) {
        for (RamenItem item : ramenMenu) {
            if (item.getName().equals(ordername)) {
                return item;
            }

        }
        System.out.println("Sorry your item is not available");
        return null;
    }

}
