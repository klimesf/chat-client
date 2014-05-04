package cvut.fel.klimefi1.logger;

import cvut.fel.klimefi1.serverMessages.ChatMessage;
import cvut.fel.klimefi1.serverMessages.TextOnlyMessage;

/**
 * Console logger
 * Observes Receiver and then prints out given message to the console
 * @author Filip Klimes
 */
public class ConsoleLogger implements MessageVisitor {

    /**
     * Visits message and prints out its formatted output
     * 
     * @param message 
     */
    @Override
    public void visit(ChatMessage message) {
        // Build the string
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(message.getRoom()).append("] ");
        sb.append(message.getSender()).append(": ");
        sb.append(message.getText().trim());
        // Prints out the string
        if(!sb.toString().equals("")) {
            System.out.println(sb.toString());
        }
    }
    
    /**
     * Visits text only message and prints it out. If the message is null,
     * does nothing.
     * @param message 
     */
    @Override
    public void visit(TextOnlyMessage message) {
        if(message.getText() != null) {
            System.out.println(message.getText());
        }
    }
    
}
