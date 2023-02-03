package com.himal.malla.himal.Service;

import com.himal.malla.himal.Enity.Order;
import com.himal.malla.himal.Enity.Product;
import com.himal.malla.himal.Enity.User;

import java.util.List;

public interface OrderService {

    public Order save(Order order);

    public List<Order> saveAll(List<Order> orderList);

    public List<Order> getOrders();

    public Order getOrderById(Long orderId) ;

    public Order updateOrder(Order order) ;

    public String deleteOrder(Long orderId) ;

    public Order createOrder(Order order) ;


}
