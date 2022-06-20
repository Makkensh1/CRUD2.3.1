package com.test.repositories;

import com.test.model.Cart;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface CartRepository extends CrudRepository<Cart, Long> {

}
