/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mychatapp.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amar
 */
public class MessageTransmitter extends Thread {
    String message,hostname;
    int port;
    
    public MessageTransmitter(){
        
    }

    public MessageTransmitter(String message, String hostname, int port) {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
    }
    
    

    @Override
    public void run() {
        try {
            //  super.run(); //To change body of generated methods, choose Tools | Templates.
            //Socket coonects to the server socket. ServerSocket receives a socket..
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(message.getBytes());
            s.close();
            } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
