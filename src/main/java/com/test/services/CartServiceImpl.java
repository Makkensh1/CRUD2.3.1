package com.test.services;

import com.test.model.Cart;
import com.test.model.Order;
import com.test.repositories.CartRepository;
import com.test.repositories.OrderRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class CartServiceImpl implements CartService{


    CartRepository cartRepository;
    OrderRepository orderRepository;


    public CartServiceImpl( CartRepository cartRepository, OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void createOrderByCart(Cart cart) {
        if (cart.getCartOwner().getCash() >= cart.getCartCost()) {
            Cart cartInDB = cart;
            cartInDB.getCartOwner().setCash(cartInDB.getCartOwner().getCash() - cartInDB.getCartCost());
            cartInDB.setStatusPaid(true);
            cartRepository.save(cartInDB);
            Order order = new Order();
            order.setOrderOwner(cart.getCartOwner());
            order.setOrderCost(cart.getCartCost());
//            order.setProductList(cart.getProductList());
            orderRepository.save(order);
        }


    }
}
