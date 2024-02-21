package com.example.demo.service;

import com.example.demo.dto.paginated.PaginatedResponseOrderDetails;
import com.example.demo.dto.request.RequestOrderSaveDTO;

/**
 * @author : K.M.G.I.K.konara
 * @Time :7:04 PM
 * @since : 2/21/2024
 **/
public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size);
}
