package com.example.design.licious.service.impl;

import com.example.interview.model.Node;
import com.example.interview.service.ICache;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Cache implements ICache {
    private int capacity;
    private Map<Integer, Node> cacheMap;
    private Node start;
    private Node end;

    public Cache() {
    }

    public Cache(int capacity, Map<Integer, Node> cacheMap, Node start, Node end) {
        this.capacity = capacity;
        this.cacheMap = cacheMap;
        this.start = start;
        this.end = end;
        initialise();
    }

    void initialise(){
        this.start.next = end;
        this.end.prev = start;
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<Integer, Node> getCacheMap() {
        return cacheMap;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCacheMap(Map<Integer, Node> cacheMap) {
        this.cacheMap = cacheMap;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    @Override
    public int get(int key){
        Node node = cacheMap.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        log.info("get node : " + node.toString());
        return node.value;
    }

    @Override
    public void put(int key, int value){
        Node node = cacheMap.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            cacheMap.put(key, node);
            addNode(node);

            if(cacheMap.size() > capacity){
                node = end.prev;
                removeNode(node);
                cacheMap.remove(node.key);
            }
        }
    }

    private void addNode(Node node){
        node.prev = start;
        node.next = start.next;
        start.next.prev = node;
        start.next= node;
        log.info("add node : " + node.toString());
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

}
