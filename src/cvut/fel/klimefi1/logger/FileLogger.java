package cvut.fel.klimefi1.logger;

import cvut.fel.klimefi1.serverMessages.ChatMessage;
import cvut.fel.klimefi1.serverMessages.DisconnectedMessage;
import cvut.fel.klimefi1.serverMessages.ErrorMessage;
import cvut.fel.klimefi1.serverMessages.ListMessage;
import cvut.fel.klimefi1.serverMessages.RecieveMessage;
import cvut.fel.klimefi1.serverMessages.StatusMessage;
import cvut.fel.klimefi1.serverMessages.TextOnlyMessage;
import cvut.fel.klimefi1.serverMessages.UnknownMessage;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * File logger logs incoming server messages to corresponding files
 * 
 * @author Filip Klimes <kliemfi1@fel.cvut.cz>
 */
public class FileLogger implements MessageVisitor {

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

    /**
     * Visits text only message.
     * @param message 
     */
    @Override
    public void visit(TextOnlyMessage message) {}
    
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
    
}
