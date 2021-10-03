package codegym.service.impl;

import codegym.bean.Email;
import codegym.repository.EmailRepository;
import codegym.service.ServiceEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmailImp implements ServiceEmail {
    @Autowired
    EmailRepository emailRepository;

    @Override
    public List<Email> list() {
        return emailRepository.list();
    }

    @Override
    public void saveOrEdit(Email email) {
        emailRepository.saveOrEdit(email);
    }

    @Override
    public Email getbyId(int id) {
        return emailRepository.getbyId(id);
    }
}
