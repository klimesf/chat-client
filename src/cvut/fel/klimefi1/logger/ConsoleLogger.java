package cvut.fel.klimefi1.logger;

import cvut.fel.klimefi1.serverMessages.Message;
import cvut.fel.klimefi1.interfaces.MessageObserver;

/**
 * Console logger
 * Observes Receiver and then prints out given message to the console
 * @author Filip Klimes
 */
public class ConsoleLogger implements MessageObserver {

    @Override
    public void update(Message message) {
        String output = message.getConsoleOutput();
        if(output != null) {
            System.out.println(output);
        }
    }
    
}
