package com.chrisleung.other.solutions;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Finds which charges match which set of POs (1:many relationship) and outputs to a file.
 *  
 * Reads a file with the following format:
 *   - # of charges (integer), followed by date + charge amounts separated by whitespace on following lines
 *   - # of purchase orders (POs), followed by date + PO# + amount 
 *  
 * Example file input:
 * 
 * 2
 * 10/5/12  593.52  
 * 11/20/13 231.25
 * 4
 * 1/5/12   PO-582  293.00
 * 2/4/12   PO-528  31.25
 * 4/2/12   PO-592  300.52
 * 5/6/12   PO-601  200.00
 * 
 * Example file output:
 * 
 * 10/5/12  593.52
 *      1/5/12   PO-582  293.00
 *      4/2/12   PO-592  300.52
 * 11/20/13 231.25
 *      2/4/12   PO-528  31.25
 *      5/6/12   PO-601  200.00
 *      
 * @author Chris Leung
 *
 */
public class SubsequenceMatchSums {
    private static Scanner scanner;

    public static Map<String,List<String>> matchSubSequence(String filepath) {
        Map<String,List<String>> output = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader(filepath));
            int numCharges = Integer.parseInt(scanner.nextLine());
            // System.out.println("Total number of charges: " + numCharges);
            String[] chargeDatesAndAmounts = new String[numCharges];
            int[] chargeAmounts = new int[numCharges];
            for(int i=0; i<numCharges; i++) {
                chargeDatesAndAmounts[i] = scanner.nextLine();
                chargeAmounts[i] = getValueInCents(chargeDatesAndAmounts[i].split("\\s+")[1]);
            }
            // System.out.println("Charge Dates and Amounts: " + Arrays.toString(chargeDatesAndAmounts));
            // System.out.println("Charge Amounts: " + Arrays.toString(chargeAmounts));
            int numPOs = Integer.parseInt(scanner.nextLine());
            // System.out.println("Total number of POs: " + numPOs);
            String[] pos = new String[numPOs];
            int[] poAmts = new int[numPOs];
            for(int i=0; i<numPOs; i++) {
                pos[i] = scanner.nextLine();
                poAmts[i] = getValueInCents(pos[i].split("\\s+")[2]);
            }
            // System.out.println("PO Dates, Numbers and Amounts: " + Arrays.toString(pos));
            // System.out.println("PO Amounts: " + Arrays.toString(poAmts));
            boolean[] usedPo = new boolean[numPOs];
            for(int i=0; i<numCharges; i++) {
                int chargeAmount = chargeAmounts[i];
                List<String> posForCharge = new ArrayList<>();
                if(!recursiveFind(chargeAmount,pos,poAmts,usedPo, 0, posForCharge)) {
                    System.out.println("Couldn't resolve charge: " + chargeDatesAndAmounts[i]);
                    return null;
                }
                Collections.reverse(posForCharge);
                output.put(chargeDatesAndAmounts[i], posForCharge);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }
    
    private static boolean recursiveFind(int chargeAmount, String[] pos, int[] poAmts, boolean[] usedPo, int iStart, List<String> posForCharge) {
        if(chargeAmount == 0) return true;
        if(chargeAmount < 0) return false;
        for(int i=iStart; i<usedPo.length; i++) {
            if(usedPo[i]) continue;
            // Try using each amount
            usedPo[i] = true;
            if(recursiveFind(chargeAmount - poAmts[i], pos, poAmts, usedPo, i+1, posForCharge)) {
                posForCharge.add(pos[i]);
                return true;
            }
            usedPo[i] = false;
        }
        return false;
    }
    
    public static int getValueInCents(String s) {
        if(s.contains(".")) {
            int result = Integer.parseInt(s.replace(".", ""));
            return result;
        }
        return Integer.parseInt(s) * 100;
    }
    
    public static void main(String[] args) {
        Map<String,List<String>> result = matchSubSequence("/Users/cleung/Desktop/amts.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/users/cleung/Desktop/result.txt"));
            for(Map.Entry<String, List<String>> e : result.entrySet()) {
                writer.write(e.getKey() + "\n");
                for(String s : e.getValue()) {
                    writer.write("\t" + s + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
