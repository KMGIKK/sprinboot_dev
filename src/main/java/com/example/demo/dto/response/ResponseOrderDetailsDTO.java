package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:22 AM
 * @since : 2/22/2024
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDTO {
    private String customerName;

    private String customerAddress;

    private ArrayList contactNumber;

    private Date date;

    private Double total;
}
