package prob146;

import java.util.*;

public class LRUCache {

    class CacheItem {
        int key;
        int value;
        CacheItem prev;
        CacheItem next;
    }

    CacheItem head;
    CacheItem tail;
    Map<Integer,CacheItem> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void moveToHead(CacheItem item) {
        if (item.prev != null) {
            item.prev.next = item.next;
            if (item.next != null) item.next.prev = item.prev;
        }
        if (head != null && item != head) {
            item.next = head;
            head.prev = item;
        }
        if (item == tail && item.prev != null) tail = item.prev;
        head = item;
        item.prev = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CacheItem item = map.get(key);
            moveToHead(item);
            return item.value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size()+1 > capacity) {
            CacheItem item = tail;
            if (item.prev != null) {
                item.prev.next = null;
                tail = item.prev;
            }
            map.remove(item.key);
        }
        if (map.containsKey(key)) {
            CacheItem item = map.get(key);
            item.value = value;
            moveToHead(item);
        }
        else {
            CacheItem item = new CacheItem();
            item.key = key;
            item.value = value;
            moveToHead(item);
            map.put(key,item);
            if (map.size() == 1) tail = item;
        }
    }
}