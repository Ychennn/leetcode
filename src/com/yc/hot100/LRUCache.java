package com.yc.hot100;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {//LRU缓存机制⭐⭐⭐⭐⭐⭐

    class DLinkedNode {//双向链表节点
        int key, val;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size;
    private int capacity;
    private DLinkedNode head, tail;//靠近链表头部代表最近使用,尾部则反之
    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {//初始化LRUCache
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {//获取数据
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //如果key存在,先通过哈希表定位,再移到头部
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {//插入数据
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //如果key不存在,创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, val);
            //添加进哈希表
            cache.put(key, newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                //如果超出容量,删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            //如果key存在,先通过哈希表定位,再修改 value,并移到头部
            node.val = val;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {//将一个节点移至头部(head的后面)
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {//删除节点(更改prev,next)
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {//将一个节点移至头部
        removeNode(node);//首先删除该节点(更改prev,next)
        addToHead(node);//将removeNode的返回节点移至头部
    }

    private DLinkedNode removeTail() {//删除尾部节点(tail前面的一个节点),并将该节点返回
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
