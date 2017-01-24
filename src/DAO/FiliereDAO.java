package DAO;

import Entities.Filiere;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by tarik on 1/24/2017.
 */
public class FiliereDAO {
    private Session session;
    private Transaction transaction;

    public FiliereDAO() {
        this.session = HibernateUtil.getSession();
        this.transaction =  session.getTransaction();
    }

    public void save( Filiere filiere ) {
        this.transaction.begin();
        this.session.saveOrUpdate( filiere );
        this.transaction.commit();
    }

    public List<Filiere> listAll() {
        return  this.session.createQuery( "from Filiere" ).list();
    }

    public Filiere getFiliere(String id ) {
        return ( Filiere ) session.get( Filiere.class, id );
    }

    public void delete( String id ) {
        this.transaction.begin();

        Filiere filiere = ( Filiere ) session.load( Filiere.class, id );
        this.session.delete( filiere );

        this.transaction.commit();
    }
}
