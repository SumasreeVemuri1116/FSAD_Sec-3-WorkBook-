package com.klu.app;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.model.Product;
import com.klu.util.HibernateUtil;

public class HQLApp {

    public static void main(String[] args) {

        System.out.println("PROGRAM STARTED");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 55000, 10));
        session.save(new Product("Mouse", "Electronics", 1200, 40));
        session.save(new Product("Keyboard", "Electronics", 1500, 30));
        session.save(new Product("Pen", "Stationery", 20, 100));
        session.save(new Product("Notebook", "Stationery", 80, 60));
        session.save(new Product("Chair", "Furniture", 3000, 8));

        tx.commit();
        System.out.println("\n--- Price Ascending ---");
        session.createQuery("from Product p order by p.price asc", Product.class)
               .list()
               .forEach(p ->
                   System.out.println(p.getName() + " " + p.getPrice())
               );
        System.out.println("\n--- Quantity Descending ---");
        session.createQuery("from Product p order by p.quantity desc", Product.class)
               .list()
               .forEach(p ->
                   System.out.println(p.getName() + " " + p.getQuantity())
               );

        System.out.println("\n--- First 3 Products ---");
        session.createQuery("from Product", Product.class)
               .setFirstResult(0)
               .setMaxResults(3)
               .list()
               .forEach(p -> System.out.println(p.getName()));

        System.out.println("\n--- Next 3 Products ---");
        session.createQuery("from Product", Product.class)
               .setFirstResult(3)
               .setMaxResults(3)
               .list()
               .forEach(p -> System.out.println(p.getName()));

        Long total = session.createQuery(
                "select count(p) from Product p", Long.class)
                .uniqueResult();
        System.out.println("\nTotal Products = " + total);

        Object[] minMax = session.createQuery(
                "select min(p.price), max(p.price) from Product p",
                Object[].class).uniqueResult();
        System.out.println("Min Price = " + minMax[0]);
        System.out.println("Max Price = " + minMax[1]);

        System.out.println("\n--- Group By Description ---");
        List<Object[]> group = session.createQuery(
                "select p.description, count(p) from Product p group by p.description")
                .list();

        for (Object[] row : group) {
            System.out.println(row[0] + " -> " + row[1]);
        }

        System.out.println("\n--- Names Starting with M ---");
        session.createQuery("from Product p where p.name like 'M%'", Product.class)
               .list()
               .forEach(p -> System.out.println(p.getName()));

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
