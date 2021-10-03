package codegym.service;

import codegym.bean.Email;

import java.util.List;

public interface ServiceEmail {
    List<Email> list();
    void saveOrEdit(Email email);
    Email getbyId(int id);
}
