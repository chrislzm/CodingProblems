package com.chrisleung.other.solutions;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
    A Versioned Key Value Store
    @author Chris Leung

    Sample Input:

PUT key1 5
PUT key2 6
GET key1
GET key1 1
GET key2 2
PUT key1 7
GET key1 1
GET key1 2
GET key1 3
GET key4
GET key1 4

    Sample Output:
    
PUT(#1) key1 = 5
PUT(#2) key2 = 6
GET key1 = 5
GET key1(#1) = 5
GET key2(#2) = 6
PUT(#3) key1 = 7
GET key1(#1) = 5
GET key1(#2) = 5
GET key1(#3) = 7
GET key4 = <NULL>
GET key1(#4) = 7

 */
public class VersionedKeyValueStore {
    
    // Helper class: Stores a key's value and its corresponding version
    private class VersionValue {
        int version;
        int value;
        VersionValue(int ver, int val) {
            version = ver;
            value = val;
        }
    }
    
    // Constants
    private static final String PUT_TOKEN = "PUT";
    private static final String GET_TOKEN = "GET";
    private static final String NULL_TOKEN = "<NULL>";
    
    // Instance Variables
    private Map<String,List<VersionValue>> kvStore = new HashMap<>();
    private int curVer = 1;
    
    // Instance Methods
    
    // Returns version number of put
    int put(String key, int value) {
        List<VersionValue> values = kvStore.computeIfAbsent(key, k->new ArrayList<VersionValue>());
        values.add(new VersionValue(curVer,value));
        return curVer++; // Post increment
    }
    
    // Returns last value of key or NULL if it hasn't been set
    Integer get(String key) {
        List<VersionValue> values = kvStore.get(key);
        if(values == null)
            return null;
        VersionValue last = values.get(values.size()-1); 
        return last.value;
    }
    
    // Returns value of key at the time of version or NULL if it didn't exist
    Integer get(String key, int requestedVersion) {
        List<VersionValue> values = kvStore.get(key);
        if(values == null)  // Key doesn't exist
            return null;
        if(requestedVersion >= curVer) { // Version requested is greater than current version
            return values.get(values.size()-1).value; // Return latest value
        }
        if(values.get(0).version > requestedVersion) // Versions are all later than the requested version
            return null;
        // Otherwise, search for the version equal the requested version
        int leftIndex = 0;
        int rightIndex = values.size()-1;
        while(leftIndex <= rightIndex) { // Binary search for the version we're looking for
            int midIndex = leftIndex+rightIndex >>> 1; // This is same as ((left+right) / 2), but handles int overflow
            VersionValue mid = values.get(midIndex);
            if(mid.version > requestedVersion) {
                rightIndex = midIndex - 1;
            } else if(mid.version < requestedVersion) {
                leftIndex = midIndex + 1;
            } else { // mid.version == requestedVersion
                return mid.value;
            }
        }
        // Else, no equal version version was found.
        // leftIndex > rightIndex at this point, so return the closest earlier version (rightIndex) 
        return values.get(rightIndex).value;
    }
    
    // Runs commands from file specified in "inputPath", outputs results to output file specified in "outputPath"
    static void runFileInputWithFileOutput(String inputPath, String outputPath) throws IOException {
        
        VersionedKeyValueStore vkvStore = new VersionedKeyValueStore();
        
        Scanner scanner = new Scanner(new FileReader(inputPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
        
        while(scanner.hasNextLine()) {
            // Read line
            String input = scanner.nextLine(); 
            
            // Tokenize
            String[] tokens = input.split("\\s+");
            String operation = tokens[0];
            String key = tokens[1];
            
            if(operation.equals(PUT_TOKEN)) {
                int value = Integer.parseInt(tokens[2]);
                int curVer = vkvStore.put(key, value);
                String outputString = String.format("%s(#%d) %s = %d\n", PUT_TOKEN, curVer, key, value);
                writer.write(outputString);
            } else if(operation.equals(GET_TOKEN)) {
                // 2 tokens indicates no specific version has been specified for this key
                // 3 tokens indicates a specific version has been requested
                if(tokens.length == 2) { 
                    // Get the latest value for the key, if any.
                    Integer val = vkvStore.get(key);
                    String outputValue = val == null ? NULL_TOKEN : val.toString();
                    String outputString = String.format("%s %s = %s\n", GET_TOKEN, key, outputValue); 
                    writer.write(outputString);
                } else if(tokens.length == 3) {
                    // A specific version has been requested for this key.
                    int requestedVersion = Integer.parseInt(tokens[2]);
                    Integer val = vkvStore.get(key,requestedVersion);
                    String outputValue = val == null ? NULL_TOKEN : val.toString();
                    String outputString = String.format("%s %s(#%d) = %s\n", GET_TOKEN, key, requestedVersion, outputValue);
                    writer.write(outputString);
                }
            }
        }
        scanner.close();
        writer.close();
    }
    
    public static void main(String[] args) throws IOException {
        
        String inputFilePath = "/Users/cleung/Desktop/input.txt";
        String outputFilePath = "/Users/cleung/Desktop/myOutput.txt";
        runFileInputWithFileOutput(inputFilePath, outputFilePath);
        
        // Additional Tests

        /*
        VersionedKeyValueStore vkvStore = new VersionedKeyValueStore();
        int ver = vkvStore.put("key1", 1);
        System.out.println("Put key1, 1 version = " + ver);
        ver = vkvStore.put("key1", 2);
        System.out.println("Put key1, 2 version = " + ver);
        ver = vkvStore.put("key1", 5);
        System.out.println("Put key1, 5 version = " + ver);
        ver = vkvStore.put("key1", 10);
        System.out.println("Put key1, 10 version = " + ver);
        System.out.println("Get key1 = " + vkvStore.get("key1"));
        System.out.println("Get key1 ver 1 = " + vkvStore.get("key1", 1));
        System.out.println("Get key1 ver 2 = " + vkvStore.get("key1", 2));
        System.out.println("Get key1 ver 3 = " + vkvStore.get("key1", 3));
        System.out.println("Get key1 ver 4 = " + vkvStore.get("key1", 4));
        System.out.println("Get key1 ver 5 = " + vkvStore.get("key1", 5));
        */
    }
}
