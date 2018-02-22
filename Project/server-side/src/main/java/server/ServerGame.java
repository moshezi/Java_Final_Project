/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.beans.XMLEncoder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import mvc.StaticContext;

/**
 *
 * @author Moshe Itzhaki
 */
public class ServerGame {

    private int port;
    
    private int limitConnection;
    
    public void setPort(final int port) {
        this.port = port;
    }
    
    public void setLimitConnection(int limit) {
        this.limitConnection = limit;
    }
    
    public void start() throws IOException {
        try {
            ServerSocket ss = new ServerSocket(port, limitConnection);
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept();
            ss.setSoTimeout(0);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while (true) {
                line = in.readUTF();
                System.out.println(line);
                if (line.startsWith("login")) {
                    String login = line.split(":")[1];
                    StaticContext.registrationUser(login);
                    System.out.println(String.format("Logged user %s", login));
                } else if(line.startsWith("model.")) {
                    File file = new File("resources/classes/".concat(line.split("\\.")[1]).concat(".xml"));
                    FileInputStream fis = new FileInputStream(file);
                    byte[] data = new byte[(int) file.length()];
                    fis.read(data);
                    fis.close();

                    out.writeUTF(new String(data, "UTF-8"));
                }
                /*else if (line.startsWith("setProps")) {
                 	
                	
                 	XMLEncoder encoder = null;
            		try {
            			new XMLEncoder(new FileOutputStream("resources/classes/Properties.xml"));
            			encoder.wr

            		} catch (FileNotFoundException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
               		// "line" is the serialized XML, needs to be saved into the file Properties.xml
                 }
                */
                 
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
