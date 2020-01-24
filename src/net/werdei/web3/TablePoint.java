package net.werdei.web3;

public class TablePoint {
    private double x, y, r;
    private boolean insideNative, insideCurrent;
    private String time;

    public TablePoint(Point point, double currentR) {
        x = point.getX();
        y = point.getY();
        r = point.getR();
        insideNative = point.getResult();
        time = point.getTime();

        insideCurrent = new Point(x, y, currentR, 0, "").getResult();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public String getTime() {
        return time;
    }

    public boolean isInsideNative() {
        return insideNative;
    }

    public boolean isInsideCurrent() {
        return insideCurrent;
    }
}
