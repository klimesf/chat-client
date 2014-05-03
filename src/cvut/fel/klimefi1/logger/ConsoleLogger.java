package cvut.fel.klimefi1.logger;

import cvut.fel.klimefi1.serverMessages.Message;
import cvut.fel.klimefi1.interfaces.MessageObserver;

/**
 * Console logger
 * Observes Receiver and then prints out given message to the console
 * @author Filip Klimes
 */
public class ConsoleLogger implements MessageObserver, MessageVisitor {

    /**
     * Gets notified about new message
     * @param message 
     */
    @Override
    public void update(Message message) {
        this.visit(message);
    }

    /**
     * Visits message and prints out its formatted output
     * @param message 
     */
    @Override
    public void visit(Message message) {
        // Build the string
        StringBuilder sb = new StringBuilder();
        if(message.getRoom() != null) {
            sb.append("[").append(message.getRoom()).append("] ");
        }
        if(message.getSender() != null) {
            sb.append(message.getSender()).append(": ");
        }
        if(message.getText() != null) {
            sb.append(message.getText().trim());
        }
        // Prints out the string
        if(!sb.toString().equals("")) {
            System.out.println(sb.toString());
        }
    }
    
}
