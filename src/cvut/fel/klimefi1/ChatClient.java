package cvut.fel.klimefi1;

import cvut.fel.klimefi1.logger.ConsoleLogger;
import cvut.fel.klimefi1.logger.FileLogger;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class of the Chat Client
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class ChatClient {
    
    private static Socket server;
    private static Thread receiverThread;
    private static Thread senderThread;
    private static ConsoleLogger consoleLogger;
    private static FileLogger fileLogger;
    
    public static void main(String args[]) throws IOException {
        
        // Intro
        System.out.println("** ChatClient v0.1");
        System.out.println("** cvut.fel.klimefi1");
        System.out.println();
        
        ChatClient.consoleLogger = new ConsoleLogger();
        ChatClient.fileLogger = new FileLogger();
        
        try {
            Scanner input = new Scanner(System.in);
            
            // Get server address
            String ip = "127.0.0.1";
            int port = 4567;
            if(Arrays.asList(args).contains("selectip")) {
                System.out.print("Select IP address (default 127.0.0.1): ");
                ip = input.nextLine();
                System.out.print("Select port (default 4567): ");
                port = Integer.parseInt(input.nextLine());
            }
            
            // Connect to the server
            server = new Socket(ip, port);
            DataOutputStream dos = new DataOutputStream(server.getOutputStream());
            Scanner response = new Scanner(server.getInputStream());

            // Initialize receiver
            Receiver receiver = new Receiver(response);
            receiver.registerObserver(ChatClient.consoleLogger);
            receiver.registerObserver(ChatClient.fileLogger);
            
            // Initialize sender
            Sender sender = new Sender(dos);

            // Scan the nick as the first action
            String command;
            System.out.println("Client started ...\n");
            System.out.print("Insert nick: ");
            command = input.nextLine();

            // Set the nick
            dos.writeBytes("NICK " + command + "\n");

            // Run the threads
            receiverThread = new Thread(receiver);
            receiverThread.start();
            senderThread = new Thread(sender);
            senderThread.start();

        } catch(ConnectException ex) {
            System.out.println("Server connection error!");
            ChatClient.disconnect();
        }
    }
    
    public static void disconnect() {
        System.out.println("Client stopped.");
        // Close threads
        if(receiverThread != null) {
            receiverThread.interrupt();
        }
        if(senderThread != null) {
            senderThread.interrupt();
        }
        // Close server connection
        try {
            if(server != null)
                server.close();
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Close files
        ChatClient.fileLogger.close();
    }
}