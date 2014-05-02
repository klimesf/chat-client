/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cvut.fel.klimefi1.serverMessages;

/**
 *
 * @author filip
 */
public class ListMessage extends Message {

    public ListMessage(String body) {
        super(body);
    }

    @Override
    public String getFileOutput() {
        return null;
    }

    @Override
    public String getConsoleOutput() {
        String[] rooms = this.body.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(String room : rooms) {
            sb.append(" - ").append(room).append("\n");
        }
        
        return sb.toString();
    }
    
}
