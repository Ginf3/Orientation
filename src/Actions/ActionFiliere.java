package Actions;

import DAO.FiliereDAO;
import Entities.Filiere;
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
public class ActionFiliere extends ActionSupport implements ModelDriven<Filiere> {
    private Filiere Flr = new Filiere();
    private FiliereDAO FlrDao = new FiliereDAO();
    private List<Filiere> ListFlr = new ArrayList<>();
    private InputStream inputStream;
    HttpServletRequest request = ServletActionContext.getRequest();

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

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

    public String add() {
        Gson gson = new Gson();
        Flr = gson.fromJson(request.getParameter("newF"), Filiere.class);
        FlrDao.save(Flr);
        return SUCCESS;
    }

    public String edit() {
        Flr = FlrDao.getFiliere(request.getParameter("id"));
        Flr.setId(request.getParameter("id"));

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .create();

        String json = gson.toJson(Flr);

        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }

    public String list() {
        ListFlr = FlrDao.listAll();
        String json = new Gson().toJson(ListFlr);
        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }

    public String delete() {
        System.out.print(request.getParameter("id"));
        FlrDao.delete(request.getParameter("id"));
        return SUCCESS;
    }

    @Override
    public Filiere getModel() {
        return Flr;
    }
}
