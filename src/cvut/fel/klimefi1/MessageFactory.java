package cvut.fel.klimefi1;
import cvut.fel.klimefi1.serverMessages.*;

/**
 * Factory for creating concrete messages
 * @author Filip Klimes
 */
public class MessageFactory {

    /**
     * Creates message of given type with given body
     * @param type
     * @param body
     * @return 
     */
    public Message createMessage(String type, String body) {
        
        Message message;
        
        switch(type) {
            case "STATUS":
                message = new StatusMessage(body);
                break;
                
            case "ERR":
                message = new ErrorMessage(body);
                break;
                
            case "LIST":
                message = new ListMessage(body);
                break;
                
            case "GOODBYE":
                message = new DisconnectedMessage(body);
                break;
                
            case "RECV":
                message = new RecieveMessage(body);
                break;
                
            case "MSG":
                message = new ChatMessage(body);
                break;
                
            default:
                message = new UnknownMessage(body);
                break;
        }
        
        return message;
    }
    
}
