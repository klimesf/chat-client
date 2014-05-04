package cvut.fel.klimefi1;

import cvut.fel.klimefi1.logger.ConsoleLogger;
import cvut.fel.klimefi1.logger.FileLogger;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main class of the Chat Client
 *
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class ChatClient {

    /**
     * Server socket
     */
    private static Socket server;
    
    /**
     * Receiver instance
     */
    private static Receiver receiver;
    
    /**
     * Sender instance
     */
    private static Sender sender;
    
    /**
     * ConsoleLogger instance
     */
    private static ConsoleLogger consoleLogger;
    
    /**
     * File logger instance
     */
    private static FileLogger fileLogger;

    /**
     * Main method
     * 
     * @param args command line arguments
     */
    public static void main(String args[]) {

        // Intro
        System.out.println("** ChatClient v0.2");
        System.out.println("** cvut.fel.klimefi1");
        System.out.println();

        ChatClient.consoleLogger = new ConsoleLogger();
        ChatClient.fileLogger = new FileLogger();

        try {
            Scanner input = new Scanner(System.in);

            // Get server address
            String ip = "127.0.0.1";
            int port = 4567;
            if (Arrays.asList(args).contains("selectip")) {
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
            receiver = new Receiver(response);
            receiver.registerVisitor(ChatClient.consoleLogger);
            receiver.registerVisitor(ChatClient.fileLogger);

            // Initialize sender
            sender = new Sender(new Scanner(System.in), dos);

            // Scan the nick as the first action
            String command;
            System.out.println("Client started ...\n");
            System.out.print("Insert nick: ");
            command = input.nextLine();

            // Set the nick
            dos.writeBytes("NICK " + command + "\n");

            // Run the threads
            receiver.start();
            sender.start();
            
            // Wait for threads to stop
            try {
                receiver.getThread().join();
            } catch (InterruptedException ex) {
            }
            try {
                sender.getThread().join();
            } catch (InterruptedException ex) {
            }

        } catch (ConnectException ex) {
            System.out.println("Server connection error!");
        } catch (IOException ex) {
            System.out.println("Server connection error!");
        } finally {
            // Stop threads
            ChatClient.stop();
            // Close server connection
            try {
                server.close();
            } catch (IOException ex) {
            }
            // Clean up file logger
            fileLogger.close();
        }
    }

    /**
     * Disconnects from server and cleans resources
     */
    public static void stop() {
        // Cloase threads
        if(ChatClient.receiver != null) {
            ChatClient.receiver.stop();
        }
        if(ChatClient.sender != null) {
            ChatClient.sender.stop();
        }
    }
}
