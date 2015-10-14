package layer.replica;

import message.ReplyMessage;
import message.RequestMessage;

@FunctionalInterface
public interface DirectedSender {
    /**
     * Sends message, but without opportunity to specify receiver.
     *
     * @see ReplicaSender
     */
    ReplyMessage send(RequestMessage message) throws SendingException;
}
