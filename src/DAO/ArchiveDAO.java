package DAO;

import Entities.Archive;
import Entities.Etudiant;
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

    public void archiver( ) {
        EtudiantDAO dao = new EtudiantDAO();
        Archive archive;

        for(Etudiant E : dao.listAll()) {
            archive = new Archive( E.getCne() );
            archive.setNom( E.getNom());
            archive.setPrenom(E.getPrenom());
            archive.setNote( E.getNote());
            archive.setAffected( E.getAffected().getId());
            archive.setClassement( E.getClassement());
            archive.setChoix( E.getChoix());
            archive.setAnnee( E.getAnnee());
        }
        dao.deleteAll();

    }

    public List<Archive> listAll() {
        return  this.session.createQuery( "from Archive" ).list();
    }

    public Archive getEtudiant(String cne ) {
        return ( Archive ) session.get( Archive.class, cne );
    }

    public List<Archive> listPromo( String year) {
        return  this.session.createQuery( "from Archive A where A.annee = :annee " ).setParameter("annee",year).getResultList();
    }

    public List<Archive> getPromo(String promo ) {
        Query query = this.session.createQuery( "from Archive where annee = :promo" );
        query.setParameter( "promo", promo );
        return query.getResultList();
    }

}
