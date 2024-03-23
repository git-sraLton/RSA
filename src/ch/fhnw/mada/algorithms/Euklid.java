package ch.fhnw.mada.algorithms;

import java.math.BigInteger;

public class Euklid {

    private BigInteger a;
    private BigInteger b;
    private BigInteger x0;
    private BigInteger y0;
    private BigInteger x1;
    private BigInteger y1;
    private BigInteger q;
    private BigInteger r;

    public Euklid(BigInteger a,
                  BigInteger b,
                  BigInteger x0,
                  BigInteger y0,
                  BigInteger x1,
                  BigInteger y1) {
        this.a = a;
        this.b = b;
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        if (!b.equals(new BigInteger("0"))) {
            this.q = a.divide(b);
            this.r = a.mod(b);
        }
    }

    public BigInteger getA() {
        return a;
    }

    public BigInteger getB() {
        return b;
    }

    public BigInteger getX0() {
        return x0;
    }

    public BigInteger getY0() {
        return y0;
    }

    public BigInteger getX1() {
        return x1;
    }

    public BigInteger getY1() {
        return y1;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Euklid{" +
                "a=" + a +
                ", b=" + b +
                ", x0=" + x0 +
                ", y0=" + y0 +
                ", x1=" + x1 +
                ", y1=" + y1 +
                ", q=" + q +
                ", r=" + r +
                '}';
    }
}
