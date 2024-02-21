package com.example.demo.dto.request;

import com.example.demo.entity.Item;
import com.example.demo.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author : K.M.G.I.K.konara
 * @Time :6:29 PM
 * @since : 2/21/2024
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSave {

    private String itemName;

    private Double qty;

    private Double amount;

    //private int orders;

    private int items;
}
