package ch.fhnw.mada.algorithms;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class Exponentiation {
    public static BigInteger findMod(BigInteger exponent, BigInteger mod, BigInteger k) {
        char[] binary = exponent.toString(2).toCharArray();
        BigInteger h = new BigInteger("1");
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == '1') {
                h = h.multiply(k).mod(mod);
            }
            k = k.multiply(k).mod(mod);
        }
        return h;
    }
}
