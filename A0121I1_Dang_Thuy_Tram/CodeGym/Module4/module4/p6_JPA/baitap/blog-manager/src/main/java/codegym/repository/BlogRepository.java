package codegym.repository;

import codegym.bean.Blog;

import java.util.List;

public interface BlogRepository {
List<Blog> listBogs();
void SaveOrEdit(Blog blog);
void delete(int id);
Blog view(int id);
}
