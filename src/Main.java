import DAO.*;
import Entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;

/**
 * Created by ismailrei on 1/23/17.
 */
public class Main {


    public static void main(final String[] args) throws Exception {

     System.out.println("querying all the managed entities...");
//        Etudiant e = new Etudiant();
//        EtudiantDAO dao = new EtudiantDAO();
//        UserDAO dao2 = new UserDAO();
//        FiliereDAO  dao3 = new FiliereDAO();
//
//        List<Etudiant> liste = new ArrayList<>();
//        e.setCne("21");
//        e.setNom("ahmed");
//        e.setPrenom("ahmed");
//        e.setNote(15);
//        liste.add(e);
//
//        Etudiant e1 = new Etudiant();
//        e1.setCne("3");
//        e1.setNom("kamal");
//        e1.setPrenom("kamal");
//        e1.setNote(14);
//        liste.add(e1);
//
//        Etudiant e2 = new Etudiant();
//        e2.setCne("56");
//        e2.setNom("jamal");
//        e2.setPrenom("jamal");
//        e2.setNote(14);
//        liste.add(e2);
//
//        dao.importNote(liste);
        EtudiantDAO dao = new EtudiantDAO();
        dao.adjustOrder();
        dao.processAffected();
        for( Etudiant E : dao.listByNote())
            System.out.println( E.getClassement()+ " -- " + E.getNote() +" -- " + E.getAffected().getId());

//        Filiere f = new Filiere();
//        f.setId("GINF1");
//        f.setNom("genie");
//        dao3.save(f);
//
//        User u = new User();
//        u.setLogin("hh");
//        u.setEmail("dd");
//        u.setPassword("ll");
//        u.setAdmin(false);
//        dao2.save(u);
//
//        e.setCne("1234ell");
//        e.setChoix("something");
//        e.setNom("something");
//        e.setClassement(1);
//        e.setNote(10);
//        e.setPrenom("that");
//        e.setAffected( f );
//        e.setOneToOne(dao2.getUser(4 ));
//        dao.save(e);

//        ArchiveDAO dao = new ArchiveDAO();
//        Archive a = new Archive();
//        a.setCne("dvfdv");
//        a.setAffected("ff");
//        a.setAnnee("2222");
//        a.setChoix("sssss");
//        a.setClassement(2);
//        a.setNom("dcdc");
//        a.setNote(15);
//        a.setPrenom("sdsd");
//        PostDAO dao = new PostDAO();
//        Post p = new Post();
////        p.setTitle("hello");
////        p.setPicture("pic.jpg");
////        p.setContent("fill me");
//////        dao.save(p);
//        p = dao.getPost(1);
////        p.setTitle("hello cp2");
////        dao.save(p);
//        dao.delete( 1 );
    }

}