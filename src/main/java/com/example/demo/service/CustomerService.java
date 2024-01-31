package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.request.CustomerUpdateDTO;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:13 PM
 * @since : 1/24/2024
 **/
public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
