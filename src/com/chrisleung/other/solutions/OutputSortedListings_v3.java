package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class OutputSortedListings_v3 {


    public static void main(String[] args) {

        int perPage = 12;

        ArrayList<String> input = new ArrayList<String>();
        input.add("host_id,listing_id,score,city");
        input.add("1,28,300.1,San Francisco");
        input.add("4,5,209.1,San Francisco");
        input.add("20,7,208.1,San Francisco");
        input.add("23,8,207.1,San Francisco");
        input.add("16,10,206.1,Oakland");
        input.add("1,16,205.1,San Francisco");
        input.add("1,31,204.6,San Francisco");
        input.add("6,29,204.1,San Francisco");
        input.add("7,20,203.1,San Francisco");
        input.add("8,21,202.1,San Francisco");
        input.add("2,18,201.1,San Francisco");
        input.add("2,30,200.1,San Francisco");
        input.add("15,27,109.1,Oakland");
        input.add("10,13,108.1,Oakland");
        input.add("11,26,107.1,Oakland");
        input.add("12,9,106.1,Oakland");
        input.add("13,1,105.1,Oakland");
        input.add("22,17,104.1,Oakland");
        input.add("1,2,103.1,Oakland");
        input.add("28,24,102.1,Oakland");
        input.add("18,14,11.1,San Jose");
        input.add("6,25,10.1,Oakland");
        input.add("19,15,9.1,San Jose");
        input.add("3,19,8.1,San Jose");
        input.add("3,11,7.1,Oakland");
        input.add("27,12,6.1,Oakland");
        input.add("1,3,5.1,Oakland");
        input.add("25,4,4.1,San Jose");
        input.add("5,6,3.1,San Jose");
        input.add("29,22,2.1,San Jose");
        input.add("30,23,1.1,San Jose"); 

        System.out.printf("Input: %s Total Listings\n",input.size()-1); // Subtract 1 for the title row
        List<String> pageFriendlyListings = getSortedPages(input,perPage);
        printPages(pageFriendlyListings,perPage);
        System.out.printf("Output: %s Total Listings\n",pageFriendlyListings.size());
        /* Thanks Naveen, that was fun. Have a good day. */
    }

    static class Listing {
        Float score;
        String hostId;
        String listing;
        Listing(float s, String h, String l) {
            score = s;
            hostId = h;
            listing = l;
        }
    }

    static class Host {
        String hostId;
        LinkedList<Listing> listings = new LinkedList<>();
        Host(String s) {
            hostId = s;
        }
    }

    static Listing getListingFromString(String s) {
        String[] fields = s.split(",");
        String hostId = fields[0];
        float score = Float.parseFloat(fields[2]);
        return new Listing(score,hostId,s);
    }

    static List<String> getSortedPages(ArrayList<String> listings, int perPage) {
        Set<String> set = new HashSet<>();
        PriorityQueue<Host> duplicates = new PriorityQueue<>((a,b)->b.listings.getFirst().score.compareTo(a.listings.getFirst().score));
        Map<String,Host> map = new HashMap<>();
        List<String> output = new ArrayList<>();

        int count = 0;
        for(int i=1; i<listings.size(); i++) {
            if(count > 0 && count % perPage == 0) {
                set.clear();
                count = 0;
                LinkedList<Host> temp = new LinkedList<>();
                while(!duplicates.isEmpty()) {
                    Host h = duplicates.poll();
                    output.add(h.listings.removeFirst().listing);
                    set.add(h.hostId);
                    temp.add(h);
                    count++;
                }
                while(!temp.isEmpty()) {
                    Host h = temp.removeFirst();
                    if(h.listings.size() > 0) {
                        duplicates.add(h);
                    }
                }         
            }
            Listing l = getListingFromString(listings.get(i));
            if(!set.contains(l.hostId)) {
                output.add(l.listing);
                set.add(l.hostId);
                count++;
            } else {
                Host h = map.computeIfAbsent(l.hostId, k->new Host(l.hostId));
                h.listings.add(l);
                if(h.listings.size() == 1) { // Not in priority queue
                    duplicates.add(h);
                }
            }
        }
        while(!duplicates.isEmpty()) {
            Host h = duplicates.poll();
            output.add(h.listings.removeFirst().listing);
            if(h.listings.size() > 0) {
                duplicates.add(h);
            }
        }
        return output;
    }

    public static void printPages(List<String> listings, int pageSize) {
        for(int i=0; i<listings.size(); i++) {
            if(i%pageSize == 0) {
                System.out.println("-----------------------");
            }
            System.out.println(listings.get(i));
        }
    }
}
