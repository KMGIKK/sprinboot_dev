package com.example.demo.service.impl;

import com.example.demo.dto.paginated.PaginatedResponseOrderDetails;
import com.example.demo.dto.queryInterfaces.OrderDetailInterface;
import com.example.demo.dto.request.RequestOrderSaveDTO;
import com.example.demo.dto.response.ResponseOrderDetailsDTO;
import com.example.demo.entity.OrderDetails;
import com.example.demo.entity.Orders;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.ItemRepo;
import com.example.demo.repo.OrderDetailsRepo;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



/**
 * @author : K.M.G.I.K.konara
 * @Time :7:05 PM
 * @since : 2/21/2024
 **/
@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Orders orders=new Orders(
          customerRepo.getById(requestOrderSaveDTO.getCustomer()),
          requestOrderSaveDTO.getDate(),
          requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(orders);
        if(orderRepo.existsById(orders.getOrderId())){
            List<OrderDetails> orderDetails=modelMapper.map(requestOrderSaveDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){}.getType());
            for (int i=0; i<orderDetails.size();i++){
                orderDetails.get(i).setOrders(orders);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));

            }
            if(orderDetails.size()>0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "saved";
        }
        return null;
    }

    @Override
    public PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size) {
        List<OrderDetailInterface> orderDetailsDTOS=orderRepo.getAllOrderDetails(status, PageRequest.of(page,size));
        List<ResponseOrderDetailsDTO> list =new ArrayList<>();
        for(OrderDetailInterface o: orderDetailsDTOS){
            ResponseOrderDetailsDTO r =new ResponseOrderDetailsDTO(
                    o.getCustomerName(),
                    o.getCustomerAddress(),
                    o.getContactNumber(),
                    o.getDate(),
                    o.getTotal()
            );
            list.add(r);
        }
        PaginatedResponseOrderDetails paginatedResponseOrderDetails=new PaginatedResponseOrderDetails(
                list,orderRepo.countAllOrderDetails(status));
        return paginatedResponseOrderDetails ;
    }
}
