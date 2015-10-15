package layer.replica;

import layer.replica.message.ReplyMessage;
import layer.replica.message.RequestMessage;

import java.net.InetSocketAddress;

public class DirectedReplicaSender implements DirectedSender {
    private final ReplicaSender sender;
    private final InetSocketAddress address;
    private final ReplicaSender.DispatchType dispatchType;

    public DirectedReplicaSender(ReplicaSender sender, InetSocketAddress address, ReplicaSender.DispatchType dispatchType) {
        this.sender = sender;
        this.address = address;
        this.dispatchType = dispatchType;
    }

    public ReplyMessage send(RequestMessage message) throws SendingException {
        return sender.send(address, message, dispatchType);
    }
}
