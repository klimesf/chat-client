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
public class ErrorMessage extends Message {

    public ErrorMessage(String body) {
        super(body);
    }

    @Override
    public String getFileOutput() {
        return null;
    }

    @Override
    public String getConsoleOutput() {
        return "Error: " + this.body;
    }
    
}
