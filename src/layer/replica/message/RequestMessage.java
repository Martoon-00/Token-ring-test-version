package layer.replica.message;

/**
 *
 * @param <ReplyType> type of reply message. It may be abstract
 */
public abstract class RequestMessage<ReplyType extends ReplyMessage> extends Message {
    public RequestMessage() {
        super(new MessageIdentifier());
    }
}
