package com.chrisleung.other.solutions;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class SimpleDatabase {
  public static void main(String[] args) {
    testMinByKey();
    testFirstByKey();
    testRecordComparator();

    testFirstBySortOrder();

  }
  public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {
    return firstByKey(key,"asc",records);
  }
  
  
  public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
    LinkedHashMap<String,String> lhm = new LinkedHashMap<>();
    lhm.put(key,direction);
    return firstBySortOrder(lhm,records);
  }
  
  public static <T> void assertEqual(T expected, T actual) {
    if (expected == null && actual == null || actual != null && actual.equals(expected)) {
      System.out.println("PASSED");
    } else {
      throw new AssertionError("Expected:\n  " + expected + "\nActual:\n  " + actual + "\n");
    }
  }
  
  static class RecordComparator implements Comparator<Map<String, Integer>> {
    String key;
    boolean asc;
    
    public RecordComparator(String key, String direction) {
      this.key = key;
      asc = direction.equals("asc");
    }
 
    public int compare(Map<String, Integer> left, Map<String, Integer> right) {
      int leftVal = left.getOrDefault(key,0);
      int rightVal = right.getOrDefault(key,0);
      if(leftVal == rightVal) return 0;
      int returnVal = asc ? leftVal - rightVal : rightVal - leftVal;
      return returnVal > 0 ? 1 : -1;
    }
  }

  public static Map<String, Integer> firstBySortOrder(LinkedHashMap<String, String> sortOrder, List<Map<String, Integer>> records) {
    // 1. Create a list of compartor according sortOrder
    // 2. Create new comparator that iterates through all the comparators
    // 3. Create a priority queue...
    List<RecordComparator> rcl = new ArrayList<>();
    for(Map.Entry<String,String> e : sortOrder.entrySet()) {
      rcl.add(new RecordComparator(e.getKey(),e.getValue()));
    }
    Comparator<Map<String, Integer>> c = (a,b) -> {
      for(RecordComparator rc : rcl) {
        int compareVal = rc.compare(a,b);
        if(compareVal == 0) continue;
        return compareVal;
      }
      return 0;
    };
    PriorityQueue<Map<String, Integer>> pq = new PriorityQueue<Map<String, Integer>>(c);
    for(Map<String, Integer> m : records) {
      pq.add(m);
    }
    return pq.remove();    
  }

  
  public static void testFirstBySortOrder() {
    List<Map<String, Integer>> example1 = Arrays.asList(Maps.of("a", 5), Maps.of("a", 6));
    List<Map<String, Integer>> example2 = Arrays.asList(
      Maps.of("a", -5, "b", 10),
      Maps.of("a", -4, "b", 10)
    );

    System.out.println("firstBySortOrder");
    assertEqual(example1.get(1), firstBySortOrder(Maps.ordered("a", "desc"), example1));
    assertEqual(
      example2.get(0),
      firstBySortOrder(Maps.ordered("b", "asc", "a", "asc"), example2)
    );
    assertEqual(
      example2.get(1),
      firstBySortOrder(Maps.ordered("a", "desc", "b", "asc"), example2)
    );
  }
  
  
  public static void testRecordComparator() {
    RecordComparator cmp = new RecordComparator("a", "asc");
    Map<String, Integer> a1 = Maps.of("a", 1);
    Map<String, Integer> a2 = Maps.of("a", 2);
    System.out.println("RecordComparator");
    assertEqual(-1, cmp.compare(a1, a2));
    assertEqual(1, cmp.compare(a2, a1));
    assertEqual(0, cmp.compare(a1, a1));
  }
  
  public static void testMinByKey() {
    List<Map<String, Integer>> example1 = Arrays.asList(
      Maps.of("a", 1, "b", 2),
      Maps.of("a", 2)
    );
    List<Map<String, Integer>> example2 = Arrays.asList(example1.get(1), example1.get(0));
    List<Map<String, Integer>> example3 = Arrays.asList(Maps.of());
    List<Map<String, Integer>> example4 = Arrays.asList(
      Maps.of("a", -1),
      Maps.of("b", -1)
    );

    System.out.println("minByKey");
    assertEqual(example1.get(0), minByKey("a", example1));
    assertEqual(example2.get(1), minByKey("a", example2));
    assertEqual(example1.get(1), minByKey("b", example1));
    assertEqual(example3.get(0), minByKey("a", example3));
    assertEqual(example4.get(1), minByKey("b", example4));
  }  
  
    public static void testFirstByKey() {
    List<Map<String, Integer>> example1 = Arrays.asList(Maps.of("a", 1));
    List<Map<String, Integer>> example2 = Arrays.asList(
      Maps.of("b", 1),
      Maps.of("b", -2),
      Maps.of("a", 10)
    );
    List<Map<String, Integer>> example3 = Arrays.asList(
      Maps.of(),
      Maps.of("a", 10, "b", -10),
      Maps.of(),
      Maps.of("a", 3, "c", 3)
    );

    System.out.println("firstByKey");
    assertEqual(example1.get(0), firstByKey("a", "asc", example1));
    assertEqual(example2.get(0), firstByKey("a", "asc", example2));  // example2.get(1) ok too
    assertEqual(example2.get(2), firstByKey("a", "desc", example2));
    assertEqual(example2.get(1), firstByKey("b", "asc", example2));
    assertEqual(example2.get(0), firstByKey("b", "desc", example2));
    assertEqual(example3.get(1), firstByKey("a", "desc", example3));
  }
}


/*
 * Helpers to quickly create and populate new Maps.
 *
 * Inspired by ImmutableMap.of in guava.
 */

class Maps {
  public static <K, V> Map<K, V> of() {
    return new HashMap<K, V>();
  }

  public static <K, V> Map<K, V> of(K k1, V v1) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    return map;
  }

  public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    return map;
  }

  public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    return map;
  }

  public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    map.put(k4, v4);
    return map;
  }

  public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    map.put(k4, v4);
    map.put(k5, v5);
    return map;
  }

  public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1) {
    LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
    map.put(k1, v1);
    return map;
  }

  public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2) {
    LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    return map;
  }

  public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2, K k3, V v3) {
    LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    return map;
  }
}
