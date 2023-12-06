package org.example.DAO;

import org.example.domain.Manufacturer;
import org.example.domain.MobilePhone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MobilePhoneDAO {

    Configuration configurationn = new Configuration().configure("hibernate.cfg.xml");
    public boolean add(MobilePhone mobilePhone){

        SessionFactory sessionFactory = configurationn.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Manufacturer manufacturer = session.get(Manufacturer.class,mobilePhone.getManufacturerId());
        if(manufacturer == null){
            System.out.println("Manufacturer khong ton tai");
            return false;
        }
        session.save(mobilePhone);

        transaction.commit();
        session.close();
        sessionFactory.close();

        return true;
    }
    public MobilePhone get(Long id){
        SessionFactory sessionFactory = configurationn.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        MobilePhone mobilePhone =  session.get(MobilePhone.class,id);


        transaction.commit();
        session.close();
        sessionFactory.close();
        return mobilePhone;
    }
    public List< MobilePhone> getAllPhone(){
        SessionFactory sessionFactory = configurationn.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List< MobilePhone> list = new ArrayList<>();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MobilePhone> cq = cb.createQuery(MobilePhone.class);
        Root<MobilePhone> rootEntry = cq.from(MobilePhone.class);
        CriteriaQuery<MobilePhone> all = cq.select(rootEntry);

        TypedQuery<MobilePhone> allQuery = session.createQuery(all);
        list = allQuery.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        return list;
    }
    public boolean remove(MobilePhone mobilePhone){
        SessionFactory sessionFactory = configurationn.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if(get(mobilePhone.getId())==null){
            System.out.println("MobilePhone id không tồn tại");
        }else {
            session.delete(mobilePhone);
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
        return  true;
    }
    public boolean update(MobilePhone mobilePhone){
        SessionFactory sessionFactory = configurationn.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        if(get(mobilePhone.getId())==null){
            System.out.println("MobilePhone id không tồn tại");
        }else {
            session.update(mobilePhone);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
        return  true;
    }
    public void getHighestPrice(){
        SessionFactory sessionFactory = configurationn.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("SELECT * FROM mobile_phone where price = (select max(price) from mobile_phone)", MobilePhone.class );

        List<MobilePhone> phones = query.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();
        if(phones.isEmpty()){
            System.out.println("Không có số điện thoại trong danh sách");
        }
        for(int i=0;i<phones.size();i++) {
            System.out.println(phones.get(i));
        }
    }
    public void getSortPhone(){
        SessionFactory sessionFactory = configurationn.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("SELECT * FROM mobile_phone order by country  asc, price desc;", MobilePhone.class );

        List<MobilePhone> phones = query.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();
        if(phones.isEmpty()){
            System.out.println("Không có số điện thoại trong danh sách");
        }
        for(int i=0;i<phones.size();i++) {
            System.out.println(phones.get(i));
        }
    }
    public void getPriceSame(){
        SessionFactory sessionFactory = configurationn.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("select * from mobile_phone mp where price > 50000000;", MobilePhone.class );

        List<MobilePhone> phones = query.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();
        if(phones.isEmpty()){
            System.out.println("Không có số điện thoại trong danh sách > 50000000");
        }
        for(int i=0;i<phones.size();i++) {
            System.out.println(phones.get(i));
        }
    }
    public void getColorPink(){
        SessionFactory sessionFactory = configurationn.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("select * from mobile_phone where color = \"Pink\" and price >15000000 limit 1;", MobilePhone.class );

        List<MobilePhone> phones = query.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();
        if(phones.isEmpty()){
            System.out.println("Không có số điện thoại trong danh sách > 50000000");
        }
        for(int i=0;i<phones.size();i++) {
            System.out.println(phones.get(i));
        }
    }


}
