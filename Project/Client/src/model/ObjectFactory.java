/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlRegistry;

/**
 *
 * @author Moshe Itzhaki
 */
@XmlRegistry
public class ObjectFactory {
    public CallableMaze createCallableMaze() {
        return new CallableMaze();
    }
    public Properties createProperties(){
        return new Properties();
    } 
}
