package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;

/**
 * Disconnected message represents message about disconnecting from the server
 * 
 * @author Filip Klimes
 */
public class DisconnectedMessage extends Message {

    private final String text;
    
    /**
     * Constructor
     * 
     * @param body 
     */
    public DisconnectedMessage(String body) {
        super();
        this.text = "Disconnected";
    }

    public String getText() {
        return text;
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }
    
}
