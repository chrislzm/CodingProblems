package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Uber technical phone screen question response
 * @author Chris Leung
 */

//making change
//$1.30 -> $1, $0.25, $0.10, $0.05, $0.01
//¥1, ¥5, ¥10, ¥50, ¥100, ¥500
//write a function to take a value and return the coins that make up that value
//  10 dimes 5 nickels
//print out
//Support different denomination
//Decimal currencies
//"==" ">" "<" Float Double .equal .compareTo
//if(fpValue == 0.02)

abstract class Currency {
    // Amounts
    abstract List<Integer> getDenominations();
    
    // "Names"
    abstract String getName(int denomination);
    
    abstract String getCurrencyName();
    
    abstract int getDecimalPlaces();
}

class UsDollar extends Currency {
    LinkedHashMap<Integer,String> map;
    
    // NOTE: Input in decreasing order
    UsDollar() {
        map = new LinkedHashMap<>();
        map.put(100,"Dollar");
        map.put(25,"Quarter");
        map.put(10,"Dime");
        map.put(5,"Nickel");
        map.put(1,"Penny");
    }
    
    @Override
    List<Integer> getDenominations() {
        return new ArrayList<Integer>(map.keySet());
    }
    
    @Override
    String getName(int denomination) {
        return map.get(denomination);
    }
    
    @Override
    String getCurrencyName() {
        return "US Dollar";
    }
    
    @Override
    int getDecimalPlaces() {
        return 2;
    }

}

public class CoinChange {
    
    static LinkedHashMap<Integer,Integer> getChange(Currency c, int totalAmount) {
        if(c == null || totalAmount < 0) return new LinkedHashMap<Integer,Integer>();
        
        LinkedHashMap<Integer,Integer> amountOfDenominations = new LinkedHashMap<>();
        for(int denomination : c.getDenominations()) {
            int quantity = totalAmount/denomination;
            if(quantity>0) {
                totalAmount -= quantity*denomination;
                amountOfDenominations.put(denomination,quantity);
            }
        }
        return amountOfDenominations;
    }
    
    public static void main(String[] args) {
        UsDollar currency = new UsDollar();
        int amount = 168;
        LinkedHashMap<Integer,Integer> amountOfDenominations = getChange(currency,amount);
        int beforeDecimal = amount/((int)Math.pow(10,currency.getDecimalPlaces()));
        int afterDecimal = amount%((int)Math.pow(10,currency.getDecimalPlaces()));
        System.out.printf("Change for %s.%s %s\n",beforeDecimal,afterDecimal, currency.getCurrencyName());
        for(Map.Entry<Integer,Integer> e : amountOfDenominations.entrySet()) {
            int denomination = e.getKey();
            int quantity = e.getValue();
            System.out.printf("%s %s\n",quantity, currency.getName(denomination));          
        }
    }
}
