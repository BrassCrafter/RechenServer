package de.tillmannrohlfing.rechenclient;

import util.network.Client;

public class Rechenclient extends Client {
    public Rechenclient(String IP, int port) {
        super(IP, port);
        sendMsg("MAX 4 5 6 7 9 4 2 3 4 5 6 7 8");
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

    public static void main(String[] args) {
        Rechenclient client = new Rechenclient("localhost", 143);
    }
}
