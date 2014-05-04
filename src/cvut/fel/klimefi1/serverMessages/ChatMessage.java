package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;

/**
 * Chat message represents incoming chat message from the server in a room
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class ChatMessage extends Message {

    /**
     * Name of the room to which the message belongs.
     */
    private final String room;
    
    /**
     * Name of the sender of the message.
     */
    private final String sender;
    
    /**
     * Text of the message.
     */
    private final String text;
    
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

    /**
     * Returns room name.
     * @return 
     */
    public String getRoom() {
        return room;
    }

    /**
     * Returns sender name.
     * @return 
     */
    public String getSender() {
        return sender;
    }

    /**
     * Returns text of the message.
     * @return 
     */
    public String getText() {
        return text;
    }

    /**
     * Accepts visitor.
     * @param visitor 
     */
    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }
    
}
