package cvut.fel.klimefi1.serverMessages;

/**
 *
 * @author filip
 */
public class ChatMessage extends Message {

    public ChatMessage(String author) {
        super(author);
    }

    @Override
    public String getFileOutput() {
        String[] parts = this.body.split(" ");
        StringBuilder output = new StringBuilder();
        
        output.append(parts[0]).append(" "); // For the file logger to recognize the room name

        output.append(parts[1]).append(": ");
        
        for(int i = 2; i < parts.length; i++) {
            output.append(parts[i]).append(" ");
        }
        
        return output.toString();
    }

    @Override
    public String getConsoleOutput() {
        String[] parts = this.body.split(" ");
        StringBuilder output = new StringBuilder();
        
        output.append("[").append(parts[0]).append("] ");
        output.append(parts[1]).append(": ");
        
        for(int i = 2; i < parts.length; i++) {
            output.append(parts[i]).append(" ");
        }
        
        return output.toString();
    }
}
