package com.example.demo.dto.paginated;

import com.example.demo.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :8:18 PM
 * @since : 2/21/2024
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetails {
private List<ResponseOrderDetailsDTO> list;
private long dataCount;
}
