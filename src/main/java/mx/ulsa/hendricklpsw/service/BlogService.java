package mx.ulsa.hendricklpsw.service;

import mx.ulsa.hendricklpsw.modelo.Blog;
import mx.ulsa.hendricklpsw.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    IBlogRepository blogRepo;

    public List<Blog> getAllBlog(){
        List<Blog> bloglList = new ArrayList<>();
        blogRepo.findAll().forEach(Blog -> bloglList.add(Blog));
        return bloglList;
    }

    public Blog getBlogById(Integer id){return blogRepo.findById(id).get(); }

    public boolean saveOrUpdateBlog(Blog blog){
        Blog updatedBlog = blogRepo.save(blog);

        if(blogRepo.findById(updatedBlog.getId()) != null){
            return true;
        }

        return false;
    }

    public boolean deleteBlog(Integer id){
        blogRepo.deleteById(id);
        if(blogRepo.findById(id) != null){
            return true;
        }
        return false;
    }
}
