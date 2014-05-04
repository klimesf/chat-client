package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;

/**
 * Error message represents message about an error
 * 
 * @author Filip Klimes <klimefi1@fel.cvut>
 */
public class ErrorMessage extends Message {

    private final String text;
    
    /**
     * Constructor
     * 
     * @param body body of the message 
     */
    public ErrorMessage(String body) {
        super();
        this.text = body.trim();
    }

    public String getText() {
        return text;
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }
    
}
