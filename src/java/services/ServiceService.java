/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import dao.IDao;
import entities.Service;
import ma.projet.util.HibernateUtil;
/**
 *
 * @author akhmim
 */
public class ServiceService implements IDao<Service>{

    @Override
    public boolean create(Service o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Service o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Service o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Service getById(int id) {
        Service machine  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        machine  = (Service) session.get(Service.class, id);
        session.getTransaction().commit();
        return machine;
    }

    @Override
    public List<Service> getAll() {
        List <Service> machines = null;
      
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        machines  = session.createQuery("from Service").list();
        session.getTransaction().commit();
        return machines;
    }
    
    
    public List<Object[]> nbmachine(){
        List<Object[]> machines = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        machines  = session.createQuery("select count(m.marque), m.marque from Service m group by m.marque").list();
        session.getTransaction().commit();
        return machines;
    }
    
    public List<Service> getbydates(Date d1 , Date d2){
        List <Service> machines = new ArrayList<>();
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         machines  = session.createQuery("from Service m where m.dateAchat between :d1 and :d2").setParameter("d1", d1).setParameter("d2", d2).list();
        session.getTransaction().commit();
        return machines;
        
    }
    
}
