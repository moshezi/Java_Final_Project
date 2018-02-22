/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Moshe Itzhaki
 */
public class XMLSerializer {
    private JAXBContext context;

    public XMLSerializer() throws JAXBException {
        this.context = JAXBContext.newInstance("model");
    }
    
    public Unmarshaller getUnmarshaller() throws JAXBException{
        return context.createUnmarshaller();
    }
}
