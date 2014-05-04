package cvut.fel.klimefi1;

import cvut.fel.klimefi1.interfaces.MessageObservable;
import cvut.fel.klimefi1.logger.MessageVisitor;
import cvut.fel.klimefi1.serverMessages.Message;
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
    private final Set<MessageVisitor> visitors;
    
    /**
     * Thread in which the Receiver runs.
     */
    private final Thread thread;
    
    /**
     * Constructor
     * @param sc Server input scanner
     */
    public Receiver(Scanner sc) {
        this.sc = sc;
        this.messageFactory = new MessageFactory();
        this.visitors = new HashSet<>();
        this.thread = new Thread(this);
    }
    
    /**
     * Starts the receiver in it's own thread
     */
    public void start() {
        this.thread.start();
    }
    
    /**
     * Runs the receiver
     */
    @Override
    public void run() {
        while(sc.hasNext() && !this.thread.isInterrupted()) {
            String type = sc.next();
            String body = sc.nextLine().trim();
            this.notifyVisitors(this.messageFactory.createMessage(type, body));

            if(type.equals("GOODBYE")) {
                break;
            }
        }
    }

    /**
     * Registers a new visitor.
     * @param v 
     */
    @Override
    public void registerVisitor(MessageVisitor v) {
        this.visitors.add(v);
    }

    /**
     * Unregisters given visitor.
     * @param v 
     */
    @Override
    public void unregisterVisitor(MessageVisitor v) {
        this.visitors.remove(v);
    }

    /**
     * Notifies observers with given message
     * @param message 
     */
    @Override
    public void notifyVisitors(Message message) {
        for(MessageVisitor visitor : this.visitors) {
            message.accept(visitor);
        }
    }
    
    /**
     * Stops the receiver
     */
    public void stop() {
        this.sc.close();
        this.thread.interrupt();
    }
    
    /**
     * Returns thread in which the receiver is running.
     * @return 
     */
    public Thread getThread() {
        return this.thread;
    }
    
}
