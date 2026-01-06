package com.klu.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== PRODUCT INVENTORY SYSTEM ======");
            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. Update Product Price / Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                // ---------------- INSERT ----------------
                case 1:
                    Session insertSession = HibernateUtil.getSessionFactory().openSession();
                    Transaction insertTx = insertSession.beginTransaction();

                    sc.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    Product product = new Product(name, desc, price, qty);
                    insertSession.save(product);

                    insertTx.commit();
                    insertSession.close();

                    System.out.println("✅ Product added successfully!");
                    break;

                // ---------------- RETRIEVE ----------------
                case 2:
                    Session viewSession = HibernateUtil.getSessionFactory().openSession();

                    System.out.print("Enter Product ID: ");
                    int viewId = sc.nextInt();

                    Product viewProduct = viewSession.get(Product.class, viewId);

                    if (viewProduct != null) {
                        System.out.println("ID: " + viewProduct.getId());
                        System.out.println("Name: " + viewProduct.getName());
                        System.out.println("Description: " + viewProduct.getDescription());
                        System.out.println("Price: " + viewProduct.getPrice());
                        System.out.println("Quantity: " + viewProduct.getQuantity());
                    } else {
                        System.out.println("❌ Product not found!");
                    }

                    viewSession.close();
                    break;

                // ---------------- UPDATE ----------------
                case 3:
                    Session updateSession = HibernateUtil.getSessionFactory().openSession();
                    Transaction updateTx = updateSession.beginTransaction();

                    System.out.print("Enter Product ID to Update: ");
                    int updateId = sc.nextInt();

                    Product updateProduct = updateSession.get(Product.class, updateId);

                    if (updateProduct != null) {
                        System.out.print("Enter New Price: ");
                        double newPrice = sc.nextDouble();

                        System.out.print("Enter New Quantity: ");
                        int newQty = sc.nextInt();

                        updateProduct.setPrice(newPrice);
                        updateProduct.setQuantity(newQty);

                        updateSession.update(updateProduct);
                        updateTx.commit();

                        System.out.println("✅ Product updated successfully!");
                    } else {
                        updateTx.rollback();
                        System.out.println("❌ Product not found!");
                    }

                    updateSession.close();
                    break;

                // ---------------- DELETE ----------------
                case 4:
                    Session deleteSession = HibernateUtil.getSessionFactory().openSession();
                    Transaction deleteTx = deleteSession.beginTransaction();

                    System.out.print("Enter Product ID to Delete: ");
                    int deleteId = sc.nextInt();

                    Product deleteProduct = deleteSession.get(Product.class, deleteId);

                    if (deleteProduct != null) {
                        deleteSession.delete(deleteProduct);
                        deleteTx.commit();
                        System.out.println("✅ Product deleted successfully!");
                    } else {
                        deleteTx.rollback();
                        System.out.println("❌ Product not found!");
                    }

                    deleteSession.close();
                    break;

                case 5:
                    System.out.println("🚪 Exiting Application...");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
        HibernateUtil.getSessionFactory().close();
    }
}
