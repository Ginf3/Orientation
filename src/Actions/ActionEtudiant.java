package Actions;

import DAO.EtudiantDAO;
import Entities.Etudiant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hajar on 24/01/2017.
 */
public class ActionEtudiant extends ActionSupport implements ModelDriven<Etudiant> {
    private Etudiant Etd = new Etudiant();
    private EtudiantDAO EtdDao= new EtudiantDAO();
    private List<Etudiant> ListEtd= new ArrayList<>();

    public Etudiant getEtd() {
        return Etd;
    }

    public void setEtd(Etudiant etd) {
        Etd = etd;
    }

    public EtudiantDAO getEtdDao() {
        return EtdDao;
    }

    public void setEtdDao(EtudiantDAO etdDao) {
        EtdDao = etdDao;
    }

    public List<Etudiant> getListEtd() {
        return ListEtd;
    }

    public void setListEtd(List<Etudiant> listEtd) {
        ListEtd = listEtd;
    }
    public String add(){
        EtdDao.save(Etd);
        return "success";
    }


    public String edit(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Etd=EtdDao.getEtudiant(request.getParameter("id"));
        return "success";
    }

    public String list(){
        ListEtd=EtdDao.listAll();
        return "success";
    }

    public String delete(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        EtdDao.delete(request.getParameter("id"));
        return "success";
    }
    @Override
    public Etudiant getModel() {
        return Etd;
    }
}
