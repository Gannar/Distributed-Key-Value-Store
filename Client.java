public class Client {

    private HashRing ring;

    public Client(HashRing ring) {
        this.ring = ring;
    }

    public void put(String key, String value) {

        Node node = ring.getNode(key);
        node.put(key,value);
    }

    public void get(String key) {

        Node node = ring.getNode(key);
        String value = node.get(key);

        System.out.println("Result: "+value);
    }
}
