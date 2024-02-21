package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import springfox.documentation.spring.web.plugins.Docket;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author : K.M.G.I.K.konara
 * @Time :1:25 PM
 * @since : 2/21/2024
 **/
@Entity
@Table(name="orders")
@TypeDefs(
        {
                @TypeDef(name="json", typeClass = JsonType.class)
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @Column(name="order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable=false)
    private Customer customer;

    @Column(name="order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name="total",nullable = false)
    private Double total;

    @Column(name="active_state",columnDefinition = "TINYINT default 0")
    private boolean active;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetails;

    public Orders(Customer customer,Date date,Double total){
        this.customer=customer;
        this.date=date;
        this.total=total;
    }
}
