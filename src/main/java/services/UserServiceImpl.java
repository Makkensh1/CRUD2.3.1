package services;

import Exceptions.NoEntityException;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final Session session; // sessionFactory??
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(Session session, UserRepository repository) {
        this.session = session;
        this.repository = repository;
    }

    public User getUser(Long id) throws NoEntityException {
        return repository.findById(id).orElseThrow(() -> new NoEntityException(id));
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public void addUser(String name, String surName, String email) {
        User newUser = new User(name, surName, email);
        repository.save(newUser);
    }

    public void addUser(User user) {
        repository.save(user);
    }

    @Override
    public void changeUserById(Long id, String userName, String userSurName, String email) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE User set name = :nameParam, surName = :surNameParam, email = :email where id =: idParam");
            query.setParameter("idParam", id);
            query.setParameter("nameParam", userName);
            query.setParameter("email", email);
            query.setParameter("surNameParam", userSurName);
            query.executeUpdate();
            transaction.commit();
        } catch (
                Exception ex) { // как тут обработать 2 ошибки айди не существует и любая другая дрисня которая могла возникнуть в процессе
            if (transaction == null) {
                transaction.rollback();
            }

        } finally {
            session.close();
        }
    }
}
