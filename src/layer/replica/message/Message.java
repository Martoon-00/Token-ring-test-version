package layer.replica.message;

import java.io.Serializable;

public class Message implements Serializable {
    protected final MessageIdentifier id;

    public Message(MessageIdentifier id) {
        this.id = id;
    }
}
