package Actions;

import DAO.ArchiveDAO;
import Entities.Archive;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hajar on 24/01/2017.
 */
public class ActionArchive extends ActionSupport implements ModelDriven<Archive> {
    private Archive Arch = new Archive();
    private ArchiveDAO ArchDao= new ArchiveDAO();
    private List<Archive> ListArch= new ArrayList<>();
    private InputStream inputStream;
    HttpServletRequest request = ServletActionContext.getRequest();

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Archive getArch() {
        return Arch;
    }

    public void setArch(Archive arch) {
        Arch = arch;
    }

    public ArchiveDAO getArchDao() {
        return ArchDao;
    }

    public void setArchDao(ArchiveDAO archDao) {
        ArchDao = archDao;
    }

    public List<Archive> getListArch() {
        return ListArch;
    }

    public void setListArch(List<Archive> listArch) {
        ListArch = listArch;
    }



    public String list(){
        ListArch=ArchDao.listAll();
        String json = new Gson().toJson(ListArch);
        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }
    public String search()
    {

        ListArch=ArchDao.listPromo(request.getParameter("syear"));
        String json = new Gson().toJson(ListArch);
        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;

    }

    @Override
    public Archive getModel() {
        return Arch;
    }
}
