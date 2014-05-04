package cvut.fel.klimefi1.logger;

import cvut.fel.klimefi1.serverMessages.ChatMessage;
import cvut.fel.klimefi1.serverMessages.DisconnectedMessage;
import cvut.fel.klimefi1.serverMessages.ErrorMessage;
import cvut.fel.klimefi1.serverMessages.ListMessage;
import cvut.fel.klimefi1.serverMessages.Message;
import cvut.fel.klimefi1.serverMessages.RecieveMessage;
import cvut.fel.klimefi1.serverMessages.StatusMessage;
import cvut.fel.klimefi1.serverMessages.UnknownMessage;

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
    
    @Override
    public void visit(DisconnectedMessage message) {
        System.out.println(message.getText());
    }
    
    @Override
    public void visit(ErrorMessage message) {
        System.out.println("Error: " + message.getText());
    }
    
    @Override
    public void visit(ListMessage message) {
        System.out.println("Rooms:");
        System.out.println(message.getText());
    }
    
    @Override
    public void visit(RecieveMessage message) {
        System.out.println(message.getText());
    }
    
    @Override
    public void visit(StatusMessage message) {
        if(message.getText() != null) {
            System.out.println(message.getText());
        }
    }
    
    @Override
    public void visit(UnknownMessage message) {
        System.out.println(message.getText());
    }
    
}
