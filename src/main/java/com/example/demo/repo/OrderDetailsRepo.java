package com.example.demo.repo;

import com.example.demo.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : K.M.G.I.K.konara
 * @Time :7:08 PM
 * @since : 2/21/2024
 **/
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,Integer> {
}
