package DAO;

import Entities.Etudiant;
import Entities.Filiere;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

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

    public void importSansNote( List<Etudiant> liste ) {
        for( Etudiant E : liste )
            this.save( E );
    }

    public void importNote( List<Etudiant> liste ) {
        Etudiant oldEtudiant;
        for( Etudiant E : liste ){
            oldEtudiant = this.getEtudiant( E.getCne() );
            oldEtudiant.setNote( E.getNote());
            this.save( E );
        }
    }

    /* Returns a list of students sorted by note */
    private List<Etudiant> listByNote() {
        String hql = "FROM Etudiant E  ORDER BY E.note DESC";
        Query query = session.createQuery(hql);
        List results = query.list();
        return  results;
    }

    private void adjustOrder() {
        int ranking = 1;
        for( Etudiant E : listByNote()) {
            E.setClassement( ranking );
            this.save( E );
            ranking ++;
        }
    }

    /* Takes a string of tokens delimited by / and return the corresponding array. */
    public ArrayList< String> tokens( String string ) {
        ArrayList< String > tokens = new ArrayList<>();
        StringTokenizer tokenized = new StringTokenizer( string,"/" );

        while ( tokenized.hasMoreTokens())
            tokens.add( tokenized.nextToken());
        return  tokens;
    }

    public void processAffected( ){

        /* Initializing 'effectif' count. */
        FiliereDAO filiereDAO = new FiliereDAO();
        HashMap< String, Integer > effectif =  new HashMap<>();
        for( Filiere filiere : filiereDAO.listAll())
            effectif.put( filiere.getId() ,0 );

        /* Sort Students by 'note'. */
        List< Etudiant > Etudiants = this.listByNote();

        for( Etudiant E : Etudiants ) {

            /* Transforming 'choix' from a tokenized String into an Array of String. */
            ArrayList< String > choix = this.tokens( E.getChoix());

            for( String choice : choix ) {

                /* The chosen 'filiere' is not full yet. */
                if( effectif.get( choice ) <= filiereDAO.getFiliere( choice ).getEffictif()) {

                    /* A hardWorker give him/her what he/she desires ;) */
                    E.setAffected( filiereDAO.getFiliere( choice ));
                    this.save( E );

                    /* Increment the 'effectif' for the current 'filiere'. */
                    effectif.put( choice, effectif.get( choice) + 1 );

                    /* We should break this loop and prevent it from changing the 'affected', since the choice is made. */
                    break;

                }

            /* Sorry boy this 'filiere' is full let's try ur luck with ur next choice. */
            }
        }
    }
}
