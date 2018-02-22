/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

/**
 *
 * @author Moshe Itzhaki
 */
public class Client {

    private DataOutputStream out;
    private DataInputStream in;
    
    private XMLSerializer xMLSerializer;
    
    private int port;
    
    private String host;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setxMLSerializer(XMLSerializer xMLSerializer) {
        this.xMLSerializer = xMLSerializer;
    }
    
    public void init() {

        try {
            InetAddress ipAddress = InetAddress.getByName(host);
            Socket socket = new Socket(ipAddress, port);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            in = new DataInputStream(sin);
            out = new DataOutputStream(sout);

        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    
    public void login(String login) {
        try {
            out.writeUTF(login);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    public void setProperties(Properties props) {
    	out.writeUTF("setProps");
    	out.write
    	// Serialize the "props" object to a string
    	// out.writeUTF(the serialized string) 
    	
    }*/
    
    
    public <T> T getModelAndCreateView(Class<T> t) throws IOException, JAXBException {
        out.writeUTF(t.getCanonicalName());
        String response = in.readUTF();
        return (T) xMLSerializer.getUnmarshaller().unmarshal(new StringReader(response));
    }
    
}
