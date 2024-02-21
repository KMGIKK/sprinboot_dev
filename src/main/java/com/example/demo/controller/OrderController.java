package com.example.demo.controller;

import com.example.demo.dto.request.RequestOrderSaveDTO;
import com.example.demo.service.OrderService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : K.M.G.I.K.konara
 * @Time :6:38 PM
 * @since : 2/21/2024
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping(path="/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String id=orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+"itemsave successfully",id),
                HttpStatus.CREATED);
    }
}
