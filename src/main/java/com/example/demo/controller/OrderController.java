package com.example.demo.controller;

import com.example.demo.dto.request.RequestOrderSaveDTO;
import com.example.demo.util.StandardResponse;
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


    @PostMapping(path="/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        System.out.println(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"itemsave successfully",2),
                HttpStatus.CREATED);
    }
}
