package DAO;

import Entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by tarik on 1/24/2017.
 */
public class UserDAO {
    private Session session;
    private Transaction transaction;

    public UserDAO() {
        this.session = HibernateUtil.getSession();
        this.transaction =  session.getTransaction();
    }

    public void save( User user ) {
        this.transaction.begin();
        this.session.saveOrUpdate( user );
        this.transaction.commit();
    }

    public List<User> listAll() {
        return  this.session.createQuery( "from User" ).list();
    }

    public User getUser( int id ) {
        return ( User ) session.get( User.class, id );
    }

    public User getByLogin( String login ) {
        return ( User ) this.session.createQuery( "From User u Where u.login = :login ").setParameter("login", login).getSingleResult();
    }

    public void delete( int id ) {
        this.transaction.begin();

        User user = ( User ) session.load( User.class, id );
        this.session.delete( user );

        this.transaction.commit();
    }
}
