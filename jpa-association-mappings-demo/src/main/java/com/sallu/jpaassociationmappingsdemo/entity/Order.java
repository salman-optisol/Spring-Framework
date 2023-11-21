package com.sallu.jpaassociationmappingsdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String orderName;

//    Uni directional mapping with @OneToMany
//    @OneToMany(fetch = FetchType.EAGER) // if not wil show error when printing Order object
//    @JoinColumn(name = "order_id")
//    private List<OrderItem> items;

    @OneToMany(mappedBy = "order")  // order owns the mapping
    private List<OrderItem> items;

    public void addOrderItem(OrderItem item) {
        if(items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", items=" + items +
                '}';
    }
}
