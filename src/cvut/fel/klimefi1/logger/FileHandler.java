package cvut.fel.klimefi1.logger;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handler for logging files
 * 
 * @author Filip Kimes <klimefi1@fel.cvut.cz>
 */
public class FileHandler {
    
    /**
     * File holder
     */
    private final File file;
    
    /**
     * Data output stream for the file
     */
    private final DataOutputStream dos;
    
    /**
     * Name of the file
     */
    private final String filename;

    /**
     * Creates FileHandler for given filename.
     * 
     * @param filename
     * @throws FileNotFoundException 
     */
    public FileHandler(String filename) throws FileNotFoundException {
        this.filename = "room-" + filename + ".log";
        this.file = new File(this.filename);
        this.dos = new DataOutputStream(new FileOutputStream(file, true)); // Append = true
    }
    
    /**
     * Writes given message to the file.
     * 
     * @param log 
     */
    public void writeBytes(String log) {
        try {
            this.dos.writeBytes(log + "\n");
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Closes opened files. TTypically used to clean up resources.
     */
    public void close() {
        try {
            this.dos.close();
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
