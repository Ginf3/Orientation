import DAO.ArchiveDAO;
import DAO.EtudiantDAO;
import DAO.PostDAO;
import DAO.UserDAO;
import Entities.Archive;
import Entities.Etudiant;
import Entities.Post;
import Entities.User;
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
//        User u = new User();
//
//        u.setLogin("kka");
//        dao2.save(u);
//
//        e.setCne("1234e");
//        e.setUser(u);
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


        ArrayList<String> array = new ArrayList<>();
        array.add("helo");
        array.add("hello");
        array.add("hii");
       for( String a : array ){
           if( a.equals( "hello")){
               System.out.println(1);
           }
           System.out.println(a);
       }
    }

}