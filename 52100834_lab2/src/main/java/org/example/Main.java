package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection conn;


    public static void showMenu() {
        System.out.println("1. Read product list\n" +
                "2. Read a product by input id\n" +
                "3. Add a new product, the result is the product id (auto increment)\n" +
                "4. Update a product\n" +
                "5. Delete a product\n" +
                "6. Exit");
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        try {
            int choice = 0;
            while (choice != 6) {
                Main.showMenu();
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Main.readAll(productDAO);
                        break;
                    case 2:
                        Main.selectTableWhereID(productDAO);
                        break;
                    case 3:
                        Main.insertTable(productDAO);
                        break;
                    case 4:
                        Main.updateTable(productDAO);
                        break;
                    case 5:
                        Main.deleteTable(productDAO);
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }

            }

        } catch (Exception ex) {

        }

    }


    public static void createDataBase() {
        try {

            String sql = "CREATE DATABASE IF NOT EXISTS productManagament";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println("create database successful");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void dropDataBase() {
        try {
            String sqlDropTable = "DROP TABLE IF EXISTS productManagament.products;";
            Statement stmDropTable = conn.createStatement();
            stmDropTable.executeUpdate(sqlDropTable);
            System.out.println("Drop DataBase successful");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createTable() {
        try {
            String sqlCreateTable = "create table productManagament.products(\n" +
                    "id int,\n" +
                    "name varchar(50),\n" +
                    "PRIMARY KEY(id)\n" +
                    ");";
            Statement stmCreateTable = conn.createStatement();
            stmCreateTable.executeUpdate(sqlCreateTable);
            System.out.println("create table successful");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void readTableByID(ProductDAO productDAO) {
        try {
            System.out.println("Enter ID: ");
            Scanner sc = new Scanner(System.in);
            Long id = sc.nextLong();
            if(productDAO.checkIdExist(id)){
                productDAO.checkIdExist(id);
            }
            else {
                System.out.println("ID not exits");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void insertTable(ProductDAO productDAO) {
        try {
            System.out.println("Enter name: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            System.out.println("Enter price: ");
            Double price = sc.nextDouble();

            productDAO.add(new Product(name, price));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void updateTable(ProductDAO productDAO) {
        try {
            System.out.println("Enter ID: ");
            Scanner sc = new Scanner(System.in);
            Long id = sc.nextLong();
            if (productDAO.checkIdExist(id)) {
                sc.nextLine();
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                System.out.println("Enter price: ");
                Double price = sc.nextDouble();

                productDAO.update(new Product(id, name, price));

            } else {
                System.out.println("ID not exist");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteTable(ProductDAO productDAO) {
        try {
            System.out.println("Enter ID: ");
            Scanner sc = new Scanner(System.in);
            Long id = sc.nextLong();
            if (productDAO.checkIdExist(id)) {
                productDAO.delete(id);
            } else {
                System.out.println("ID not exist");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readAll(ProductDAO productDAO) {
        productDAO.readAll();
    }

    public static void selectTableWhereID(ProductDAO productDAO) {
        try {
            System.out.println("Enter Id: ");
            Scanner sc = new Scanner(System.in);
            Long id = sc.nextLong();
            productDAO.read(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}