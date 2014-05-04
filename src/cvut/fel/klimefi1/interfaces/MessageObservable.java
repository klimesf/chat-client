package cvut.fel.klimefi1.interfaces;

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
     * @param o 
     */
    void registerObserver(MessageObserver o);
    
    /**
     * Unregisters given observer. If the given observer is not registered,
     * does nothing.
     * 
     * @param o 
     */
    void unregisterObserver(MessageObserver o);
    
    /**
     * Notifies all registered observers about given message.
     * 
     * @param message 
     */
    void notifyObservers(Message message);
    
}
