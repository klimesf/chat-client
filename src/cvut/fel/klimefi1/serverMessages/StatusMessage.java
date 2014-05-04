package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;

/**
 * Status message represents received status of previous command
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class StatusMessage extends Message {

    private final String text;
    
    /**
     * Constructor
     * 
     * @param body 
     */
    public StatusMessage(String body) {
        super();
        if(!body.equals("OK")) {
            this.text = body.trim();
        } else {
            this.text = null;
        }
    }

    public String getText() {
        return text;
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }
    
}
