package com.lyx.datastruct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionFindSet<V> {

    public Map<V, Element<V>> elementMap;

    // 元素 -> 父元素
    public Map<Element<V>, Element<V>> fatherMap;

    // 集合代表元素 -> 集合大小
    public Map<Element<V>, Integer> sizeMap;

    public UnionFindSet(List<V> list) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V value : list) {
            Element<V> element = new Element<>(value);
            elementMap.put(value, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }
    }

    public Element<V> findHead(V value) {
        return findHead(elementMap.get(value));
    }

    private Element<V> findHead(Element<V> element) {
        Stack<Element<V>> path = new Stack<>();
        while (element != fatherMap.get(element)) {
            path.push(element);
            element = fatherMap.get(element);
        }
        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), element);
        }
        return element;
    }

    public boolean isSameSet(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }

    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> headA = findHead(elementMap.get(a));
            Element<V> headB = findHead(elementMap.get(b));
            if (headA != headB) {
                Element<V> bigger = sizeMap.get(headA) > sizeMap.get(headB) ? headA : headB;
                Element<V> smaller = bigger == headA ? headB : headA;
                fatherMap.put(smaller, bigger);
                sizeMap.put(bigger, sizeMap.get(headA) + sizeMap.get(headB));
                sizeMap.remove(smaller);
            }
        }
    }

    public int size(V value) {
        return sizeMap.get(findHead(value));
    }


    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }
}
