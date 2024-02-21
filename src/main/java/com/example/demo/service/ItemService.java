package com.example.demo.service;

import com.example.demo.dto.request.ItemSaveRequestDTO;
import com.example.demo.dto.response.ItemGetResponseDTO;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:38 AM
 * @since : 2/12/2024
 **/
public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapStruct(String itemName);

    List<ItemGetResponseDTO> getItemByActiveStatus(boolean activeStatus);
}
