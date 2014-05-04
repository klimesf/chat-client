package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;

/**
 * Receive message represents confirmation about sent message from the client
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class RecieveMessage extends Message {

    private final String text;
    
    /**
     * Constructor
     * 
     * @param body 
     */
    public RecieveMessage(String body) {
        super();
        this.text = "Message sent";
    }

    public String getText() {
        return text;
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }
    
}
