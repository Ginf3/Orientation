package Actions;

import DAO.UserDAO;
import Entities.User;
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
public class ActionUser extends ActionSupport implements ModelDriven<User> {
    private User user= new User();
    private UserDAO userDao= new UserDAO();
    private List<User> Listuser= new ArrayList<>();

    private InputStream inputStream;
    HttpServletRequest request = ServletActionContext.getRequest();

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

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
        Gson gson = new Gson();
        user = gson.fromJson(request.getParameter("newU"), User.class);
        userDao.save(user);
        return "success";
    }

    public String edit(){
        user=userDao.getUser(Integer.parseInt(request.getParameter("id")));
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .create();

        String json = gson.toJson(user);

        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }

    public String list(){
        Listuser=userDao.listAll();
        String json = new Gson().toJson(Listuser);
        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }

    public String delete(){
        userDao.delete(Integer.parseInt(request.getParameter("id")));
        return SUCCESS;
    }
    @Override
    public User getModel() {
        return user;
    }
}
