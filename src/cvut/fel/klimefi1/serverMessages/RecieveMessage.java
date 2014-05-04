package cvut.fel.klimefi1.serverMessages;

/**
 * Receive message represents confirmation about sent message from the client
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class RecieveMessage extends TextOnlyMessage {
    /**
     * Constructor
     * 
     * @param body 
     */
    public RecieveMessage(String body) {
        super();
        this.text = "Message sent";
    }
    
}
