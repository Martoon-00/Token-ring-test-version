package layer.replica;

import layer.replica.message.Cancellation;
import layer.replica.message.ReplyMessage;
import layer.replica.message.RequestMessage;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.function.Consumer;

/**
 * API for Replica (lower) layer.
 */
public class ReplicaSender {
    /**
     * Simply sends message, waits for result during some sensible time.
     * <p>
     * Current thread is blocked during method call.
     *
     * @param address receiver of message
     * @param message mail entry
     * @param type    way of sending a message: TCP, single UPD...
     * @param timeout timeout in milliseconds
     * @param <T>     response message type
     * @return response message
     * @throws SendingException when timeout exceeded
     */
    public <T extends ReplyMessage> T sendAndWait(InetSocketAddress address, RequestMessage<T> message, DispatchType type, int timeout) throws SendingException {
        // IMPLEMENTATION NOTES
        // this can be easily implemented via <tt>send</tt>

    }

    /**
     * Sends a message.
     * <p>
     * Current thread is NOT blocked by this method call.
     * But no two response-actions (onReceive or onFail on any request) or response protocols will be executed at same time,
     * so you can write not thread-safe code inside them.
     * <p>
     * <p>
     * This gets being very similar to automaton programming :)
     *
     * @param address   receiver of message
     * @param message   mail entry
     * @param type      way of sending a message: TCP, single UPD...
     * @param timeout   timeout in milliseconds
     * @param onReceive an action to invoke when got an answer.
     * @param onFail    an action to invoke when timeout exceeded.
     * @param <T>       response message type
     */
    public <T extends ReplyMessage> void send(InetSocketAddress address, RequestMessage<T> message, DispatchType type, int timeout, Consumer<T> onReceive, Runnable onFail) {
        // IMPLEMENTATION NOTES
        // this may greatly help:
        // https://github.com/google/guava/wiki/ListenableFutureExplained

    }

    /**
     * Sends a broadcast, waits for timeout to collect answers.
     * <p>
     * Node will NOT receive its own request
     * (i.e. response protocols of this sender will ignore any broadcast from itself (or from sender with same address?)).
     *
     * @param message mail entry
     * @param timeout timeout in milliseconds
     * @param <T>     responses type
     * @return list of replies
     */
    public <T extends ReplyMessage> List<T> broadcastAndWait(RequestMessage<T> message, int timeout) {

    }

    /**
     * Sends a broadcast.
     * <p>
     * Node will NOT receive its own request.
     * (i.e. response protocols of this sender will ignore any broadcast from itself (or from sender with same address?)).
     * <p>
     * Current thread is NOT blocked by this method call.
     * But no two response-actions (onReceive or onFail on any request) or response protocols will be executed at same time,
     * so you can write not thread-safe code inside them.
     *
     * @param message   mail entry
     * @param timeout   timeout in milliseconds
     * @param onReceive is executed when get a response
     * @param onFail    if no answers received
     * @param <T>       response type
     */
    public <T extends ReplyMessage> void broadcast(RequestMessage<T> message, int timeout, Consumer<T> onReceive, Runnable onFail) {

    }

    /**
     * Determines behaviour on receiving request-message of specified type.
     * <p>
     * No any two response protocols or response-actions will be executed at the same time.
     * <p>
     * Response protocol managing is impossible when not in frozen state. (--optional 1--)
     *
     * @param protocol way on response on specified request-message
     * @return function to unregister from this protocol.
     * If that function is called when this sender is not in frozen state, it throws IllegalStateException (--optional 1--)
     * @throws IllegalStateException if not in frozen state (--optional 1--)
     */
    public <Q extends RequestMessage<A>, A extends ReplyMessage> Cancellation registerReplyProtocol(ReplyProtocol<Q, A> protocol) {

    }

    /**
     * Freezes request-messages receiver.
     * <p>
     * In frozen state no any response protocol is activated, all received request-messages are stored and not processed
     * until unfreezing. So you can safely change response protocols without scaring of missing any request.
     * Response protocols managing is only available in this state. (--optional 1--)
     * <p>
     * Call of this method also destroys all registered response protocols and response-actions of send- and broadcastAndWait
     * methods (--optional 2--)
     */
    public void freeze() {

    }

    /**
     * Unfreezes request-messages receiver. Messages received in frozen state begin to be processed.
     */
    public void unfreeze() {

    }


    public enum DispatchType {
        PLAIN, // UDP
        SAFE, // TCP
        LOOPBACK // don't laugh, it may be really essential (could be implemented without actual sending, could not)
    }

}
