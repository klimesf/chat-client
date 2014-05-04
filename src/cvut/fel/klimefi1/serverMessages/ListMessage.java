package cvut.fel.klimefi1.serverMessages;

import cvut.fel.klimefi1.logger.MessageVisitor;
import java.util.Arrays;
import java.util.List;

/**
 * List message represents list of rooms on the server
 * 
 * @author Filip Klimes
 */
public class ListMessage extends Message {

    
    private final String text;
    
    /**
     * Constructor
     * 
     * @param body 
     */
    public ListMessage(String body) {
        super();
        // Get rooms
        List<String> rooms = Arrays.asList(body.trim());
        StringBuilder sb = new StringBuilder();
        for(String roomName : rooms) {
            sb.append(" - ").append(roomName).append("\n");
        }
        // Fill attributes
        this.text = sb.toString();
    }

    public String getText() {
        return text;
    }
    
    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }
    
}
