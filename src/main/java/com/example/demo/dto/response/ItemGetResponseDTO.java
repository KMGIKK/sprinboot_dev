package com.example.demo.dto.response;

import com.example.demo.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:28 PM
 * @since : 2/12/2024
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
}
