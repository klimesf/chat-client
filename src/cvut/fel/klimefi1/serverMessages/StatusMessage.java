package cvut.fel.klimefi1.serverMessages;

/**
 * Status message represents received status of previous command
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class StatusMessage extends Message {

    /**
     * Constructor
     * 
     * @param body 
     */
    public StatusMessage(String body) {
        super();
        if(!body.equals("OK")) {
            this.text = body.trim();
        }
    }
    
}
