package com.himal.malla.himal.Controler;

import com.himal.malla.himal.Enity.Order;

import com.himal.malla.himal.ServiceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServices;

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){
        return orderServices.save(order);
     }

     @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderServices.createOrder(order);
     }

    @PostMapping("/saveAll")
    public List<Order> saveAll(@RequestBody List<Order> orderList){
        return orderServices.saveAll(orderList);
    }

    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        return orderServices.getOrders();
    }
    @GetMapping("/findGross")
    public String findGross(){
        return orderServices.getGrossSales();
    }

    @GetMapping("/findGrossByQuery")
    public double findGrossByQuery(){
        return orderServices.getGrossByQuery();
    }

    @GetMapping("/orderId/{orderId}")
    public Order findOrderById(@PathVariable int orderId){
        return orderServices.getOrderById(orderId);
    }

    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order){
        return orderServices.updateOrder(order);
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable int orderId){
        return orderServices.deleteOrder(orderId);
    }
}
