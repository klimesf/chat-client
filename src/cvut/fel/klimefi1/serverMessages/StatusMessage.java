package cvut.fel.klimefi1.serverMessages;

/**
 *
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class StatusMessage extends Message {

    public StatusMessage(String author) {
        super(author);
    }

    @Override
    public String getFileOutput() {
        return null;
    }

    @Override
    public String getConsoleOutput() {
        if(this.body.equals("OK")) return null;
        else return "Status: " + this.body;
    }
    
}
