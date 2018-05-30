package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PinterestGrid {
    class Pin {
        int height;
        long id;
        // pin content: image, url, text/content, etc..
    }

    class Column {
        int height = 0;
        List<Pin> pins = new ArrayList<>();
        void addPin(Pin pin) {
            pins.add(pin);
            height += pin.height;
        }
    }
    public static List<List<Pin>> createGrid(List<Pin> pins, int numCols) {
        // Column height --- array of current heights, scan n cols
        //   priority queue / min-heap  OF  columns ordered by current height
        //       -remove the smallest one
        //       -log n, n = num cols

        // Create columns
        List<List<Pin>> columns = new ArrayList<List<Pin>>();
        for(int i=0; i<numCols; i++) {
            columns.add(new Column());
        }

        // Add to PQ
        PriorityQueue<Column> pq = new PriorityQueue<>((a,b)->a.height-b.height);
        for(Column column : columns) {
            pq.add(column);
        } // Test that we get first column first when all cols equal

        // while we have pins
        for(Pin pin : pins) {
            //  grab the shortest column 
            Column shortestCol = pq.remove();
            //  add the pin to column
            shortestCol.addPin(pin);
            /// add back into the priority queue
            pq.add(shortestCol);      
        }

        return columns;
    }

}
