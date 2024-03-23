package ch.fhnw.mada.chiffre;

import ch.fhnw.mada.algorithms.Exponentiation;
import ch.fhnw.mada.key.Key;

import java.math.BigInteger;
import java.util.Arrays;

public class Crypt {
    public static String encrypt(String text, Key publicKey) {
        int[] asciis = text.chars().map(operand -> (int) operand).toArray();
        StringBuilder cryptString = new StringBuilder();
        for (int ascii : asciis) {
            cryptString
                    .append(
                            Exponentiation.findMod(
                                    publicKey.getExponent(),
                                    publicKey.getBase(),
                                    new BigInteger(String.valueOf(ascii))))
                    .append(",");
        }
        return cryptString.substring(0, cryptString.length() - 1);
    }

    public static String decipher(String text, Key privateKey) {
        String[] encodedNumbers = text.split(",");
        StringBuilder decipheredString = new StringBuilder();
        for (String number : encodedNumbers) {
            decipheredString.append(
                    (char) Integer.parseInt(Exponentiation.findMod(
                            privateKey.getExponent(),
                            privateKey.getBase(),
                            new BigInteger(number)
                    ).toString())
            );
        }
        return decipheredString.toString();
    }

}
