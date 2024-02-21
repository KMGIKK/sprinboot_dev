package com.example.demo.repo;

import com.example.demo.dto.queryInterfaces.OrderDetailInterface;
import com.example.demo.dto.response.ResponseOrderDetailsDTO;
import com.example.demo.entity.Orders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :7:06 PM
 * @since : 2/21/2024
 **/
@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Orders,Integer> {
    @Query(value = "select c.customer_name as customerName,c.customer_address as customerAddress,c.customer_numbers as contactNumber,o.order_date as date,o.total as total from customer c,orders o where o.active_state=?1 and c.customer_id=o.customer_id",nativeQuery = true)
    List<OrderDetailInterface> getAllOrderDetails(boolean status, Pageable pageable);

    @Query(value= "select count(*) from customer c, orders o where o.active_state =?1 and c.customer_id=o.customer_id",nativeQuery = true)
    long countAllOrderDetails(boolean status);
}
