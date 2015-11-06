package layer.replica;

import com.sun.istack.internal.Nullable;
import layer.replica.message.Message;

public interface ReplyProtocol<RequestType extends Message<ReplyType>, ReplyType extends Message> {
    @Nullable ReplyType makeResponse(RequestType type);

}
