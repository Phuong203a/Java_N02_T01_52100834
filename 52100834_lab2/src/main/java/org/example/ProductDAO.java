
package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class ProductDAO<P extends Product, L extends Long> implements Repository<Product, Long> {
    private Connection connection;
    private final String SQL_SELECT = "SELECT * FROM productmanagament.products";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM productmanagament.products where id =?";
    private final String SQL_INSERT = "insert into productmanagament.products (name,price) values (?,?)";
    private final String SQL_UPDATE = "Update productmanagament.products set name=?,price=? where id=? ";
    private final String SQL_DROP =  "Delete from productmanagament.products where id=?";
    private final String SQL_CREATETABLE = "create table productmanagament.products(\n" +
            "id int,\n" +
            "name varchar(50),\n" +
            "PRIMARY KEY(id)\n" +
            ");";
    private final String SQL_DATABASE = "CREATE DATABASE IF NOT EXISTS productmanagament";

    @Override
    public Long add(Product item) {
        Long id = 0L;
        try {
            Connection conn = MySQLConfiguration.getConnection();
            String sqlInsert = "insert into productmanagament.products (name,price) values (?,?)";
            PreparedStatement ptmInsert = conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            ptmInsert.setString(1, item.getName());
            ptmInsert.setDouble(2, item.getPrice());

            ptmInsert.executeUpdate();
            ResultSet rs = ptmInsert.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            System.out.println("Insert successful");
        } catch (Exception ex) {
            System.out.println("Insert not seccessful");
            System.out.println(ex.getMessage());
        }
        return id;
    }

    @Override
    public List<Product> readAll() {

        try {
            Connection conn = MySQLConfiguration.getConnection();
            String sqlReadTable = "SELECT * FROM productmanagament.products";
            PreparedStatement ps = conn.prepareStatement(sqlReadTable);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Id: " + rs.getString(1) + " " + "Name: " + rs.getString(2) + "Price: " + rs.getDouble(3));
            }
            System.out.println("Read table successful");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Product read(Long id) {
        Product product = new Product();
        try {

            Connection conn = MySQLConfiguration.getConnection();
            String sqlReadTableID = "SELECT * FROM productmanagament.products where id = ? ";
            PreparedStatement pss = conn.prepareStatement(sqlReadTableID);
            pss.setLong(1, id);
            ResultSet rs = pss.executeQuery();


            while (rs.next()) {
                product.setId(rs.getLong(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                System.out.println("Id: " + rs.getString(1) + " " + "Name: " + rs.getString(2) + "Price: " + rs.getDouble(3));
                break;
            }
            System.out.println("Read table where id successful");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return product;
    }


    public Long Close(Product item) {
        System.exit(0);
        return null;
    }


    @Override
    public boolean update(Product item) {

        try {
            Connection conn = MySQLConfiguration.getConnection();
            String sqlUpdate = "Update productmanagament.products set name=?,price=? where id=? ";
            PreparedStatement ptmUpdate = conn.prepareStatement(sqlUpdate);
            ptmUpdate.setString(1, item.getName());
            ptmUpdate.setDouble(2, item.getPrice());
            ptmUpdate.setLong(3, item.getId());
            ptmUpdate.executeUpdate();

            System.out.println("Update successful");
        } catch (Exception ex) {
            System.out.println("Update not seccessful");
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection conn = MySQLConfiguration.getConnection();
            String sql = "Delete from productmanagament.products where id=?";
            PreparedStatement ptm = conn.prepareStatement(sql);
            ptm.setLong(1, id);
            ptm.executeUpdate();
            System.out.println("Delete successful");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Delete not successful");
        }
        return true;
    }

    public boolean checkIdExist(Long id) {
        try {
            Connection conn = MySQLConfiguration.getConnection();
            String sql = "Select * from productmanagament.products where id=?";
            PreparedStatement ptmDrop = conn.prepareStatement(sql);
            ptmDrop.setLong(1, id);

            ResultSet rs= ptmDrop.executeQuery();
            if (!rs.next()) {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

}

