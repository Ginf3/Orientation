package Actions;

import DAO.ArchiveDAO;
import Entities.Archive;
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
public class ActionArchive extends ActionSupport implements ModelDriven<Archive> {
    private Archive Arch = new Archive();
    private ArchiveDAO ArchDao= new ArchiveDAO();
    private List<Archive> ListArch= new ArrayList<>();

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
    public String add(){
        ArchDao.save(Arch);
        return "success";
    }

    public String edit(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Arch=ArchDao.getEtudiant(request.getParameter("id"));
        return "success";
    }

    public String list(){
        ListArch=ArchDao.listAll();
        return "success";
    }

    public String delete(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        ArchDao.delete(request.getParameter("id"));
        return "success";
    }
    @Override
    public Archive getModel() {
        return Arch;
    }
}
