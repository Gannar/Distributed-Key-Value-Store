import java.util.*;

public class HashRing {

    private TreeMap<Integer,Node> ring = new TreeMap<>();

    public void addNode(Node node) {

        int hash = HashUtil.hash(node.getId());
        ring.put(hash,node);

        System.out.println("Node added: "+node.getId());
    }

    public void removeNode(Node node) {

        int hash = HashUtil.hash(node.getId());
        ring.remove(hash);

        System.out.println("Node removed: "+node.getId());
    }

    public Node getNode(String key) {

        int hash = HashUtil.hash(key);

        if(!ring.containsKey(hash)) {

            SortedMap<Integer,Node> tail = ring.tailMap(hash);

            hash = tail.isEmpty() ? ring.firstKey() : tail.firstKey();
        }

        return ring.get(hash);
    }

}
