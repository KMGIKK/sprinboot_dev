package com.example.demo.dto.request;

import com.example.demo.entity.Customer;
import com.example.demo.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author : K.M.G.I.K.konara
 * @Time :6:27 PM
 * @since : 2/21/2024
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customer;

    private Date date;

    private Double total;

    private List<RequestOrderDetailsSave> orderDetails;
}
