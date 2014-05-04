package cvut.fel.klimefi1.serverMessages;

/**
 * Error message represents message about an error
 * 
 * @author Filip Klimes <klimefi1@fel.cvut>
 */
public class ErrorMessage extends TextOnlyMessage {
    
    /**
     * Constructor
     * 
     * @param body body of the message 
     */
    public ErrorMessage(String body) {
        super();
        this.text = body.trim();
    }

}
