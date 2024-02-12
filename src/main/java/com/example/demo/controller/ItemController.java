package com.example.demo.controller;

import com.example.demo.dto.request.ItemSaveRequestDTO;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
