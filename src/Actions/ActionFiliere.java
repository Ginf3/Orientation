package Actions;

import DAO.FiliereDAO;
import Entities.Archive;
import Entities.Filiere;
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
public class ActionFiliere extends ActionSupport implements ModelDriven<Filiere> {
    private Filiere Flr= new Filiere();
    private FiliereDAO FlrDao= new FiliereDAO();
    private List<Filiere> ListFlr= new ArrayList<>();


    public Filiere getFlr() {
        return Flr;
    }

    public void setFlr(Filiere flr) {
        Flr = flr;
    }

    public FiliereDAO getFlrDao() {
        return FlrDao;
    }

    public void setFlrDao(FiliereDAO flrDao) {
        FlrDao = flrDao;
    }

    public List<Filiere> getListFlr() {
        return ListFlr;
    }

    public void setListFlr(List<Filiere> listFlr) {
        ListFlr = listFlr;
    }
    public String add(){
        FlrDao.save(Flr);
        return "success";
    }

    public String edit(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Flr=FlrDao.getFiliere(request.getParameter("id"));
        return "success";
    }

    public String list(){
        ListFlr=FlrDao.listAll();
        return "success";
    }

    public String delete(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        FlrDao.delete(request.getParameter("id"));
        return "success";
    }
    @Override
    public Filiere getModel() {
        return Flr;
    }
}
