package com.chrisleung.other.solutions;

import java.util.Map;

// Return the object if it's in the cache, otherwise null
// Key-value mapping

public class LRUCache<K,V> {
    
    private class Node<E> {
        Node<E> next;
        Node<E> prev;
        E value;
        Node(E d) {
            value = d;
        }
    }
    
    // Map from data to Node
    private Map<K,Node<V>> map;
    
    // header.prev = bottom of cache, header.next = top of cache
    private Node<V> header;
    
    private int capacity;
    private int size;
    
    LRUCache(int c) throws Exception {
        if(c <= 0) {
            throw new Exception("Invalid cache size.");
        }
        capacity = c;
        header = new Node<V>(null);
        header.next = header;
        header.prev = header;
    }
    
    private boolean isFull() {
        return map.size() == capacity;
    }
    
    private Node<V> getNode(K key) {
        return map.get(key);
    }

    public void add(K k, V v) {
        Node<V> node = getNode(k);
        if(node == null) {
            // Create new node
            node = new Node<V>(v);
        } else {
            // Remove the node from wherever it is
            remove(node);
        }
        if(isFull()) {
            remove(header.prev);
        }
    }
    
    private void addBefore(Node<V> node, Node<V> nextNode) {
        node.prev = nextNode.prev;
        node.next = nextNode;
        nextNode.prev = node;
        node.prev.next = node;
    }
    
    private void remove(Node<V> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }
    
    public int size() {
        return size;
    }
    // get(
    
}
