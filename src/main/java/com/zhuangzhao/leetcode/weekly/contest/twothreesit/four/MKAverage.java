package com.zhuangzhao.leetcode.weekly.contest.twothreesit.four;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class MKAverage {

    Queue<Integer> queue;


    Queue<Integer> queue1;

    int capacity;

    int count;

    public MKAverage(int m, int k) {
        this.queue = new LinkedList<>();
        this.queue1 = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        this.capacity = m;
        this.count = k;
    }
    
    public void addElement(int num) {
        if (queue.size() == capacity) {
            Integer integer = queue.poll();
            queue1.remove(integer);
        }
        queue.add(num);
        queue1.add(num);
    }
    
    public int calculateMKAverage() {
        if (queue1.size() < capacity) {
            return -1;
        }
        List<Integer> list = new ArrayList<>(queue1);
        double total = 0;
        for (int i = count; i < capacity - count; i++) {
            total += list.get(i);
        }
        return (int) total / (capacity - 2 * count);
    }


    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(17612);        // 当前元素为 [3]
        obj.addElement(74607);        // 当前元素为 [3,1]
        System.out.println(obj.calculateMKAverage()); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(8272);       // 当前元素为 [3,1,10]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        obj.addElement(33433);        // 当前元素为 [3,1,10,5]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [5,5,5]
        obj.addElement(15456);        // 当前元素为 [3,1,10,5,5]
        obj.addElement(64938);        // 当前元素为 [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [5,5,5]
        obj.addElement(99741);        // 当前元素为 [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [5,5,5]


    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */