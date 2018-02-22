/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;

/**
 *
 * @author Moshe Itzhaki
 */
public class MyTCPIPServer {

    private final int port;
    
    private ServerGame serverGame;
    
    private int limit;
    
    public MyTCPIPServer(int port) throws IOException {
        this.port = port;
    }

    public void start() throws IOException {
        this.serverGame = new ServerGame();
        this.serverGame.setPort(port);
        this.serverGame.setLimitConnection(limit);
        this.serverGame.start();
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    
}
