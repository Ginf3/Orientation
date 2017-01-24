package DAO;

import Entities.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by tarik on 1/24/2017.
 */
public class PostDAO {
    private Session session;
    private Transaction transaction;

    public PostDAO() {
        this.session = HibernateUtil.getSession();
        this.transaction =  session.getTransaction();
    }

    public void save( Post post ) {
        this.transaction.begin();
        this.session.saveOrUpdate( post );
        this.transaction.commit();
    }

    public List<Post> listAll() {
        return  this.session.createQuery( "from Post" ).list();
    }

    public Post getPost(int id ) {
        return ( Post ) session.get( Post.class, id );
    }

    public void delete( int id ) {
        this.transaction.begin();

        Post post = ( Post ) session.load( Post.class, id );
        this.session.delete( post );

        this.transaction.commit();
    }
}
