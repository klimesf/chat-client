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
     * Date of the message.
     */
    private final Date date;
    
    /**
     * Date format.
     */
    private final SimpleDateFormat dateFormat;
    
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
     * Accepts visitor.
     * @param visitor
     */
    public abstract void accept(MessageVisitor visitor);

}
