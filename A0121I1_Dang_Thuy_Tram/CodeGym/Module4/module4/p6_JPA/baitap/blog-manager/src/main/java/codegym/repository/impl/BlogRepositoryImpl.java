package codegym.repository.impl;

import codegym.bean.Blog;
import codegym.repository.BlogRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

import java.util.List;
@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
 @Autowired
 private SessionFactory sessionFactory;
    @Override
    public List<Blog> listBogs() {
        TypedQuery<Blog> query = sessionFactory.getCurrentSession().createQuery("select b from Blog b");
        return query.getResultList();
    }

    @Override
    public void SaveOrEdit(Blog blog) {
        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(blog);
    }

    @Override
    public void delete(int id) {
        Session session= sessionFactory.getCurrentSession();
        session.remove(view(id));
    }

    @Override
    public Blog view(int id) {
        TypedQuery<Blog> query = sessionFactory.getCurrentSession().createQuery("select b from Blog b where b.id=?1",Blog.class);
        Blog blog= query.setParameter(1,id).getSingleResult();
        return blog;
    }
}
