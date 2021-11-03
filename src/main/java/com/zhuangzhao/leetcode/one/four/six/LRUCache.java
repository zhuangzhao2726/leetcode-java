package com.zhuangzhao.leetcode.one.four.six;


import java.util.HashMap;

import java.util.Map;

class LRUCache {

    int capacity;

    Map<Integer, Integer> map;

    Node head;

    Node tail;

    private static final Integer DEFAULT_VALUE = -1;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        Integer value = map.getOrDefault(key, DEFAULT_VALUE);
        if (value != DEFAULT_VALUE) {
            this.useNode(key);
        }
        return value;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            this.useNode(key);
        } else if (map.size() < this.capacity) {
            map.put(key, value);
            this.insertNode(key);
        } else {
            map.remove(tail.key);
            this.removeTail();
            map.put(key, value);
            this.insertNode(key);
        }

    }

    private void insertNode(int key) {
        Node node = Node.createNewNode(null, head, key);
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    private void removeTail() {
        if (head == tail) {
            head = null;
            tail = null;
        } else if (tail != null) {
            tail.prve.next = null;
            tail = tail.prve;
        }
    }

    private void useNode(int key) {
        Node p = head;
        while (p != null && p.key != key) {
            p = p.next;
        }
        if (p == head) {
            return;
        } else if (p == tail) {
            tail = p.prve;
            p.prve.next = null;
            p.prve = null;
            p.next = head;
            head.prve = p;
            head = p;
        } else {
            p.prve.next = p.next;
            p.next.prve = p.prve;
            p.next = head;
            head.prve = p;
            head = p;
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
    }
}

class Node {
    Node prve;
    Node next;
    Integer key;

    public Node(Integer key) {
        this.key = key;
    }

    public static Node createNewNode(Node prve, Node next, Integer key) {
        Node node = new Node(key);
        node.prve = prve;
        node.next = next;
        if (prve != null) {
            prve.next = node;
        }
        if (next != null) {
            next.prve = node;
        }
        return node;
    }
}