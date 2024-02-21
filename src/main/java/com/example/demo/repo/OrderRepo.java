package com.example.demo.repo;

import com.example.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : K.M.G.I.K.konara
 * @Time :7:06 PM
 * @since : 2/21/2024
 **/
public interface OrderRepo extends JpaRepository<Orders,Integer> {
}
