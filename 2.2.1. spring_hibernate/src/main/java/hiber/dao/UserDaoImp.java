package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {

      Session session = sessionFactory.getCurrentSession();
      session.persist(user.getCar());
      session.save(user);
      //sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUser(String model, int series) {
      String hql = "select u FROM User u WHERE u.car.model = ?1 and u.car.series = ?2";
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter(1, model);
      query.setParameter(2, series);

      return (User) query.getSingleResult();
   }

}
