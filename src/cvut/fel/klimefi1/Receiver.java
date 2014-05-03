/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cvut.fel.klimefi1;

import cvut.fel.klimefi1.serverMessages.Message;
import cvut.fel.klimefi1.interfaces.MessageObservable;
import cvut.fel.klimefi1.interfaces.MessageObserver;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Receiver class
 * 
 * Receives messages from the server and creates corresponding messages
 * Follows factory pattern
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class Receiver implements Runnable, MessageObservable {

    /**
     * Server input scanner
     */
    private final Scanner sc;
    
    /**
     * Message factory
     */
    private final MessageFactory messageFactory;
    
    /**
     * Set containing registered observers
     */
    private final Set<MessageObserver> observers;
    
    /**
     * Constructor
     * @param sc Server input scanner
     */
    public Receiver(Scanner sc) {
        this.sc = sc;
        this.messageFactory = new MessageFactory();
        this.observers = new HashSet<>();
    }
    
    @Override
    public void run() {
        while(true) {
            if(sc.hasNext()) {
                String type = sc.next();
                String body = sc.nextLine().trim();
                this.notifyObservers(this.messageFactory.createMessage(type, body));
                if(type.equals("GOODBYE")) {
                    ChatClient.disconnect();
                    break;
                }
            }
        }
    }

    /**
     * Registers a new observer
     * @param o 
     */
    @Override
    public void registerObserver(MessageObserver o) {
        this.observers.add(o);
    }

    /**
     * Unregisters given observer
     * @param o 
     */
    @Override
    public void unregisterObserver(MessageObserver o) {
        this.observers.remove(o);
    }

    /**
     * Notifies observers with given message
     * @param message 
     */
    @Override
    public void notifyObservers(Message message) {
        for(MessageObserver observer : this.observers) {
            observer.update(message);
        }
    }
    
}
