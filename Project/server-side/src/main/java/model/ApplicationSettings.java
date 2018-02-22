/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moshe Itzhaki
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplicationSettings {
    private Integer limitConnection;

    public Integer getLimitConnection() {
        return limitConnection;
    }

    public void setLimitConnection(Integer limitConnection) {
        this.limitConnection = limitConnection;
    }
}
