package layer.replica;

import message.ReplyMessage;
import message.RequestMessage;

import java.net.InetSocketAddress;

/**
 * API for Replica (lower) layer.
 */
public class ReplicaSender {
    /**
     * Simply sends message through UDP, waits for result during some sensible time.
     * <p>
     * Thread is blocked during method call.
     *
     * @param address receiver of message
     * @param message mail entry
     * @return response message
     * @throws SendingException when timeout exceeded
     */
    public ReplyMessage send(InetSocketAddress address, RequestMessage message, DispatchType type) throws SendingException {

    }


    public enum DispatchType {
        SINGLE, // UDP
        BROADCAST, // UDP broadcast
        SAFE // TCP
    }
}
