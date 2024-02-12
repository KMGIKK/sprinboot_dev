package com.example.demo.service.impl;

import com.example.demo.dto.request.ItemSaveRequestDTO;
import com.example.demo.entity.Item;
import com.example.demo.repo.ItemRepo;
import com.example.demo.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:39 AM
 * @since : 2/12/2024
 **/
@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item=new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//        itemSaveRequestDTO.getSupplierPrice(),
//        itemSaveRequestDTO.getSellingPrice(),
//        true);
//        itemRepo.save(item);
//        return item.getItemName();

        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemName()+" save successfully";
        }else{
            throw new DuplicateKeyException("Already added");
        }

    }
}
