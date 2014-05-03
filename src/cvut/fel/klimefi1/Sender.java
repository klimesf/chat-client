/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cvut.fel.klimefi1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sender class
 * 
 * Reads 
 * 
 * @author Filip Klimes <klimefi1@fel.cvut.cz>
 */
public class Sender implements Runnable {

    private DataOutputStream dos;
    
    public Sender(DataOutputStream dos) {
        this.dos = dos;
    }
    
    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        String command;
        
        while(true) {
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
                Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERR Could not send command to the server");
            }
            
            if(command.equals("BYE")) {
                break;
            }
        }
        
    }
    
}
