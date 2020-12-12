package com.yc.top_medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {//常数时间插入、删除和获取随机元素

    private HashMap<Integer, Integer> map;//key为传入的val值,val为在list中对应的索引
    private ArrayList<Integer> list;//存储传入的val值
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {//⭐⭐⭐⭐
        if (!map.containsKey(val)) return false;
        int lastVal = list.get(list.size() - 1);//获取list最后一个值
        int index = map.get(val);//根据val值在map中获取对应的list索引
        list.set(index, lastVal);//把值替换为lastVal
        map.put(lastVal, index);//更新map中val的索引
        list.remove(list.size() - 1);//移除最后一个元素
        map.remove(val);//移除map中的val键值对
        return true;
    }

    public int getRandom() {
        //虽然哈希表提供常数时间的插入和删除
        //但map不能随机获取,于是用list来存放val,map存放索引
        return list.get(random.nextInt(list.size()));
    }
}
