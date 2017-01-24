package DAO;

import Entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public User getUser(String id ) {
        return ( User ) session.get( User.class, id );
    }

    public void delete( String id ) {
        this.transaction.begin();

        User user = ( User ) session.load( User.class, id );
        this.session.delete( user );

        this.transaction.commit();
    }
}
