package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;

/**
 * TextOnlyMessage represents a message with plain text.
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
abstract public class TextOnlyMessage extends Message {
    
    /**
     * Text of the message.
     */
    protected String text;

    /**
     * Constructor.
     */
    public TextOnlyMessage() {
        super();
    }

    /**
     * Returns text of the message.
     * 
     * @return 
     */
    public String getText() {
        return text;
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
