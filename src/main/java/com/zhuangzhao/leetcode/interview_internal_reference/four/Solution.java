package com.zhuangzhao.leetcode.interview_internal_reference.four;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-10-05 19:33
 */
public class Solution {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put("1", "1");
        System.out.println("3" + " --> " + lruCache.get("3"));
        System.out.println("2" + " --> " + lruCache.get("2"));
        System.out.println("1" + " --> " + lruCache.get("1"));
        lruCache.put("2", "2");
        System.out.println("3" + " --> " + lruCache.get("3"));
        System.out.println("2" + " --> " + lruCache.get("2"));
        System.out.println("1" + " --> " + lruCache.get("1"));
        lruCache.put("3", "3");
        System.out.println("3" + " --> " + lruCache.get("3"));
        System.out.println("2" + " --> " + lruCache.get("2"));
        System.out.println("1" + " --> " + lruCache.get("1"));
        lruCache.put("1", "1");
        System.out.println("3" + " --> " + lruCache.get("3"));
        System.out.println("2" + " --> " + lruCache.get("2"));
        System.out.println("1" + " --> " + lruCache.get("1"));
    }
}


class LRUCache {

    public static final int DEFAULT_CAPACITY = 2;

    public static final String DEFAULT_VALUE = "-1";

    public int capaccity;

    private Map<String, Node> cacheMap;

    private Node head;

    private Node tail;

    public LRUCache() {
        capaccity = DEFAULT_CAPACITY;
        cacheMap = new HashMap<>(capaccity);
        head = null;
    }

    public LRUCache(int capaccity) {
        this.capaccity = capaccity;
        cacheMap = new HashMap<>(capaccity);
        head = null;
    }


    public String get(String key) {
        Node node = cacheMap.get(key);
        if (node != null) {
            return node.val;
        } else {
            return DEFAULT_VALUE;
        }
    }

    public void put(String key, String value) {
        Node node = cacheMap.get(key);
        if (node != null) {
            node.val = value;
            this.useNode(node);
        } else if (cacheMap.size() < capaccity) {
            node = new Node(key, value);
            this.insertNode(node);
        } else {
            this.removeTail();
            node = new Node(key, value);
            this.insertNode(node);
        }
        cacheMap.put(key, node);
    }

    private void removeTail() {
        if (tail == null) {
            return;
        } else {
            cacheMap.remove(tail.key);
            if (tail == head) {
                head = null;
                tail = null;
            } else {
                Node node = tail;
                tail = tail.prve;
                tail.next = null;
                release(node);
            }
        }
    }

    private void release(Node node) {
        node.prve = null;
        node.next = null;
    }

    private void insertNode(Node node) {
        if (head == null) {
            node.prve = null;
            node.next = null;
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prve = node;
            head = node;
        }
    }

    private void useNode(Node node) {
        if (node == null || node == head) {
            return;
        }
        if (node == tail) {
            tail = node.prve;
        }
        node.prve.next = node.next;
        node.prve = null;
        node.next = head;
        head.prve = node;
        head = node;
    }
}


class Node {
    String key;
    String val;
    Node prve;
    Node next;

    public Node(String key, String val) {
        this.key = key;
        this.val = val;
    }
}