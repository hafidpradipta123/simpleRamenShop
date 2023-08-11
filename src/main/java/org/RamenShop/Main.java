package org.RamenShop;

import java.util.Scanner;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MoneyMachine moneyMachine = new MoneyMachine();
        Scanner scanner = new Scanner(System.in);
        RamenMaker ramenMaker = new RamenMaker();
        RamenMenu menu = new RamenMenu();

        boolean isOn = true;

        while (isOn) {
            System.out.println("What would you like: " + menu.getItems() + ": ");
            String choice = scanner.nextLine();
            if (choice.equals( "off")) {
                isOn = false;
            } else if (choice.equals("report") ){
                moneyMachine.report();
                ramenMaker.report();
            } else if  (!choice.equals("Pork") ||!choice.equals("Pork") || !choice.equals("Pork") ){
                System.out.println("Sorry your item is not available");
                isOn = false;

            } else
            {
                RamenItem ramenItem = menu.findMenu(choice);
                int moneyReceived = moneyMachine.processMoney();
                if (ramenMaker.isResourcesSufficient(ramenItem.getIngredients()) && moneyMachine.makePayment(ramenItem.getCost(), moneyReceived)) {
                    ramenMaker.makeRamen(ramenItem);
                }
            }
        }
    }
}