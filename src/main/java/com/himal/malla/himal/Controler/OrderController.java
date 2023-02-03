package com.himal.malla.himal.Controler;

import com.himal.malla.himal.Enity.Order;
import com.himal.malla.himal.ServiceImpl.OrderService;
import com.himal.malla.himal.ServiceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){
        return orderService.save(order);
     }

     @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
     }

    @PostMapping("/saveAll")
    public List<Order> saveAll(@RequestBody List<Order> orderList){
        return orderService.saveAll(orderList);
    }

    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/orderId/{orderId}")
    public Order findOrderById(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable Long orderId){
        return orderService.deleteOrder(orderId);
    }
}
