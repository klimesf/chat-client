package cvut.fel.klimefi1.logger;

import cvut.fel.klimefi1.serverMessages.ChatMessage;
import cvut.fel.klimefi1.serverMessages.DisconnectedMessage;
import cvut.fel.klimefi1.serverMessages.ErrorMessage;
import cvut.fel.klimefi1.serverMessages.ListMessage;
import cvut.fel.klimefi1.serverMessages.RecieveMessage;
import cvut.fel.klimefi1.serverMessages.StatusMessage;
import cvut.fel.klimefi1.serverMessages.UnknownMessage;

/**
 * MessageVisitor visits Messages and retrieves information
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public interface MessageVisitor {
    
    /**
     * Visits given message
     * @param message 
     */
    void visit(ChatMessage message);
    
    /**
     * Visits given message
     * @param message 
     */
    void visit(DisconnectedMessage message);
    
    /**
     * Visits given message
     * @param message 
     */
    void visit(ErrorMessage message);
    
    /**
     * Visits given message
     * @param message 
     */
    void visit(ListMessage message);
    
    /**
     * Visits given message
     * @param message 
     */
    void visit(RecieveMessage message);
    
    /**
     * Visits given message
     * @param message 
     */
    void visit(StatusMessage message);
    
    /**
     * Visits given message
     * @param message 
     */
    void visit(UnknownMessage message);
    
}
