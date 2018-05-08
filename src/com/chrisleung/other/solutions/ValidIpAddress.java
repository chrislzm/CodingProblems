package com.chrisleung.other.solutions;

import java.util.HashMap;
import java.util.Map;

//Part 1
//0 - 255
//"255.244.10.13" -> true
//"256.256.256.256" -> false
//"0.0.0.0" -> true
//"0.0.0.00" -> false

//"2552441013" -> true     ("255.244.10.13", "255.244.101.3")
//"256256256256" -> false
//"0000" -> true           ("0.0.0.0")
//"00000" -> false
//"0" -> false
//"526347589624375634785673" -> false

public class ValidIpAddress {

    public static void main(String[] args) {
      /*
      System.out.println(isValidIp("255.244.10.13"));
      System.out.println(isValidIp("256.256.256.256"));
      System.out.println(isValidIp("0.0.0.0"));
      System.out.println(isValidIp("0.0.0.00"));
      */
      System.out.println(canMakeValidIp("2552441013")); // true
      System.out.println(canMakeValidIp("256256256256")); // false
      System.out.println(canMakeValidIp("0")); // false
      System.out.println(canMakeValidIp("526347589624375634785673")); // false
      System.out.println(canMakeValidIp("0000")); // true
      System.out.println(canMakeValidIp("00000")); // false
    }
    
    //  n * (branches = 3,  depth =4)
    //  O(n * (branches ^ depth))
    //    O(n * (3^4))
    //       = O (n);
    // O(n*(3^k))  
    
    
    // O(n*(3^k)) - memo
    
    
    static boolean canMakeValidIp(String str) {
      if(str == null || str.length() < 4 || str.length() > 12) {
        return false;
      }
      return canMakeValidIpHelper(str,4,new HashMap<String,Boolean>());
    }
    
    // Base cases are empty or 3 characters or less
    static boolean canMakeValidIpHelper(String ip, int chunksLeft, Map<String,Boolean> memo) {
      if(ip.isEmpty() && chunksLeft > 0) {
        return false;
      } else if(chunksLeft == 0) {
        return ip.isEmpty();
      }
      String memoString = ip + "-" + chunksLeft;
      // Try 1, 2, or 3 characters
      if(memo.get(memoString) == null) {
        boolean result = false;
        for(int i=1; i<=3; i++) {
          if(ip.length() >= i) {
            String chunk = ip.substring(0,i);
            if(isValidIpChunk(chunk)) {
              if(canMakeValidIpHelper(ip.substring(i),chunksLeft-1,memo)) {
                result = true;
                break;
              }
            }
          }
        }
        memo.put(memoString,result);
      }
      return memo.get(memoString);
    }
      
    static boolean isValidIpChunk(String num) {
      return (num.length() == 1 || (num.length() > 1 && num.charAt(0) != '0')) && Integer.parseInt(num) <= 255;
    }
    
    
    // Assume valid input string
    static boolean isValidIp(String ip) {
      String[] nums = ip.split("\\.");
      for(String num : nums) {
        // Check leading zeros
        if(num.charAt(0) == '0' && num.length() > 1) {
          return false;
        }
        // Check valid number range
        if(Integer.parseInt(num) > 255) {
          return false;
        }
      }
      return true;    
    }

}
