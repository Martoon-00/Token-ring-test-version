package layer.replica;

import layer.replica.message.ReplyMessage;
import layer.replica.message.RequestMessage;

import java.net.InetSocketAddress;

/**
 * API for Replica (lower) layer.
 */
public class ReplicaSender {
    /**
     * Simply sends layer.replica.message through UDP, waits for result during some sensible time.
     * <p>
     * Thread is blocked during method call.
     *
     * @param address receiver of layer.replica.message
     * @param message mail entry
     * @return response layer.replica.message
     * @throws SendingException when timeout exceeded
     */
    public <T extends ReplyMessage> T send(InetSocketAddress address, RequestMessage<T> message, DispatchType type) throws SendingException {

    }

    public void registerReplyProtocol(ReplyProtocol protocol) {
    }

    public enum DispatchType {
        SINGLE, // UDP
        BROADCAST, // UDP broadcast
        SAFE // TCP
    }
}
