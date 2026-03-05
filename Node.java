import java.util.HashMap;
import java.util.Map;

public class Node {

    private String nodeId;
    private Map<String,String> storage;
    private LRUCache<String,String> cache;

    public Node(String id) {
        this.nodeId = id;
        this.storage = new HashMap<>();
        this.cache = new LRUCache<>(3);
    }

    public String getId() {
        return nodeId;
    }

    public void put(String key, String value) {

        storage.put(key,value);
        cache.put(key,value);

        System.out.println("Stored "+key+" in Node "+nodeId);
    }

    public String get(String key) {

        if(cache.containsKey(key)) {
            System.out.println("Cache hit on node "+nodeId);
            return cache.get(key);
        }

        if(storage.containsKey(key)) {
            System.out.println("Cache miss on node "+nodeId);
            String value = storage.get(key);
            cache.put(key,value);
            return value;
        }

        return null;
    }

    public Map<String,String> getAllData() {
        return storage;
    }
}
