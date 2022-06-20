package com.test.repositories;


import com.test.model.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface UserRepository extends JpaRepository<User, Long> {

}
