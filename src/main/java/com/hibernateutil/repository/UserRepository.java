package com.hibernateutil.repository;

import com.hibernateutil.config.HibernateUtil;
import com.hibernateutil.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public final class UserRepository {


    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


        public final String getUsernameById(int id) {

        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<String> criteria = builder.createQuery( String.class );
        Root<User> root = criteria.from( User.class );

        criteria.select( root.get( "username" ) );

        criteria.where( builder.equal( root.get( "id" ), id ) );

        List<String> selectValue = entityManager.createQuery( criteria ).getResultList();

        entityManager.close();

        if (selectValue == null || selectValue.isEmpty()){

            return null;

        } else {

            return selectValue.get(0);
        }

    }



//    public final User getUserByEmail(final String email){
//
//
//        EntityManager entityManager = sessionFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Object[]> criteria = builder.createQuery( Object[].class );
//        Root<User> root = criteria.from( User.class );
//
//        Path<String> authEmailId = root.get( "email" );
//        Path<String> authPasswordId = root.get( "password" );
//        Path<String> authEnabledId = root.get( "enabled" );
//        Path<String> authAuthorityId = root.get( "authority" );
//
//        criteria.multiselect( authEmailId, authPasswordId, authEnabledId, authAuthorityId );
//
//        criteria.where( builder.equal( root.get( "email" ), email ) );
//
//        List<Object[]> authLoginId = entityManager.createQuery( criteria ).getResultList();
//
//        entityManager.close();
//
//        Object[] objects = authLoginId.get(0);
//
//        User user = new User();
//
//        user.setEmail(objects[0].toString());
//        user.setPassword(objects[1].toString());
//        user.setEnabled((Boolean) objects[2]);
//        user.setAuthority(objects[3].toString());
//
//        return user;
//    }
//
//
//
//    public final void createUserReg(final User user){
//
//        EntityManager entityManager = sessionFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(user);
//
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//
//    }
//
//
//
//    public final void updateEnabledTokenByUsername (final User user) {
//
//        EntityManager entityManager = sessionFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        entityManager.createQuery("UPDATE User SET enabled = :enabled, token = :token where username = :username")
//                .setParameter("enabled", user.getEnabled())
//                .setParameter("token", user.getToken())
//                .setParameter("username", user.getUsername())
//                .executeUpdate();
//
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//
//
//    }
//
//
//    public final void updateTokenByEmail (final User user) {
//
//        EntityManager entityManager = sessionFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        entityManager.createQuery("UPDATE User SET token = :token where email = :email")
//                .setParameter("token", user.getToken())
//                .setParameter("email", user.getEmail())
//                .executeUpdate();
//
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//
//    }
//
//
//
//
//    public final void updateEnabledTokenPasswordByEmail (final User user) {
//
//        EntityManager entityManager = sessionFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        entityManager.createQuery("UPDATE User SET enabled = :enabled, token = :token, password = :password where email = :email")
//
//                .setParameter("enabled", user.getEnabled())
//                .setParameter("token", user.getToken())
//                .setParameter("password", user.getPassword())
//                .setParameter("email", user.getEmail())
//                .executeUpdate();
//
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//
//
//    }
//
//
//    public final List<User> getAll() {
//
//        Session session = sessionFactory.openSession();
//
//        session.beginTransaction();
//
//        List<User> users = session.createNativeQuery("SELECT * FROM User limit 1", User.class ).getResultList();
//
//        session.getTransaction().commit();
//
//        session.close();
//
//        return users;
//
//
//    }








    /* Далее мы проверяем, имеется ли уже такой username и email *//*
    @Override
    public final boolean getSelectFieldByWhereField(final String selectField, final String whereField, final String whereValue) {

        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<String> criteria = builder.createQuery( String.class );
        Root<User> root = criteria.from( User.class );

        criteria.select( root.get( selectField ) );

        criteria.where( builder.equal( root.get( whereField ), whereValue ) );

        boolean user = entityManager.createQuery( criteria ).getResultList().isEmpty();

        entityManager.close();

        return !user;

    }*/



}
