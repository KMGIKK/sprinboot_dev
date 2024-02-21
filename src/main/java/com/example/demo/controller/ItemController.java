package com.example.demo.controller;

import com.example.demo.dto.request.ItemSaveRequestDTO;
import com.example.demo.dto.response.ItemGetResponseDTO;
import com.example.demo.service.ItemService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:36 AM
 * @since : 2/12/2024
 **/
@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
@Autowired
    private ItemService itemService;

    @PostMapping(path={"/save"})
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message= itemService.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path="/get-by-name",
    params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value="name") String itemName){
        List<ItemGetResponseDTO> itemDTOS =itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }

    @GetMapping(path="/get-by-name-with-mapstruct",
            params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapStruct(@RequestParam(value="name") String itemName){
        List<ItemGetResponseDTO> itemDTOS =itemService.getItemByNameAndStatusByMapStruct(itemName);
        return itemDTOS;
    }
    @GetMapping(
            path="/get-all-item-by-status",
            params="activeStatus"
    )
    public ResponseEntity<StandardResponse> getItemsByActiveStatus(@RequestParam(value="activeStatus") boolean activeStatus){
        List<ItemGetResponseDTO> itemDTOS=itemService.getItemByActiveStatus(activeStatus);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",itemDTOS),
                HttpStatus.OK
                );
    }
}
