package com.chrisleung.other.solutions;

import java.io.*;
import java.util.*;

public class OutputSortedListings {


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

    public static void printPages(List<String> listings, int pageSize) {
        for(int i=0; i<listings.size(); i++) {
            if(i%pageSize == 0) {
                System.out.println("-----------------------");
            }
            System.out.println(listings.get(i));
        }
    }


    public static List<String> getSortedPages(List<String> listings, int perPage) {
        // Host ID - Listing Map
        Set<String> uniqueHostsOnPage = new HashSet<>();
        List<String> output = new ArrayList<>();
        // Host IDs we need to use because they have duplicates    
        PriorityQueue<Listing> q = new PriorityQueue<Listing>((a,b)->b.score.compareTo(a.score));
        for(int i=1; i<listings.size(); i++) {
            String[] fields = listings.get(i).split(",");
            q.add(new Listing(Float.parseFloat(fields[2]),fields[0],listings.get(i)));
        }

        List<Listing> temp = new ArrayList<>();
        int listingsOnPage = 0;
        while(!q.isEmpty()) {
            Listing l = q.poll();

            if(uniqueHostsOnPage.contains(l.hostId)) {
                temp.add(l);
            } else {
                output.add(l.listing);
                uniqueHostsOnPage.add(l.hostId);
                if(++listingsOnPage == perPage) {
                    for(Listing t : temp) {
                        q.add(t);
                    }
                    temp.clear();
                    listingsOnPage = 0;
                    uniqueHostsOnPage.clear();
                }
            }
        }
        for(Listing l : temp) {
            output.add(l.listing);
        }
        return output;
    }


    // If we don't have at least 12 unique people left, we need to start showing duplicates

    // Show duplicates at the end 3 listings   -  10 people with low scores
    // 11 unique users
    // Saves duplicates for last
    //  "duplicates" 





    // Set -- 12 items 
    //   - If duplicate host, put that entry into another data structure "duplicates" to hold until next page
    // Next page
    //   - Extract any hosts from the "duplicates"
    //   - Do some logic to prevent showing duplicates if we don't have to
    //       - We need a way to determine whether to output duplicates or not 
    //       - Other special case: example 1-2 hosts with 24+ listings


}

/*

    You’re given an array of CSV strings representing search results. Results are sorted by a score initially. A given host may have several listings that show up in these results. Suppose we want to show 12 results per page, but we don’t want the same host to dominate the results. Write a function that will reorder the list so that a host shows up at most once on a page if possible, but otherwise preserves the ordering. Your program should return the new array and print out the results in blocks representing the pages.

    12 results / page
    Must be decreasing by score
    Edge case-- no others hosts to show, then show more than 1 host on a page
    Returns "newly sorted" array
    Print out the array from different method


    [
        "host_id,listing_id,score,city",
        "1,28,300.1,San Francisco",
        "4,5,209.1,San Francisco",
        "20,7,208.1,San Francisco",
        "23,8,207.1,San Francisco",
        "16,10,206.1,Oakland",
        "1,16,205.1,San Francisco",
        "1,31,204.6,San Francisco",
        "6,29,204.1,San Francisco",
        "7,20,203.1,San Francisco",
        "8,21,202.1,San Francisco",
        "2,18,201.1,San Francisco",
        "2,30,200.1,San Francisco",
        "15,27,109.1,Oakland",
        "10,13,108.1,Oakland",
        "11,26,107.1,Oakland",
        "12,9,106.1,Oakland",
        "13,1,105.1,Oakland",
        "22,17,104.1,Oakland",
        "1,2,103.1,Oakland",
        "28,24,102.1,Oakland",
        "18,14,11.1,San Jose",
        "6,25,10.1,Oakland",
        "19,15,9.1,San Jose",
        "3,19,8.1,San Jose",
        "3,11,7.1,Oakland",
        "27,12,6.1,Oakland",
        "1,3,5.1,Oakland",
        "25,4,4.1,San Jose",
        "5,6,3.1,San Jose",
        "29,22,2.1,San Jose",
        "30,23,1.1,San Jose"
    ]


 */
