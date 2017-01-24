package DAO;

import Entities.Etudiant;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by tarik on 1/24/2017.
 */
public class EtudiantDAO {
    private Session session;
    private Transaction transaction;

    public EtudiantDAO() {
        this.session = HibernateUtil.getSession();
        this.transaction =  session.getTransaction();
    }

    public void save( Etudiant etudiant ) {
        this.transaction.begin();
        this.session.saveOrUpdate( etudiant );
        this.transaction.commit();
    }

    public List<Etudiant> listAll() {
        return  this.session.createQuery( "from Etudiant" ).list();
    }

    public Etudiant getEtudiant(String cne ) {
        return ( Etudiant ) session.get( Etudiant.class, cne );
    }

    public void delete( String cne ) {
        this.transaction.begin();

        Etudiant etudiant = ( Etudiant ) session.load( Etudiant.class, cne );
        this.session.delete( etudiant );

        this.transaction.commit();
    }
}
