package mvc;

import model.ApplicationSettings;
import server.MyTCPIPServer;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moshe Itzhaki
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        JAXBContext jAXBContext = JAXBContext.newInstance(ApplicationSettings.class);
        File resource = new File("resources/context.xml");
        ApplicationSettings applicationSettings =
                (ApplicationSettings) jAXBContext.createUnmarshaller().unmarshal(resource);
        MyTCPIPServer iPServer;
        try {
            iPServer = new MyTCPIPServer(Integer.valueOf(args[0]));
            iPServer.setLimit(applicationSettings.getLimitConnection());
            iPServer.start();
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
