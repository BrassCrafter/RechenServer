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

        String[] msg = pMessage.split(" ");
        try{
            String operator = msg[0];
            int[] numbers = new int[msg.length-1];
            for(int i=1;i<msg.length;i++){
                numbers[i-1] = Integer.parseInt(msg[i]);
            }
            switch(operator) {
                case "ADD":
                    send(pClientIP, pClientPort, numbers[1] + " + " + numbers[2] + " = " + (numbers[1]+numbers[2]));
                    break;
                case "SUB":
                    send(pClientIP, pClientPort, numbers[1] + " - " + numbers[2] + " = " + (numbers[1] - numbers[2]));
                    break;
                case "MUL":
                    send(pClientIP, pClientPort, numbers[1] + " * " + numbers[2] + " = " + (numbers[1] * numbers[2]));
                    break;
                case "DIV":
                    send(pClientIP, pClientPort, numbers[1] + " / " + numbers[2] + " = " + (numbers[1] / numbers[2]));
                    break;
                case "SUM":
                    int sum = 0;
                    for(int i=0; i<numbers.length;i++){
                        sum += numbers[i];
                    }
                    send(pClientIP, pClientPort, pMessage+" = " + (sum));
                    break;
                case "MIN":
                    int pivotMIN = numbers[0];
                    for(int i=1; i<numbers.length;i++){
                        if(numbers[i]<pivotMIN){
                            pivotMIN = numbers[i];
                        }
                    }
                    send(pClientIP, pClientPort, pMessage+" = " + (pivotMIN));
                    break;
                case "MAX":
                    int pivotMAX = numbers[0];
                    for(int i=1; i<numbers.length;i++){
                        if(numbers[i]>pivotMAX){
                            pivotMAX = numbers[i];
                        }
                    }
                    send(pClientIP, pClientPort, pMessage+" = " + (pivotMAX));
                    break;
                default:
                    send(pClientIP, pClientPort, pMessage + " kenn ich nicht!");
            }
        }catch(Exception e){
            send(pClientIP, pClientPort, "ERROR: "+e.getMessage());
        }

    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {
        send(pClientIP, pClientPort, "Tschüss!");
    }

    public static void main(String[] args) {
        Rechenserver server = new Rechenserver(143);
    }
}
