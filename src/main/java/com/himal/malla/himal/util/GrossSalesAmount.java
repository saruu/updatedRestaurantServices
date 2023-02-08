package com.himal.malla.himal.util;

import com.himal.malla.himal.Enity.Order;

import java.util.List;

public class GrossSalesAmount {


    public double getTotalSales(List<Order> orders){

        double totalSales = 0;
        for(Order order:orders){
            totalSales += (order.getPrice());
        }
        return totalSales;
    }

}
