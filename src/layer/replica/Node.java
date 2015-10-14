package layer.replica;

import java.net.InetAddress;

public class Node implements Comparable<Node> {
    private final InetAddress address;

    public Node(InetAddress address) {
        this.address = address;
    }

    /**
     * Any node set should be ordered set. In some algorithms, to reach a consensus about leader node, we would use this
     * method to take the 'greatest' (and so unique in network by common consent) node.
     * <p>
     * Method should never return 0.
     */
    @Override
    public int compareTo(Node o) {
        // can get MAC-addresses of nodes and compare them
    }
}
