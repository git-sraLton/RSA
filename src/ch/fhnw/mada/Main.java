package ch.fhnw.mada;

import ch.fhnw.mada.chiffre.Crypt;
import ch.fhnw.mada.key.Key;
import ch.fhnw.mada.key.KeyPair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // generate Keys
        KeyPair keys = KeyPair.generateKeyPair();
        // write keys to files
        FileManager fm = new FileManager();
        fm.writeKeyFiles(keys, "data/aufgabe1/sk.txt", "data/aufgabe1/pk.txt");

        // encrypt message
        String message = fm.readFile("data/aufgabe2/text.txt");
        Key pk = fm.readKeyFile("data/aufgabe2/pk.txt");
        fm.writeFile("data/aufgabe2/chiffre.txt", Crypt.encrypt(message, pk));

        // decrypt message
        Key sk = fm.readKeyFile("data/aufgabe3/sk.txt");
        fm.writeFile("data/aufgabe3/text-d.txt", Crypt.decipher(fm.readFile("data/aufgabe3/chiffre.txt"), sk));

        // decrypt message
        Key givenSk = fm.readKeyFile("data/aufgabe4/sk.txt");
        fm.writeFile("data/aufgabe4/text-d.txt", Crypt.decipher(fm.readFile("data/aufgabe4/chiffre.txt"), givenSk));
    }

}
