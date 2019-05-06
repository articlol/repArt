package jpa;



import org.hibernate.Session;
import org.hibernate.Transaction;



import java.util.List;

public class UserDAOEntity {


    public UserEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UserEntity.class, id);
    }

    public List<UserEntity> findAllUser() {
        List<UserEntity> userEntity = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from users").list();
        return userEntity;
    }

    public void insertUser(UserEntity userEntity) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(userEntity);
            tx.commit();
        }
    }

    public void updateUser(UserEntity userEntity) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(userEntity);
            tx.commit();
        }
    }

    public void deleteUser(UserEntity userEntity) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(userEntity);
            tx.commit();
        }
    }
    public RoleEntity findRoleById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(RoleEntity.class, id);
    }
}