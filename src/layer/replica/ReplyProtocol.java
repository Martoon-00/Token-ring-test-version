package layer.replica;

import layer.replica.message.ReplyMessage;
import layer.replica.message.RequestMessage;

public interface ReplyProtocol<RequestType extends RequestMessage<ReplyType>, ReplyType extends ReplyMessage> {
    ReplyType makeResponse(RequestType type);

}
