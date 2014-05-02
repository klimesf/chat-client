package cvut.fel.klimefi1.serverMessages;

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
    
    private final SimpleDateFormat dateFormat;

    /**
     * Body of the message
     */
    protected final String body;

    /**
     * Creates message
     *
     * @param body
     */
    public Message(String body) {
        this.body = body;
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
     * Returns output formatted for the file log
     *
     * @return output
     */
    public abstract String getFileOutput();

    /**
     * Returns output formatted for the console output
     *
     * @return
     */
    public abstract String getConsoleOutput();

}
