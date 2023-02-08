package com.himal.malla.himal.Repository;

import com.himal.malla.himal.Enity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {




    @Query(value = "SELECT order_id from order_details order by order_id desc Limit 1", nativeQuery = true)
    public Optional<Integer> getLastOrderNumber();

    @Query(value = "Select SUM(price) as Total_Gross_Sales from order_details;", nativeQuery = true)
    public Optional<Double> getTotalGrossByQuery();

}
