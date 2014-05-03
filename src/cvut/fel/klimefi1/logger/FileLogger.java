package cvut.fel.klimefi1.logger;

import cvut.fel.klimefi1.interfaces.MessageObserver;
import cvut.fel.klimefi1.serverMessages.Message;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File logger logs incoming server messages to corresponding files
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
     * Gets notified about new message
     * @param message 
     */
    @Override
    public void update(Message message) {
        this.visit(message);
    }
    
    /**
     * Cleans up resources
     */
    public void close() {
        for(FileHandler fof : files.values()) {
            fof.close();
        }
    }

    /**
     * Visits message
     * @param message 
     */
    @Override
    public void visit(Message message) {
        if(message.getRoom() == null || message.getSender() == null || message.getText() == null) {
            return;
        }
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
            Logger.getLogger(FileLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Retrieves FileHandler from files set
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
    
}
