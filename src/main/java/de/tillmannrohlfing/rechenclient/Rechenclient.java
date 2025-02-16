package de.tillmannrohlfing.rechenclient;

import util.network.Client;

public class Rechenclient extends Client {
    public Rechenclient(String IP, int port) {
        super(IP, port);
        sendMsg("Hello World");
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println("empfangen: "+pMessage);
    }

    public void sendMsg(String pMessage) {
        System.out.println("gesendet: "+pMessage);
        send(pMessage);
    }

    public void closeConnection() {
        close();
    }
}
