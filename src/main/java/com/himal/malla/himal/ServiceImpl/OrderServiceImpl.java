package com.himal.malla.himal.ServiceImpl;

import com.himal.malla.himal.Enity.Order;
import com.himal.malla.himal.Enity.Product;
import com.himal.malla.himal.Enity.User;
import com.himal.malla.himal.Repository.OrderRepo;
import com.himal.malla.himal.Repository.ProductRepo;
import com.himal.malla.himal.Repository.UserRepo;
import com.himal.malla.himal.Service.OrderService;
import com.himal.malla.himal.util.InvoiceGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Order save(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public List<Order> saveAll(List<Order> orderList) {
        return orderRepo.saveAll(orderList);
    }
    @Override
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }
    @Override
    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }
    @Override
    public Order updateOrder(Order order) {
        Order existingOrder = orderRepo.findById(order.getOrderId()).orElse(null);
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setUser(order.getUser());
        return orderRepo.save(existingOrder);
    }
    @Override
    public String deleteOrder(Long orderId) {
        orderRepo.deleteById(orderId);
        return "Order has been removed " + orderId ;
    }
    @Override
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
                //productName_today's date_01etc
                //check last invoice number
                int orderId = orderRepo.getLastOrderNumber();
                InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

                order.setInvoiceNum(invoiceGenerator.getInvoiceNumber(product.getName(),orderId));

            }
        }
        return  orderRepo.save(order);


    }



}
