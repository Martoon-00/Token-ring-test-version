package layer.replica.message;

public abstract class RequestMessage<ReplyType extends ReplyMessage> extends Message {
    public RequestMessage() {
        super(new MessageIdentifier());
    }
}
