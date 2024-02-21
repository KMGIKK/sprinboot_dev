package com.example.demo.repo;

import com.example.demo.entity.Item;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:40 AM
 * @since : 2/12/2024
 **/
@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);

    List<Item> findAllByActiveStateEquals(boolean activeStatus);

    Page<Item> findAllByActiveStateEquals(boolean activeStatus, Pageable pageable);


    int countAllByActiveStateEquals(boolean activeStatus);
}
