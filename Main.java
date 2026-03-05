public class Main {

    public static void main(String[] args) {

        HashRing ring = new HashRing();

        Node nodeA = new Node("NodeA");
        Node nodeB = new Node("NodeB");
        Node nodeC = new Node("NodeC");

        ring.addNode(nodeA);
        ring.addNode(nodeB);
        ring.addNode(nodeC);

        Client client = new Client(ring);

        // Insert experimental data
        client.put("user:101","Alice");
        client.put("user:102","Bob");
        client.put("user:103","Charlie");
        client.put("user:104","Diana");
        client.put("user:105","Eve");
        client.put("user:106","Frank");

        System.out.println("\n--- Fetch data ---");

        client.get("user:101");
        client.get("user:101");

        System.out.println("\n--- Node Join ---");

        Node nodeD = new Node("NodeD");
        ring.addNode(nodeD);

        client.get("user:102");

        System.out.println("\n--- Node Failure ---");

        ring.removeNode(nodeB);

        client.get("user:101");

    }
}
