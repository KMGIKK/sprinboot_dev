package com.example.demo.service.impl;

import com.example.demo.dto.request.ItemSaveRequestDTO;
import com.example.demo.dto.response.ItemGetResponseDTO;
import com.example.demo.entity.Item;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.ItemRepo;
import com.example.demo.service.ItemService;
import com.example.demo.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private ItemMapper itemMapper;

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

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean b=true;
        List<Item> items= itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);
        if(items.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOS=modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item is not active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapStruct(String itemName) {
        boolean b=true;
        List<Item> items= itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);
        if(items.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOS=itemMapper.entityListToDtoList(items);
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item is not active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByActiveStatus(boolean activeStatus) {
        List<Item> items=itemRepo.findAllByActiveStateEquals(activeStatus);
        if(items.size()>0){
            List<ItemGetResponseDTO> itemGetResponseDTOS=itemMapper.entityListToDtoList(items);
            return itemGetResponseDTOS;
        }else{
            throw new NotFoundException("Item is Not Active");
        }
    }
}
