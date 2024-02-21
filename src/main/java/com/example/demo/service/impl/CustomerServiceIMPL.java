package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.request.CustomerUpdateDTO;
import com.example.demo.entity.Customer;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:14 PM
 * @since : 1/24/2024
 **/
@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer=new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()

        );
        customerRepo.save(customer);
        return null;
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer=customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customer.getCustomerSalary());

            customerRepo.save(customer);

        }else {
            throw new RuntimeException("no found data for that id");
        }
        return customerUpdateDTO.getCustomerName()+" updated successfull";
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer=customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO =new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()

            );
            return customerDTO;
        }else {
           throw  new RuntimeException("No customer");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
       if (getAllCustomers.size()>0){
           List<CustomerDTO> customerDTOList = new ArrayList<>();

           for(Customer customer: getAllCustomers){
               CustomerDTO customerDTO = new CustomerDTO(
                       customer.getCustomerId(),
                       customer.getCustomerName(),
                       customer.getCustomerAddress(),
                       customer.getCustomerSalary(),
                       customer.getContactNumber(),
                       customer.getNic(),
                       customer.isActive()
               );
               customerDTOList.add(customerDTO);
           }
           return customerDTOList;
       }
       else {
           throw new NotFoundException("No Customer Found");
       }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Deleted Successfully " +customerId;
        }else {
            throw new RuntimeException("No Customer Found In That Id");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {

        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer: getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}

