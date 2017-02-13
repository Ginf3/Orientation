package Actions;

import DAO.FiliereDAO;
import DAO.PostDAO;
import Entities.Filiere;
import Entities.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hajar on 24/01/2017.
 */
public class ActionPost extends ActionSupport implements ModelDriven<Post> {
    private Post post= new Post();
    private PostDAO postDao=new PostDAO();
    private List<Post> Listpost= new ArrayList<>();
    private FiliereDAO FlrDao = new FiliereDAO();
    private List<Filiere> ListFlr=new ArrayList<>();
    private InputStream inputStream;
    HttpServletRequest request = ServletActionContext.getRequest();

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostDAO getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDAO postDao) {
        this.postDao = postDao;
    }

    public List<Post> getListpost() {
        return Listpost;
    }

    public void setListpost(List<Post> listpost) {
        Listpost = listpost;
    }
    public String add(){
        Gson gson = new Gson();
        post = gson.fromJson(request.getParameter("newP"), Post.class);
        postDao.save(post);
        return "success";
    }

    public String edit(){
        post=postDao.getPost(Integer.parseInt(request.getParameter("id")));
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .create();

        String json = gson.toJson(post);

        inputStream = new ByteArrayInputStream(json.getBytes());
        return SUCCESS;
    }

    public String list(){
        Listpost = postDao.listAll();
        ListFlr=FlrDao.listAll();
        List<Object> l=new ArrayList<>();
        l.add(Listpost);
        l.add(ListFlr);
        String json = new Gson().toJson(Listpost);
        String json2=new Gson().toJson(l);

        inputStream = new ByteArrayInputStream(json2.getBytes());
        return SUCCESS;
    }

    public String delete(){
        postDao.delete(Integer.parseInt(request.getParameter("id")));
        return SUCCESS;
    }
    @Override
    public Post getModel() {
        return post;
    }
}
