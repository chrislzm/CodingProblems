package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reddit technical phone screen question
 * @author Chris Leung
 *
 */
public class PrintOrgChart {

    static class Person {
        String name;
        List<Person> subordinates = new ArrayList<>();

        Person(String n) {
            name = n;
        }

        void addSubordinate(Person p) {
            subordinates.add(p);
        }
    }

    public static void main(String[] args) {
        // Input is an array of strings
        String[] peopleList = {"A,B,C,D","B,E,F","D,G,I","G,H"};
        Person ceo = generateOrgchart(peopleList);
        printOrgchart(ceo,0);
        printOrgchartBonus(ceo,0,0);
    }

    static private Person generateOrgchart(String[] peopleLists) {
        // TODO: Input validation
        Map<String,Person> map = new HashMap<>();
        Person topManager = null;
        for(String peopleList : peopleLists) {
            String[] people = peopleList.split(",");
            // Get manager
            String managerName = people[0];
            Person manager = map.computeIfAbsent(managerName,k -> new Person(managerName));
            if(topManager == null) topManager = manager;
            // Add subordinates
            for(int i=1; i<people.length; i++) {
                final String personName = people[i];
                Person subordinate = map.computeIfAbsent(people[i],k -> new Person(personName));
                manager.addSubordinate(subordinate);
            }
        }
        return topManager;
    }

    static private void printOrgchart(Person person, int depth) {
        if(person == null) return;
        for(int i=0; i<depth; i++) {
            System.out.print("...."); 
        }
        System.out.print(person.name);
        System.out.print("\n");
        if(person.subordinates.size() > 0) {
            for(Person subordinate : person.subordinates) {
                printOrgchart(subordinate,depth+1);
            }
        }
    }

    static private void printOrgchartBonus(Person person, int depth, int siblings) {
        if(person == null) return;
        if(siblings > 0) {
          // TODO: Use stringbuilder instead to make this cleaner
          System.out.print("\n");
          for(int i=0; i<depth-1; i++) {
            System.out.print("|...."); 
          }
          System.out.print("|____"); 
        } else if(depth != 0) {
          System.out.print("____");
        }
        System.out.print(person.name);

        if(person.subordinates.size() > 0) {
          int numSiblings = 0;
          for(Person subordinate : person.subordinates) {
            printOrgchartBonus(subordinate,depth+1,numSiblings++);
          }
        }
     }
}
