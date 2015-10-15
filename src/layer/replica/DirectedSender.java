package layer.replica;

import layer.replica.message.ReplyMessage;
import layer.replica.message.RequestMessage;

@FunctionalInterface
public interface DirectedSender {
    /**
     * Sends layer.replica.message, but without opportunity to specify receiver.
     *
     * @see ReplicaSender
     */
    ReplyMessage send(RequestMessage message) throws SendingException;
}
