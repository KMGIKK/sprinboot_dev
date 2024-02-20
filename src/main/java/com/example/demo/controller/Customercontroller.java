package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.request.CustomerUpdateDTO;
import com.example.demo.service.CustomerService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:07 PM
 * @since : 1/24/2024
 **/
@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class Customercontroller {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
//        String message= customerDTO.getCustomerAddress();
//        System.out.println("come"+message);
        return "saveddddddddd";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
       String message=  customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

    @GetMapping(path="/get-by-id",
                params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customer_id) {
        CustomerDTO customerDTO= customerService.getCustomerById(customer_id);
        return customerDTO;
    }

    @GetMapping(path ="get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allCustomers), HttpStatus.OK
        );
    }

    @DeleteMapping(path="delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted= customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping(path ="get-all-customers-by-active-state/{status}")
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState){
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }
}
