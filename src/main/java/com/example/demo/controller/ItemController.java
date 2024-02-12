package com.example.demo.controller;

import com.example.demo.dto.request.ItemSaveRequestDTO;
import com.example.demo.dto.response.ItemGetResponseDTO;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message= itemService.saveItem(itemSaveRequestDTO);
        return "saved";
    }

    @GetMapping(path="/get-by-name",
    params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value="name") String itemName){
        List<ItemGetResponseDTO> itemDTOS =itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }
}
