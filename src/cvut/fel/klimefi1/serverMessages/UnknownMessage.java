package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;

/**
 * Unknown message represents unrecognized response from the server
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class UnknownMessage extends Message {
    
    private final String text;

    /**
     * Constructor
     * 
     * @param body
     */
    public UnknownMessage(String body) {
        super();
        this.text = "Server responded with an uknown message";
    }

    public String getText() {
        return text;
    }
    
    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }
    
}
