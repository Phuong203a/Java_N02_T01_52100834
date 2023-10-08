package org.example.DAO;

import org.example.domain.Manufacturer;
import org.example.domain.MobilePhone;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.awt.dnd.InvalidDnDOperationException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO {
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");


    // Open a Hibernate session for a transaction.


    public boolean add(Manufacturer manufacturer) {


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(manufacturer);

        transaction.commit();
        session.close();
        sessionFactory.close();

        return true;
    }

    public Manufacturer get(Long id) {
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Manufacturer manufacturer = session.get(Manufacturer.class, id);


        transaction.commit();
        session.close();
        sessionFactory.close();
        return manufacturer;
    }

    public List<Manufacturer> getAll() {
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Manufacturer> list = new ArrayList<>();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Manufacturer> cq = cb.createQuery(Manufacturer.class);
        Root<Manufacturer> rootEntry = cq.from(Manufacturer.class);
        CriteriaQuery<Manufacturer> all = cq.select(rootEntry);

        TypedQuery<Manufacturer> allQuery = session.createQuery(all);
        list = allQuery.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }

    public boolean remove(Manufacturer manufacturer) {
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (get(manufacturer.getId()) == null) {
            System.out.println("Manufacturer id không tồn tại");
        } else {
            session.delete(manufacturer);
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
        return true;
    }

    public boolean update(Manufacturer manufacturer) {
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if (get(manufacturer.getId()) == null) {
            System.out.println("Manufacturer id không tồn tại");
        } else {
            session.update(manufacturer);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
        return true;
    }

    public void getEmploye() {
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("select * from manufacturer where employee >= 100;", Manufacturer.class);

        List<Manufacturer> phones = query.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();
        if (phones.isEmpty()) {
            System.out.println("Không có employee > 100 trong danh sách");
        }
        for (int i = 0; i < phones.size(); i++) {
            System.out.println(phones.get(i));
        }
    }
    public void getEmployeeSum() {
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<BigDecimal> query = session.createNativeQuery("select SUM(employee) from manufacturer ;");

        BigDecimal sum = query.uniqueResult();

        transaction.commit();
        session.close();
        sessionFactory.close();
        if (sum == null) {
            System.out.println("Không có employee sum trong danh sách ");
        }
        else{
            System.out.println("Tổng số nhân viên là: "+sum);
        }
    }
    public void getManufactureLast() {
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("SELECT * from manufacturer where location =\"US\" ORDER BY location DESC LIMIT 1;", Manufacturer.class);

        List<Manufacturer> phones = query.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();
        if (phones.isEmpty()) {
            throw new IllegalStateException("Khong co manufacturer");
        }
        for (int i = 0; i < phones.size(); i++) {
            System.out.println(phones.get(i));
        }
    }


}
