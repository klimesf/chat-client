package cvut.fel.klimefi1.logger;

import cvut.fel.klimefi1.serverMessages.ChatMessage;
import cvut.fel.klimefi1.serverMessages.TextOnlyMessage;

/**
 * MessageVisitor visits Messages and retrieves information
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public interface MessageVisitor {
    
    /**
     * Visits given message.
     * @param message 
     */
    void visit(ChatMessage message);
    
    /**
     * Visits given message.
     * @param message 
     */
    void visit(TextOnlyMessage message);
    
}
