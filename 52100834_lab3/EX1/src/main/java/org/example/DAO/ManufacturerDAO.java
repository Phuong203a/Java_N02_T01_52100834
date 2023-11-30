package org.example.DAO;

import org.example.Domain.Manufacturer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManufacturerDAO {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    public boolean add(Manufacturer manufacturer){
        entityTransaction.begin();
        entityManager.persist(manufacturer);
        entityTransaction.commit();
        return true;
    }
}
