package Actions;

import DAO.PostDAO;
import Entities.Post;
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
public class ActionPost extends ActionSupport implements ModelDriven<Post> {
    private Post post= new Post();
    private PostDAO postDao=new PostDAO();
    private List<Post> Listpost= new ArrayList<>();


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
        postDao.save(post);
        return "success";
    }

    public String edit(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        post=postDao.getPost(Integer.parseInt(request.getParameter("id")));
        return "success";
    }

    public String list(){
        Listpost=postDao.listAll();
        return "success";
    }

    public String delete(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        postDao.delete(Integer.parseInt(request.getParameter("id")));
        return "success";
    }
    @Override
    public Post getModel() {
        return post;
    }
}
