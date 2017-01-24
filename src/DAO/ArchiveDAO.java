package DAO;

import Entities.Archive;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by tarik on 1/24/2017.
 */
public class ArchiveDAO {
    private Session session;
    private Transaction transaction;

    public ArchiveDAO() {
        this.session = HibernateUtil.getSession();
        this.transaction =  session.getTransaction();
    }

    public void save( Archive archive ) {
        this.transaction.begin();
        this.session.saveOrUpdate( archive );
        this.transaction.commit();
    }

    public List<Archive> listAll() {
        return  this.session.createQuery( "from Archive" ).list();
    }

    public Archive getEtudiant(String cne ) {
        return ( Archive ) session.get( Archive.class, cne );
    }
    public List<Archive> getPromo(String promo ) {
        Query query = this.session.createQuery( "from Archive where annee = :promo" );
        query.setParameter( "promo", promo );
        return query.getResultList();
    }

    public void delete( String cne ) {
        this.transaction.begin();

        Archive etudiant = ( Archive ) session.load( Archive.class, cne );
        this.session.delete( etudiant );

        this.transaction.commit();
    }
}
