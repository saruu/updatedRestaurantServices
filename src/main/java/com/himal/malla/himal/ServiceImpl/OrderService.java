package com.himal.malla.himal.ServiceImpl;

import com.himal.malla.himal.Enity.Order;
import com.himal.malla.himal.Enity.Product;
import com.himal.malla.himal.Enity.User;
import com.himal.malla.himal.Repository.OrderRepo;
import com.himal.malla.himal.Repository.ProductRepo;
import com.himal.malla.himal.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    public Order save(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> saveAll(List<Order> orderList) {
        return orderRepo.saveAll(orderList);
    }

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }

    public Order updateOrder(Order order) {
        Order existingOrder = orderRepo.findById(order.getOrderId()).orElse(null);
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setUser(order.getUser());
        return orderRepo.save(existingOrder);
    }

    public String deleteOrder(Long orderId) {
        orderRepo.deleteById(orderId);
        return "Order has been removed " + orderId ;
    }

    public Order createOrder(Order order) {
        User user = userRepo.findById(order.getUser().getUserId()).get();
        if( user != null){
            Product product = productRepo.findById(order.getProduct().getProductId()).get();

            if (product != null){
                double amount = product.getPrice()*order.getQuantity();

                if(amount>100){
                    amount -= (float) (5.0/100.0) * amount ;
                }
                order.setPrice(amount);
            }
        }
    return  orderRepo.save(order);


    }

}
