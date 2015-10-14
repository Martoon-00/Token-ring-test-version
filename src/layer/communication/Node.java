package layer.communication;

import java.net.InetAddress;

public class Node {
    private final InetAddress address;

    public Node(InetAddress address) {
        this.address = address;
    }

    /**
     * Any node set should be ordered set. In some algorithms, to reach a consensus about leader node, we would use this
     * method to take the 'greatest' (and so unique in network by common consent) node.
     * <p>
     * Invariant: n1.getUniqueValue().compareTo(n2.getUniqueValue()) == 0 is equivalent to that n1 and n2 refer to the
     * same node
     */
    public UniqueNodeValue getUniqueValue() {
        // may just return MAC here
        // but node with highest mac could be unstable, leading to often failures
    }
}
