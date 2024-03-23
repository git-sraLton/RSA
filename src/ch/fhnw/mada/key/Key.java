package ch.fhnw.mada.key;

import java.math.BigInteger;

public class Key {
        private BigInteger base;
        private BigInteger exponent;

        public Key(BigInteger base, BigInteger exponent) {
            this.base = base;
            this.exponent = exponent;
        }

        public BigInteger getBase() {
            return base;
        }

        public BigInteger getExponent() {
            return exponent;
        }

    @Override
    public String toString() {
        return "Key{" +
                "\nbase=" + base +
                "\nexponent=" + exponent +
                '}';
    }
}
