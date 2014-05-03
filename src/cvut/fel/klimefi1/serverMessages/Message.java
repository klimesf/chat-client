package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Message abstract class
 *
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public abstract class Message {

    /**
     * Date of the message
     */
    private final Date date;
    
    /**
     * Date format
     */
    private final SimpleDateFormat dateFormat;

    /**
     * Name of the sender
     */
    protected String sender = null;
    
    /**
     * Text of the message
     */
    protected String text = null;
    
    /**
     * Name of the room
     */
    protected String room = null;

    /**
     * Constructor. Prepares date of the message.
     */
    public Message() {
        this.date = new Date();
        this.dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    }

    /**
     * Returns formatted date
     *
     * @return
     */
    public String getFormattedDate() {
        return this.dateFormat.format(this.date);
    }
    
    /**
     * Accepts visitor
     * @param visitor
     */
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Returns name of the message sender
     * @return 
     */
    public String getSender() {
        return sender;
    }

    /**
     * Returns text of the message
     * @return 
     */
    public String getText() {
        return text;
    }

    /**
     * Returns name of the room
     * @return 
     */
    public String getRoom() {
        return room;
    }

}
