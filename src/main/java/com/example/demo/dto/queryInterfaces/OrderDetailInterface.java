package com.example.demo.dto.queryInterfaces;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:12 AM
 * @since : 2/22/2024
 **/
public interface OrderDetailInterface {
     String getCustomerName();

     String getCustomerAddress();

     ArrayList getContactNumber();

     Date getDate();

     Double getTotal();
}
