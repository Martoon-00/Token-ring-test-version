package layer.communication;

import layer.replica.DirectedSender;
import layer.replica.SendingException;

@FunctionalInterface
public interface Dialog {
    /**
     * Attempts to send several messages consequently.
     *
     * @param sender should be used for sending messages. You have no information about receiver address, it's defined
     *               outside
     * @throws SendingException if some of layer.replica.message sending fails
     */
    void talk(DirectedSender sender) throws SendingException;
}
