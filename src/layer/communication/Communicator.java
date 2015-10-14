package layer.communication;

/**
 * API at Communication (middle) layer.
 * <p>
 * Main points are these:
 * <p>
 * * Message delivery is guaranteed
 * <p>
 * * Previous one is achieved via cutting dead nodes from out subnet. Also we periodically send requests to other
 * available subnets for merging.
 * <p>
 * * If current subnet consists of a just our node, sending blocks thread until subnet expanding.
 * <p>
 * * Subnet map is known and used only by this layer
 */
public class Communicator {

    /**
     * Talks with next node.
     * <p>
     * If it becomes dead during conversation, consider it dead and repeat for new next node, and so on until success.
     *
     * @param dialog conversation description
     */
    public void talkWithNext(Dialog dialog) {
        // until success do the following:
        //     fixate next node
        //     try to perform dialog with it
        //     if fail, consider receiver to be dead
        // if no nodes in subnet exists, sleep for some time and check again
    }

    /**
     * Talks with everyone in subnet.
     *
     * @param dialog conversation description
     */
    public void talkWithEveryone(Dialog dialog) {

    }

    /**
     * Same as talkWithNext, but using TCP
     *
     * @param dialog conversation description
     */
    public void talkWithNextSafely(Dialog dialog) {

    }
}
