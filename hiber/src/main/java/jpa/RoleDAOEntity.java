package jpa;


import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.relation.Role;

import java.util.List;

public class RoleDAOEntity {

    public Session findById(int id) {
        return (Session) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(RoleEntity.class, id);
    }

    public List<Role> findAllRole() {
        List<Role> roleEntity = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from role").list();
        return roleEntity;
    }

    public void insertRole(RoleEntity roleEntity) {
       try( Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
           Transaction tx = session.beginTransaction();
           session.save(roleEntity);
           tx.commit();
       }
    }

    public void updateRole(RoleEntity roleEntity) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(roleEntity);
            tx.commit();
        }
    }

    public void deleteRole(RoleEntity roleEntity) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(roleEntity);
            tx.commit();
        }
    }
}