package cvut.fel.klimefi1.interfaces;

import cvut.fel.klimefi1.logger.MessageVisitor;
import cvut.fel.klimefi1.serverMessages.*;

/**
 * Message observable object holds observers and notifies them
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public interface MessageObservable {
    
    /**
     * Registers given observer.
     * 
     * @param v
     */
    void registerVisitor(MessageVisitor v);
    
    /**
     * Unregisters given observer. If the given observer is not registered,
     * does nothing.
     * 
     * @param v 
     */
    void unregisterVisitor(MessageVisitor v);
    
    /**
     * Notifies all registered visitors about given message.
     * 
     * @param message 
     */
    void notifyVisitors(Message message);
    
}
