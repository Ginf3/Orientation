package Actions;

import DAO.UserDAO;
import Entities.User;
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
public class ActionUser extends ActionSupport implements ModelDriven<User> {
    private User user= new User();
    private UserDAO userDao= new UserDAO();
    private List<User> Listuser= new ArrayList<>();
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public List<User> getListuser() {
        return Listuser;
    }

    public void setListuser(List<User> listuser) {
        Listuser = listuser;
    }

    public String add(){

        userDao.save(user);
        return "success";
    }

    public String edit(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        user=userDao.getUser(request.getParameter("id"));
        return "success";
    }

    public String list(){
        Listuser=userDao.listAll();
        return "success";
    }

    public String delete(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        userDao.delete(request.getParameter("id"));
        return "success";
    }
    @Override
    public User getModel() {
        return user;
    }
}
