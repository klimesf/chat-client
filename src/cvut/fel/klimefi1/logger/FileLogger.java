package cvut.fel.klimefi1.logger;

import cvut.fel.klimefi1.interfaces.MessageObserver;
import cvut.fel.klimefi1.serverMessages.ChatMessage;
import cvut.fel.klimefi1.serverMessages.DisconnectedMessage;
import cvut.fel.klimefi1.serverMessages.ErrorMessage;
import cvut.fel.klimefi1.serverMessages.ListMessage;
import cvut.fel.klimefi1.serverMessages.Message;
import cvut.fel.klimefi1.serverMessages.RecieveMessage;
import cvut.fel.klimefi1.serverMessages.StatusMessage;
import cvut.fel.klimefi1.serverMessages.UnknownMessage;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * File logger logs incoming server messages to corresponding files
 * 
 * @author Filip Klimes <kliemfi1@fel.cvut.cz>
 */
public class FileLogger implements MessageObserver, MessageVisitor {

    /**
     * Map of the files
     */
    private final Map<String, FileHandler> files;
    
    /**
     * Constructor
     */
    public FileLogger() {
        files = new HashMap<>();
    }
    
    
    
    /**
     * Cleans up resources. Closes all containing files.
     */
    public void close() {
        for(FileHandler fof : files.values()) {
            fof.close();
        }
    }

    /**
     * Visits ChatMessage and logs it into a file.
     * 
     * @param message 
     */
    @Override
    public void visit(ChatMessage message) {
        try {
            FileHandler fh = this.getFileHandler(message.getRoom());
            StringBuilder sb = new StringBuilder();
            // Create the log string
            sb.append("[").append(message.getFormattedDate()).append("] ");
            sb.append(message.getSender()).append(": ");
            sb.append(message.getText());
            sb.append("\n");
            // Write to file
            fh.writeBytes(sb.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Error: Logging file not found");
        }
    }

    @Override
    public void visit(DisconnectedMessage message) {}

    @Override
    public void visit(ErrorMessage message) {}

    @Override
    public void visit(ListMessage message) {}

    @Override
    public void visit(RecieveMessage message) {}

    @Override
    public void visit(StatusMessage message) {}

    @Override
    public void visit(UnknownMessage message) {}
    
    /**
     * Retrieves FileHandler from files set
     * If there is no such FileHandler, creates a new one.
     * 
     * @param key Name of the room
     * @return File handler
     * @throws FileNotFoundException 
     */
    private FileHandler getFileHandler(String key) throws FileNotFoundException {
        if(files.containsKey(key)) {
            return files.get(key);
        } else {
            FileHandler fh = new FileHandler(key);
            files.put(key, fh);
            return fh;
        }
    }
@Override
    public void update(Message message) {
        switch(message.getClass().getName())  {
            case "ChatMessage":
                this.visit((ChatMessage)message);
                break;
                
            case "DisconnectedMessage":
                this.visit((DisconnectedMessage)message);
                break;
                
            case "ErrorMessage":
                this.visit((ErrorMessage)message);
                break;
                
            case "ListMessage":
                this.visit((ListMessage)message);
                break;
                
            case "RecieveMessage":
                this.visit((RecieveMessage)message);
                break;
                
            case "StatusMessage":
                this.visit((StatusMessage)message);
                break;
                
            case "UnknownMessage":
                this.visit((UnknownMessage)message);
                break;
        }
    }
}
