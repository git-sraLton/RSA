package ch.fhnw.mada.key;

import ch.fhnw.mada.algorithms.Euklid;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
    private final BigInteger primeP;
    private final BigInteger primeQ;
    private BigInteger n;
    private BigInteger phiN;
    private BigInteger e;
    private BigInteger d;

    public KeyGenerator() {
        primeP = BigInteger.probablePrime(512, new Random());
        primeQ = BigInteger.probablePrime(512, new Random());
        n = primeP.multiply(primeQ);
        phiN = phiFromPrimes(primeP, primeQ);
        e = generateD(phiN);
        d = generateE(phiN, e);
    }

    private static BigInteger phiFromPrimes(BigInteger primeP, BigInteger primeQ) {
        return primeP.subtract(new BigInteger("1"))
                .multiply(primeQ.subtract(new BigInteger("1")));
    }

    private static BigInteger generateD(BigInteger phi) {
        for (BigInteger i = new BigInteger("3"); !i.equals(phi); i = i.add(new BigInteger("2"))) {
            Euklid ggt = algorithm(new Euklid(phi,
                    i,
                    new BigInteger("1"),
                    new BigInteger("0"),
                    new BigInteger("0"),
                    new BigInteger("1")
            ));
            if (ggt.getA().equals(new BigInteger("1"))) {
                return i;
            }
        }
        return null;
    }

    private static BigInteger generateE(BigInteger phi, BigInteger d) {
        Euklid getD = algorithm(new Euklid(phi,
                d,
                new BigInteger("1"),
                new BigInteger("0"),
                new BigInteger("0"),
                new BigInteger("1")
        ));
        BigInteger e = getD.getY0();
        if (e.compareTo(new BigInteger("0")) < 0) e = e.mod(phi);
        return e;
    }

    private static Euklid algorithm(Euklid previous) {
        Euklid next = new Euklid(previous.getB(),
                previous.getR(),
                previous.getX1(),
                previous.getY1(),
                previous.getX0().subtract(previous.getQ().multiply(previous.getX1())),
                previous.getY0().subtract(previous.getQ().multiply(previous.getY1()))
        );
        return (next.getB().equals(new BigInteger("0"))) ?
                next :
                algorithm(next);
    }

    public BigInteger getPrimeP() {
        return primeP;
    }

    public BigInteger getPrimeQ() {
        return primeQ;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getPhiN() {
        return phiN;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    @Override
    public String toString() {
        return "KeyGenerator{" +
                "\nprimeP= " + primeP +
                "\nprimeQ= " + primeQ +
                "\nn= " + n +
                "\nphiN= " + phiN +
                "\ne= " + e +
                "\nd= " + d +
                "\n}";
    }
}
