package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;

/**
 * Disconnected message represents message about disconnecting from the server
 * 
 * @author Filip Klimes
 */
public class DisconnectedMessage extends TextOnlyMessage {
    
    /**
     * Constructor
     * 
     * @param body 
     */
    public DisconnectedMessage(String body) {
        super();
        this.text = "Disconnected";
    }

    /**
     * Accepts visitor.
     * @param visitor 
     */
    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }
    
}
