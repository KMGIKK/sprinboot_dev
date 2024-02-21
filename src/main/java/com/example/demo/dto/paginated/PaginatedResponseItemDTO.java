package com.example.demo.dto.paginated;

import com.example.demo.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:59 AM
 * @since : 2/21/2024
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    List<ItemGetResponseDTO> list;
    private long dataCount;
}
