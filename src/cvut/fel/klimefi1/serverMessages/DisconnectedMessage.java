package cvut.fel.klimefi1.serverMessages;

/**
 * Disconnected message represents message about disconnecting from the server
 * 
 * @author Filip Klimes
 */
public class DisconnectedMessage extends Message {

    /**
     * Constructor
     * 
     * @param body 
     */
    public DisconnectedMessage(String body) {
        super();
        this.text = "Disconnected";
    }
    
}
