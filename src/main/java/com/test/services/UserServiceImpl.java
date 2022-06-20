package com.test.services;


import com.test.exceptions.NoEntityException;
import com.test.model.User;
import com.test.repositories.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@ComponentScan
@Transactional
public class UserServiceImpl implements UserService {


    private final UserRepository repository;


    public UserServiceImpl(UserRepository repository) {

        this.repository = repository;
    }


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
        User user1 = new User("vas", "das", "cas", 40);
        repository.save(user1);
        System.out.println("User added");
    }


    public void changeUserById(User user) {
        repository.save(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }
}
