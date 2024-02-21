package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

/**
 * @author : K.M.G.I.K.konara
 * @Time :3:31 PM
 * @since : 2/21/2024
 **/
@Entity
@Table(name="order_details")
@TypeDefs(
        {
                @TypeDef(name="json", typeClass = JsonType.class)
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {
    @Id
    @Column(name="order_details_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name="item_name",length=100,nullable = false)
    private String itemName;

    @Column(name="qty",length=100,nullable = false)
    private Double qty;

    @Column(name="amount",nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item items;

}
