package cvut.fel.klimefi1.serverMessages;

/**
 * Unknown message represents unrecognized response from the server
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class UnknownMessage extends TextOnlyMessage {

    /**
     * Constructor
     * 
     * @param body
     */
    public UnknownMessage(String body) {
        super();
        this.text = "Server responded with an uknown message";
    }
    
}
