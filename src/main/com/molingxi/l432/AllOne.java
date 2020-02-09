package main.com.molingxi.l432;


import java.util.HashMap;
import java.util.Map;

class AllOne {

    class HeadNode {
        public HeadNode left, right;
        public int count;
        public DataNode firstData;
        public HeadNode(int _count) {
            count = _count;
        }
    }

    class DataNode {
        public HeadNode head;
        public DataNode left, right;
        public String value ;
        public DataNode(String _val ) {
            value = _val;
        }
    }

    Map<String, DataNode> store = new HashMap<>();

    HeadNode head, tail;


    /** Initialize your data structure here. */
    public AllOne() {
        head = new HeadNode(Integer.MAX_VALUE);
        tail = new HeadNode(0);
        head.right = tail;
        tail.left = head;

    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        DataNode dataNode = store.computeIfAbsent(key, (k) -> new DataNode(key));
        if (dataNode.head == null) {
            if (tail.left.count == 1) {
                attachDataNode(tail.left, dataNode);
            } else {
                HeadNode newHead = new HeadNode(1);
                insertHead(tail.left, newHead);
                attachDataNode(newHead, dataNode);
            }
        } else {
            HeadNode curHead = dataNode.head;
            if (curHead.left.count == curHead.count + 1) {
                curHead = curHead.left;
            } else {
                curHead = new HeadNode(curHead.count + 1);
                insertHead(dataNode.head.left, curHead);
            }

            detachDataNode(dataNode);
            attachDataNode(curHead, dataNode);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        DataNode dataNode = store.get(key);
        if (dataNode == null) {
            return;
        }


        if (dataNode.head.count == 1) {
            store.remove(key);
            detachDataNode(dataNode);
        } else if (dataNode.head.right.count == dataNode.head.count - 1) {
            HeadNode head = dataNode.head.right;
            detachDataNode(dataNode);
            attachDataNode(head, dataNode);
        } else {
            HeadNode head = new HeadNode(dataNode.head.count - 1);
            insertHead(dataNode.head, head);
            detachDataNode(dataNode);
            attachDataNode(head, dataNode);
        }

    }

    private void insertHead(HeadNode left, HeadNode newHead){
        newHead.left = left;
        newHead.right = left.right;
        newHead.left.right = newHead;
        newHead.right.left = newHead;
    }

    private void attachDataNode(HeadNode head, DataNode data) {
        data.head = head;
        data.right = head.firstData;
        head.firstData = data;
        if (data.right != null) {
            data.right.left = data;
        }
    }

    private void detachDataNode(DataNode dataNode) {
        if (dataNode.right == null && dataNode.left == null) {
            dataNode.head.left.right = dataNode.head.right;
            dataNode.head.right.left = dataNode.head.left;
            dataNode.head = null;
        } else {
            if (dataNode.left != null) {

                dataNode.left.right = dataNode.right;
            } else {
                dataNode.head.firstData = dataNode.right;
            }

            if (dataNode.right != null) {
                dataNode.right.left = dataNode.left;
            }

            dataNode.head = null;
            dataNode.left = null;
            dataNode.right = null;
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head.right == tail) {
            return "";
        } else {
            return head.right.firstData.value;
        }
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.right == tail) {
            return "";
        } else {
            return tail.left.firstData.value;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */