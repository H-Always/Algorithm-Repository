import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @ClassName: LUFCacheLinkList
 * @Description: LFU缓存
 * @Author: 余霜
 * @Date: 2020/04/09 09:36
 * @Version: V1.0
 **/

//这题一开始就想到的LinkList+Hash，应该快很多，实际也是
// 首先开两个Map，一个存键值对，就是要缓存的元素，另一个存频率
public class LUFCacheLinkList {

    Map<Integer, Node> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    int size; // 当前长度
    int capacity;// 最大长度
    int min; // 存储当前最小频次

    //初始化，HashMap的参数为加载因子，通俗的说就是容器大小
    // 对HashMap不太了解的同学阔以看看源码或者网上的讲解，会很有帮助的
    public LUFCacheLinkList(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    //get，由于是Hash，复杂度O(1)
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    // 先判断有没有，没有就添加，有就更新，
    // 这里的频率相同就不用判断了，结构自带
    // HashMap用的数组+链表+红黑树，这里的数组是哈希桶，效率很高
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

