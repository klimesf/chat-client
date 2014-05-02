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
public class FileLogger implements MessageObserver {

    /**
     * Map of the files
     */
    private final Map<String, FileOutputFacade> files;
    
    /**
     * Constructor
     */
    public FileLogger() {
        files = new HashMap<>();
    }
    
    @Override
    public void update(Message message) {
        String output = message.getFileOutput();
        if(output != null) {
            String[] parts = output.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < parts.length; i++) {
                sb.append(parts[i]).append(" ");
            }
            this.saveLog(message.getFormattedDate(), parts[0], sb.toString());
        }
    }

    /**
     * Saves log to the file
     * @param date
     * @param file corresponding file
     * @param log 
     */
    public void saveLog(String date, String file, String log) {
        FileOutputFacade fof = files.get(log);
        if(fof == null) {
            try {
                fof = new FileOutputFacade(file);
                files.put(file, fof);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileLogger.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        fof.writeBytes("[" + date + "] " + log);
    }
    
    /**
     * Cleans up resources
     */
    public void close() {
        for(FileOutputFacade fof : files.values()) {
            fof.close();
        }
    }
    
}
