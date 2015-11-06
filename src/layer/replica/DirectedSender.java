package layer.replica;

@FunctionalInterface
public interface DirectedSender {
    /**
     * Sends message, but without opportunity to specify receiver.
     * This interface is not complete
     *
     * @see ReplicaSender
     */
    ReplyMessage send(RequestMessage message) throws SendingException;
}
