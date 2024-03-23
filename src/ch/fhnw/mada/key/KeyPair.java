package ch.fhnw.mada.key;

import java.math.BigInteger;
import java.util.Random;

public class KeyPair {

    private Key privateKey;
    private Key publicKey;

    public KeyPair(Key privateKey, Key publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public static KeyPair generateKeyPair() {
        KeyGenerator keyGen = new KeyGenerator();
        return new KeyPair(new Key(keyGen.getN(), keyGen.getD()), new Key(keyGen.getN(), keyGen.getE()));
    }

    public Key getPrivateKey() {
        return privateKey;
    }

    public Key getPublicKey() {
        return publicKey;
    }

    @Override
    public String toString() {
        return "KeyPair{" +
                "privateKey=" + privateKey +
                ", publicKey=" + publicKey +
                '}';
    }
}
