package codegym.service;

import codegym.bean.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> listBogs();
    void SaveOrEdit(Blog blog);
    void delete(int id);
    Blog view(int id);
}
