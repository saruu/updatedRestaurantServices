package com.himal.malla.himal.ServiceImpl;

import com.himal.malla.himal.Enity.Order;
import com.himal.malla.himal.Enity.Product;
import com.himal.malla.himal.Enity.User;
import com.himal.malla.himal.Repository.OrderRepo;
import com.himal.malla.himal.Repository.ProductRepo;
import com.himal.malla.himal.Repository.UserRepo;
import com.himal.malla.himal.Service.OrderService;
import com.himal.malla.himal.util.GrossSalesAmount;
import com.himal.malla.himal.util.InvoiceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
    public Order getOrderById(int orderId) {
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
    public String deleteOrder(int orderId) {
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
                order.setTotalAmount(Math.round(amount*100)/100.0);

                if(amount>100){
                    amount -= (float) (5.0/100.0) * amount ;
                    order.setDiscountedAmount(Math.round((float) (5.0/100.0) * amount *100)/100.0);
                }
//                else{order.setDiscountedAmount(0);}
                order.setPrice(Math.round(amount*100)/100.0);


                int orderNumber = orderRepo.getLastOrderNumber().get();


                InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

                order.setInvoiceNum(invoiceGenerator.getInvoiceNumber(product.getName(),orderNumber));

            }
        }
        return  orderRepo.save(order);

    }

    @Override
    public String getGrossSales() {

        List<Order> orders = orderRepo.findAll();
        double totalSales = orders.stream().mapToDouble(order -> order.getPrice()).sum();

//        GrossSalesAmount salesAmount = new GrossSalesAmount();
        StringBuffer buffer = new StringBuffer();
        buffer.append("Total Gross Sales = ").append(totalSales);//salesAmount.getTotalSales(orders));
        return buffer.toString();
    }

    @Override
    public double getGrossByQuery(){
        return orderRepo.getTotalGrossByQuery().get();
    }

}











//productName_today's date_01etc
//check last invoice number

//                int orderNumber = 11;


//                if (orderId.isEmpty()){
//                    System.out.println("Hello "+order.getOrderId());
//                    orderId = Optional.of(order.getOrderId()+1);
//                    order.setOrderId(orderId.get());
//                }
//                else {
//                    order.setOrderId(orderId.get()+1);
//                }

//                int orderNum = orderId.get();
//                System.out.println("Hello Saru "+ orderNum);
////                 Optional<Integer> orderNumber = orderRepo.getLastOrderNumber();
//                if(orderId.isPresent()) {
//                    orderNumber = orderId.get();
//                }

//System.out.println("Hello Sarala "+orderNumber);
//        System.out.println("Hi again"+ order.getOrderId());

