package cvut.fel.klimefi1.interfaces;

import cvut.fel.klimefi1.serverMessages.Message;

/**
 * MessageObserver observes MessageObservable object
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public interface MessageObserver {
    
    /**
     * Updates the observer about new message
     * @param message 
     */
    void update(Message message);
    
}
