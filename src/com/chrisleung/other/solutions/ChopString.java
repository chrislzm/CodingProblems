package com.chrisleung.other.solutions;

/**
 * Robinhood Technical Screen 8/2/18
 * @author Chris Leung
 *
 */
public class ChopString {
    
    public static String getWords(String s, int k) throws IllegalArgumentException {
        if(s == null || s.length() == 0 || k <= 0) throw new IllegalArgumentException();
        
        StringBuilder sb = new StringBuilder();
        while(true) {
          if(s.length() <= k) {
            sb.append(s);
            break;
          }
          int lastIndex = s.lastIndexOf(' ',k);
          if(lastIndex > 0) {
            sb.append(s.substring(0,lastIndex)).append('\n');
            s = s.substring(lastIndex+1);
          } else {
            throw new IllegalArgumentException();
          }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
      
      System.out.println("Test case 1");
      System.out.println(getWords("foo bar baz",3));
      System.out.println("Test case 2");
      System.out.println(getWords("foo bar baz",6));
      System.out.println("Test case 3");
      System.out.println(getWords("foo bar baz",7));
      System.out.println("Test case 4");
      System.out.println(getWords("foo bar baz",11));
      System.out.println("Test case 5");
      System.out.println(getWords("foo",3));
      System.out.println("Test case 6");
      System.out.println(getWords("foo",1));
      System.out.println("Test case 7");
      System.out.println(getWords("",5));
      System.out.println("Test case 8");
      System.out.println(getWords("foo",0));
      
      /*
      String s = "foo bar baz";
      System.out.println(s.lastIndexOf(' ', 3));
      System.out.println(s.lastIndexOf(' ', 5));
      System.out.println(s.lastIndexOf(' ', 7));
      */
    }

}
