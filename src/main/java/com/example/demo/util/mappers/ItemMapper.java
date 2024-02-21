package com.example.demo.util.mappers;

import com.example.demo.dto.response.ItemGetResponseDTO;
import com.example.demo.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:23 PM
 * @since : 2/12/2024
 **/
@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);

    List<ItemGetResponseDTO> listDTOToPage(Page<Item> items);
}
