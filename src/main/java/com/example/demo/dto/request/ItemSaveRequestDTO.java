package com.example.demo.dto.request;

import com.example.demo.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:43 AM
 * @since : 2/12/2024
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;

}
