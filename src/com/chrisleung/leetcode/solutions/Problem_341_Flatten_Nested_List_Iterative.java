package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class NestedIterator2 implements Iterator<Integer> {

    Iterator<Integer> iterator;
    
    public NestedIterator2(List<NestedInteger> nestedList) {
        List<Integer> flattenedList = new ArrayList<>();
        if(nestedList != null) {
            Deque<NestedInteger> stack = new LinkedList<>();
            Collections.reverse(nestedList);
            for(NestedInteger ni : nestedList ) {
                stack.push(ni);
            }
            while(!stack.isEmpty()) {
                NestedInteger ni = stack.pop();
                if(ni.isInteger()) {
                    flattenedList.add(ni.getInteger());
                } else {
                    List<NestedInteger> nl = ni.getList();
                    Collections.reverse(nl);
                    for(NestedInteger ni2 : nl) {
                        stack.push(ni2);
                    }
                }
            }
        }
        iterator = flattenedList.iterator();
    }
    
    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
