package com.test.services;


import com.test.exceptions.NoEntityException;
import com.test.model.User;
import com.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@ComponentScan
@Transactional
public class UserServiceImpl implements UserService {

    
    private UserRepository repository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User getUser(Long id) throws NoEntityException {
        return repository.findById(id).orElseThrow(() -> new NoEntityException(id));
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }


    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
        System.out.println("User added");
    }


    public void changeUserById(User user) {
        repository.save(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User finByEmail(String userName) {
        return repository.findByEmail(userName);
    }


}
