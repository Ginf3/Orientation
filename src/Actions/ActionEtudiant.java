package Actions;

import DAO.EtudiantDAO;
import DAO.UserDAO;
import Entities.Etudiant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hajar on 24/01/2017.
 */
public class ActionEtudiant extends ActionSupport implements ModelDriven<Etudiant> {
    private Etudiant etudiant = new Etudiant();
    private UserDAO daoUser=new UserDAO();
    private EtudiantDAO dao = new EtudiantDAO();
    private List<Etudiant> listeEtudiants = new ArrayList<>();
    private InputStream inputStream;
    HttpServletRequest request = ServletActionContext.getRequest();

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public EtudiantDAO getDao() {
        return dao;
    }

    public void setDao(EtudiantDAO dao) {
        this.dao = dao;
    }

    public List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    public void setListeEtudiants(List<Etudiant> listeEtudiants) {
        this.listeEtudiants = listeEtudiants;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String add() {
        Gson gson = new Gson();
        etudiant = gson.fromJson(request.getParameter("newEtudiant"), Etudiant.class);
        if(etudiant.getNote()==0)
        dao.importSansNote(etudiant);
        else dao.save(etudiant);
        return SUCCESS;
    }

    public String edit() {
        etudiant = dao.getEtudiant(request.getParameter("id"));

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .create();

        String json = gson.toJson(etudiant);

        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }

    public String list() {
        listeEtudiants = dao.listAll();
        String json = new Gson().toJson(listeEtudiants);
        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }

    public String delete() {
        dao.delete(request.getParameter("id"));
        return SUCCESS;
    }

    public String affect() {
        dao.processAffected();
        listeEtudiants = dao.listByNote();
        String json = new Gson().toJson(listeEtudiants);
        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }
    public String sortedList() {

        listeEtudiants = dao.listByNote();
        String json = new Gson().toJson(listeEtudiants);
        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }

    @Override
    public Etudiant getModel() {
        return etudiant;
    }
}
