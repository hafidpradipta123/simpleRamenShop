package org.RamenShop;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class MoneyMachine {
    private static final String CURRENCY ="¥";
    // Static currency/

    // linkedHashMap 500 200 100
    private static LinkedHashMap<String, Integer> MONEY = new LinkedHashMap<>();
    static{
        MONEY.put("500 Yen" , 500);
        MONEY.put("200 Yen" , 200);
        MONEY.put("100 Yen" , 100);
    }


    // money receive/
    private int moneyReceived;
    private int profit;

    public MoneyMachine() {
        moneyReceived = 0;
        profit = 0;
    }

    public void report(){
        System.out.println("Money "  + CURRENCY + profit);

    }

    public int processMoney(){
        Scanner scanner = new Scanner(System.in);
        for (String money: MONEY.keySet()){
            System.out.println("How many " + money + "?:");
            int sumMoney = scanner.nextInt();
            moneyReceived += sumMoney * MONEY.get(money);
        }
        return moneyReceived;
    }

    public boolean makePayment(int cost, int moneyReceived){
       // moneyReceived = processMoney();
        if(moneyReceived >= cost){
            int change = moneyReceived - cost;
            System.out.println("Here is your change " +CURRENCY +change);
            profit += change;
            moneyReceived = 0;
            return true;

        } else{
            System.out.println("You don't have enough money. The money got refunded");
            moneyReceived = 0;
            return false;

        }

    }

    // void report
    // processMoney
    //Makepayment
}
