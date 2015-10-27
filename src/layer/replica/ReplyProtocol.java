package layer.replica;

import com.sun.istack.internal.Nullable;
import layer.replica.message.ReplyMessage;
import layer.replica.message.RequestMessage;

public interface ReplyProtocol<RequestType extends RequestMessage<ReplyType>, ReplyType extends ReplyMessage> {
    @Nullable ReplyType makeResponse(RequestType type);

}
