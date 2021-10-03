package codegym.service.impl;

import codegym.bean.Blog;
import codegym.repository.BlogRepository;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> listBogs() {
        return blogRepository.listBogs();
    }

    @Override
    public void SaveOrEdit(Blog blog) {
        blogRepository.SaveOrEdit(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.delete(id);
    }

    @Override
    public Blog view(int id) {
        return blogRepository.view(id);
    }
}
