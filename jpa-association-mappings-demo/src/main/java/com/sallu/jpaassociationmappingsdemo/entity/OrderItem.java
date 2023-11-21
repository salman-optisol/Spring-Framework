package com.sallu.jpaassociationmappingsdemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;

//    Uni directional @ManyToOne
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;

    @ManyToOne
    @JoinColumn(name = "order_id")  // just referencing the mapping
    private Order order;

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", Order =" + order +
                '}';
    }
}
