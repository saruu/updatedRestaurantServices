package com.himal.malla.himal.Repository;

import com.himal.malla.himal.Enity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {




    @Query(value = "SELECT order_id from order_details order by order_id desc Limit 1", nativeQuery = true)
    public int getLastOrderNumber();
}
