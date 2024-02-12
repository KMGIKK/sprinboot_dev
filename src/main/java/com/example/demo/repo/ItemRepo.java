package com.example.demo.repo;

import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:40 AM
 * @since : 2/12/2024
 **/
@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
}
