package com.test.services;

import com.test.model.Cart;
import com.test.model.Order;
import com.test.repositories.CartRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    SessionFactory sessionFactory;
    CartRepository cartRepository;

    public CartServiceImpl(SessionFactory sessionFactory, CartRepository cartRepository) {
        this.sessionFactory = sessionFactory;
        this.cartRepository = cartRepository;
    }

    @Override
    public Order createOrderByCart(Cart cart) {
        if (cart.getCartOwner().getCash() >= cart.getCartCost()) {
            Cart cartInDB = cart;
            cartInDB.getCartOwner().setCash(cartInDB.getCartOwner().getCash() - cartInDB.getCartCost());
            cartInDB.setStatusPaid(true);
            cartRepository.save(cartInDB);
            Order order = new Order();
            order.setOrderOwner(cart.getCartOwner());
            order.setOrderCost(cart.getCartCost());
            order.setProductList(cart.getProductList());

        }

        return null;
    }
}
