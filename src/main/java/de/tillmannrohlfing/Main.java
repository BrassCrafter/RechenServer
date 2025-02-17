package de.tillmannrohlfing;

import de.tillmannrohlfing.rechenclient.Rechenclient;
import de.tillmannrohlfing.rechenserver.Rechenserver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Rechenserver server = new Rechenserver(143);
        Rechenclient client = new Rechenclient("localhost", 143);

    }
}