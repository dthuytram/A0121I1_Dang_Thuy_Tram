package codegym.repository;

import codegym.bean.Email;

import java.util.List;

public interface EmailRepository {
    List<Email> list();
    void saveOrEdit(Email email);
    Email getbyId(int id);
}
