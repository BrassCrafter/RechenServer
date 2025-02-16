package de.tillmannrohlfing.rechenserver;

import util.network.Server;

public class Rechenserver extends Server{

    public Rechenserver(int port) {
        super(port);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        send(pClientIP, pClientPort, "Hallo "+pClientIP+":"+pClientPort);
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {

    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }
}
