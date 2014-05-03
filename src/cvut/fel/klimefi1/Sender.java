package cvut.fel.klimefi1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Sender class
 * 
 * Reads from System.in and sends commands to the server
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class Sender implements Runnable {

    private final DataOutputStream dos;
    
    private final Thread thread;
    
    private final Scanner input;
    
    /**
     * Creates a sender with given data output stream
     * @param input Scanner for input stream
     * @param dos Steam connected to the server
     */
    public Sender(Scanner input, DataOutputStream dos) {
        this.input = input;
        this.dos = dos;
        this.thread = new Thread(this);
    }
    
    /**
     * Starts the sender
     */
    public void start() {
        this.thread.start();
    }
    
    /**
     * Runs the sender
     */
    @Override
    public void run() {
        String command;
        
        while(input.hasNext() && !this.thread.isInterrupted()) {
            command = input.nextLine();

            if(command.equals("HELP")) {
                System.out.println("List of supported commands:");
                System.out.println("LIST                      - Returns a list of existing rooms on the server");
                System.out.println("CREATE  <name>            - Creates a new room with given name");
                System.out.println("ENTER   <room>            - Enters room with given name");
                System.out.println("LEAVE   <room>            - Leaves a room with given name");
                System.out.println("SEND    <room> <message>  - Sends a message for the given room");
                System.out.println("BYE                       - Disconnects from the server and exits the client");
                continue;
            }
            
            try {
                dos.writeBytes(command + "\n");
            } catch (IOException ex) {
                System.out.println("Server went away");
                ChatClient.disconnect();
                break;
            }
            
            if(command.equals("BYE")) {
                break;
            }
        }
    }

    /**
     * Stops the sender and cleans up resources
     */
    void stop() {
        this.input.close();
        this.thread.interrupt();
        try {
            this.dos.close();
        } catch (IOException ex) {
            System.out.println("An error occured while closing "
                    + "communication with server.");
        }
    }
}
