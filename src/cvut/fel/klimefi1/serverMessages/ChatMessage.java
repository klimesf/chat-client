package cvut.fel.klimefi1.serverMessages;

/**
 * Chat message represents incoming chat message from the server in a room
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class ChatMessage extends Message {

    /**
     * Constructor
     * Parses raw message from the server and stores data into attributes.
     * 
     * @param body
     */
    public ChatMessage(String body) {
        super();
        // message structure: room(a)sender(b)message...
        // Get indexes
        int a, b;
        a = body.indexOf(" ");
        b = body.indexOf(" ", a + 1);
        // Fill attributes
        this.room = body.substring(0, a).trim();
        this.sender = body.substring(a, b).trim();
        this.text = body.substring(b).trim();
    }
    
}
