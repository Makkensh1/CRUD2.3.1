package com.test.services;


import com.test.exceptions.NoEntityException;
import com.test.model.User;
import com.test.repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@ComponentScan
public class UserServiceImpl implements UserService {

    private final SessionFactory sessionFactory;
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(SessionFactory session, UserRepository repository) {
        this.sessionFactory = session;
        this.repository = repository;
    }

    @Transactional
    public User getUser(Long id) throws NoEntityException {
        return repository.findById(id).orElseThrow(() -> new NoEntityException(id));
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public void addUser(String name, String surName, String email, double cash) {
        User newUser = new User(name, surName, email, cash);
        repository.save(newUser);
    }

    public void addUser(User user) {
        repository.save(user);
        System.out.println("User added");
    }

    @Override
    public void changeUserById(Long id, String userName, String userSurName, String userEmail, double userCash) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE User set name = :nameParam, surName = :surNameParam, " +
                    "email = :emailParam, cash =:cashParam where id =: idParam");
            query.setParameter("idParam", id);
            query.setParameter("nameParam", userName);
            query.setParameter("emailParam", userEmail);
            query.setParameter("surNameParam", userSurName);
            query.setParameter("cashParam", userCash);
            query.executeUpdate();
            transaction.commit();
        } catch (
                Exception ex) { // не ловит no entityException
            if (transaction == null) {
                transaction.rollback();
            }

        } finally {
            sessionFactory.close();
        }

    }

    public List<User> getAllUsers() {
        return  (List<User>) repository.findAll();
    }
}
