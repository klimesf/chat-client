/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cvut.fel.klimefi1.interfaces;

import cvut.fel.klimefi1.serverMessages.Message;

/**
 *
 * @author filip
 */
public interface MessageObserver {
    
    void update(Message message);
    
}
