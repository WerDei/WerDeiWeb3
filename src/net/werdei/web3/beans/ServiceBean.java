package net.werdei.web3.beans;

import net.werdei.web3.Point;
import net.werdei.web3.TablePoint;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ServiceBean
{
    private String username;
    private double x, y, r;
    private double yGraph, xGraph;
    private boolean inside;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isInside() {
        return inside;
    }


    public void testPointForm()
    {
        Point p = new Point(x, y, r, 0, username);
        inside = p.getResult();

        DBControl.addPoint(p);
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void testPointGraph()
    {
        Point p = new Point(xGraph, yGraph, r, 0, username);
        inside = p.getResult();

        DBControl.addPoint(p);
    }

    public double getyGraph() {
        return yGraph;
    }

    public void setyGraph(double yGraph) {
        this.yGraph = yGraph;
    }

    public double getxGraph() {
        return xGraph;
    }

    public void setxGraph(double xGraph) {
        this.xGraph = xGraph;
    }

    public String getResultTableClass()
    {
        List<Point> points = DBControl.getPoints(username);

        return points.size() > 0 ? "" : "hidden";
    }

    public List<TablePoint> getUserPoints()
    {
        System.out.println("Returning table points");
        System.out.println(r);
        List<Point> points = DBControl.getPoints(username);

        ArrayList<TablePoint> tp = new ArrayList<TablePoint>();
        points.forEach(point -> tp.add(new TablePoint(point, r)));

        tp.forEach(p -> System.out.println(p.isInsideCurrent() + " / " + p.isInsideNative()));

        return tp;
    }

    public void clearHistory()
    {
        DBControl.removePoints(username);
    }
}
