package net.werdei.web3;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name= "points")
public class Point {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "x")
    private double x;
    @Column(name = "y")
    private double y;
    @Column(name = "r")
    private double r;
    @Column(name = "inside")
    private boolean result;
    @Column(name = "time")
    private String time;
    @Column(name = "owner")
    private String owner;

    public Point()
    {
    }

    public Point(double rawX, double rawY, double rawR, int offset, String owner)
    {
        Date date = new Date();

        time = new SimpleDateFormat("HH:mm:ss").format(new Date(date.getTime()-3*1000*60*60-offset*1000*60));

        this.x = rawX;
        this.y = rawY;
        this.r = rawR;

        this.owner = owner;

        calculateResult();
    }


    @Override
    public String toString() {
        return String.format(Locale.ROOT,
                "{\"x\":\"%s\", \"y\":\"%s\", \"r\":\"%s\", \"result\":%s, \"time\":\"%s\"}",
                x, y, r, result, time);
    }

    public int getId() {
        return id;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getR()
    {
        return r;
    }

    public boolean getResult()
    {
        return result;
    }

    public String getTime()
    {
        return time;
    }

    public String getOwner() {
        return owner;
    }

    private void calculateResult()
    {
        double scaledX = x/r;
        double scaledY = y/r;

        //Quadrant I
        if (scaledX >= 0 && scaledY >= 0)
        {
            if (scaledY <= (1 - 2*scaledX))
                result = true;
            else
                result = false;
        }

        //Quadrant II
        else if (scaledX < 0 && scaledY > 0)
        {
            result = false;
        }

        //Quadrant III
        else if (scaledX <= 0 && scaledY <= 0)
        {
            if (scaledX >= -0.5 && scaledY >= -1)
                result = true;
            else
                result = false;
        }

        //Quadrant IV
        else if (scaledX > 0 && scaledY < 0)
        {
            if (Math.pow(scaledX, 2) + Math.pow(scaledY, 2) <= 0.25) //0.5^2 = 0.25
                result = true;
            else
                result = false;
        }

    }

}
