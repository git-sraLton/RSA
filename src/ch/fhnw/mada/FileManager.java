package ch.fhnw.mada;

import ch.fhnw.mada.key.Key;
import ch.fhnw.mada.key.KeyPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class FileManager {
    public void writeKeyFiles(KeyPair keys, String filePathSK, String filePathPK) {
        writeFile(filePathSK, "(" +
                keys.getPrivateKey().getBase() +
                "," +
                keys.getPrivateKey().getExponent() +
                ")");
        writeFile(filePathPK, "(" +
                keys.getPublicKey().getBase() +
                "," +
                keys.getPublicKey().getExponent() +
                ")");
    }

    public Key readKeyFile(String filePath) {
        String[] keyStrings = readFile(filePath).split(",");
        return new Key(
                new BigInteger(keyStrings[0].split("\\(")[1]),
                new BigInteger(keyStrings[1].split("\\)")[0]));
    }

    public String readFile(String filePath) {
        StringBuilder fileString = new StringBuilder();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileString.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fileString.toString();
    }

    public void writeFile(String filePath, String content) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
