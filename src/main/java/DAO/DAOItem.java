package DAO;

import Controlers.HibernateSessionFactoryUtil;
import models.Entities.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DAOItem  implements DAOable{
    public Item findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Item.class, id);
    }

    public void save(Item item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(item);
        tx1.commit();
        session.close();
    }

    public void update(Item item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(item);
        tx1.commit();
        session.close();
    }

    public void delete(Item item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(item);
        tx1.commit();
        session.close();
    }


    public List<Item> findAll() {
        List<Item> items = (List<Item>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From itemtable").list();
        return items;
    }
}

