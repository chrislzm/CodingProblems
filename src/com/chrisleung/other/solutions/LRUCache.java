package com.chrisleung.other.solutions;

import java.util.HashMap;
import java.util.Map;

// Return the object if it's in the cache, otherwise null
// Key-value mapping

public class LRUCache<K,V> {
    
    private class Node<T1,T2> {
        Node<T1,T2> next;
        Node<T1,T2> prev;
        T1 key;
        T2 value;
        Node(T1 k, T2 v) {
            key = k;
            value = v;
        }
    }
    
    // Map from data to Node
    private Map<K,Node<K,V>> map = new HashMap<>();
    
    // header.prev = bottom of cache, header.next = top of cache
    private Node<K,V> header;
    
    private int capacity;
    private int size;
    
    LRUCache(int c) throws Exception {
        if(c <= 0) {
            throw new Exception("Invalid cache size.");
        }
        capacity = c;
        header = new Node<K,V>(null,null);
        header.next = header;
        header.prev = header;
    }
    
    private boolean isFull() {
        return size() == capacity;
    }
    
    private Node<K,V> getNode(K key) {
        return map.get(key);
    }

    public void add(K k, V v) {
        Node<K,V> node = getNode(k);
        if(node == null) {
            // Create new node
            node = new Node<K,V>(k,v);
            map.put(k,node);
        } else {
            // Remove the node from wherever it is
            remove(node);
        }
        if(isFull()) {
            // Remove last item in cache
            remove(header.prev);
        }
        addBefore(node,header.next);
    }
    
    private void addBefore(Node<K,V> node, Node<K,V> nextNode) {
        node.prev = nextNode.prev;
        node.next = nextNode;
        nextNode.prev = node;
        node.prev.next = node;
    }
    
    private void remove(Node<K,V> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        map.remove(node.key);
    }
    
    public int size() {
        return map.size();
    }

    public V get(K key) {
        Node<K,V> n = map.get(key);
        if(n == null) {
            return null;
        }
        // Move node to front of cache
        remove(n);
        addBefore(n,header.next);
        return n.value;
    }
    
    public static void main(String[] args) throws Exception {
        LRUCache<Integer,Integer> cache = new LRUCache<>(3);
        cache.add(1, 100);
        cache.add(2, 200);
        cache.add(3, 300);
        cache.add(4, 400);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
