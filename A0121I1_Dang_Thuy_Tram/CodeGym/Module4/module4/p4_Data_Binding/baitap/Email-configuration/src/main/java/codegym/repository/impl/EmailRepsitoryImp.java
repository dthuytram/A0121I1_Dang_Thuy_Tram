package codegym.repository.impl;

import codegym.bean.Email;
import codegym.repository.EmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmailRepsitoryImp implements EmailRepository {
    private static final Map<Integer,Email> emails ;


    static {
        emails = new HashMap<>();
        emails.put(1,new Email(1,"vietname",5,false,"hello ban yeu dấu"));
    }


    @Override
    public List<Email> list() {
        return new ArrayList<>(emails.values());
    }

    @Override
    public void saveOrEdit(Email email) {
       emails.put(email.getId(),email);
    }

    @Override
    public Email getbyId(int id) {
        return emails.get(id);
    }
}
