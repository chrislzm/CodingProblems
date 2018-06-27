package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> nums = new ArrayList<>();
        if(nestedList != null) {
            flatten(nestedList,nums);
        }
        iterator = nums.iterator();
    }

    private void flatten(List<NestedInteger> nestedList, List<Integer> nums) {
        for(NestedInteger n : nestedList) {
            if(n.isInteger()) {
                nums.add(n.getInteger());
            } else {
                flatten(n.getList(),nums);
            }
        }
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
