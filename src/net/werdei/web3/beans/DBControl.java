package net.werdei.web3.beans;

import net.werdei.web3.Point;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DBControl
{
    private static List<Point> points;
    private static boolean empty;

    private static EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();

    static {
        Query query = em.createQuery("select p from Point p");
        points = query.getResultList();
        System.out.println(points.toString());

        empty = points.size() <= 0;
    }

    public static List<Point> getPoints() {
        return points;
    }

    public static List<Point> getPoints(String o)
    {
        Query query = em.createQuery("select p from Point p where owner = :o");
        query.setParameter("o", o);

        List<Point> pts = query.getResultList();
        return pts;
    }

    public static void removePoints(String o)
    {
        EntityTransaction deleteTransaction = em.getTransaction();
        deleteTransaction.begin();
        Query query = em.createQuery("DELETE FROM Point p WHERE p.owner = :o");
        query.setParameter("o", o);
        System.out.println("Deleted " + query.executeUpdate() + " points from DB");
        deleteTransaction.commit();
    }

    public static void addPoint(Point currentPoint) {
        points.add(0, currentPoint);
        addPointToDatabase(currentPoint);

        empty = points.size() <= 0;
    }

    public static void setEmpty(boolean empty) {

    }

    public static boolean isEmpty(){
        return empty;
    }


    private static void addPointToDatabase(Point p){
        em.getTransaction().begin();
        em.persist(p);
        em.flush();
        em.getTransaction().commit();
        System.out.println("Added new point to a DB");
    }
}
