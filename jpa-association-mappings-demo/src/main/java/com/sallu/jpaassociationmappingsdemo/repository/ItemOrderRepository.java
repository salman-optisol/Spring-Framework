package com.sallu.jpaassociationmappingsdemo.repository;

import com.sallu.jpaassociationmappingsdemo.entity.Order;
import com.sallu.jpaassociationmappingsdemo.entity.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

@Repository
public class ItemOrderRepository {

    EntityManager em;

    public ItemOrderRepository(EntityManager em) {
        this.em = em;
    }

    /**
     *
     * This is example for Unidirectional @ManyToOne mapping
     *
     *
    @Transactional
    public void createOrder() {
        Order order = new Order();
        order.setOrderName("Sweets order");
        em.persist(order);
    }

    @Transactional
    public void createOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setItemName("Rasagulla");
        orderItem.setOrder(em.find(Order.class, 1));

        em.persist(orderItem);
    }

    public void readOrder() {
        System.out.println(em.find(Order.class, 1));
    }

    public void readOrderItem() {
        System.out.println(em.find(OrderItem.class, 1));
    }

    @Transactional
    public void updateOrder() {
        Order order = new Order();
        order.setOrderId(1);
        order.setOrderName("Festival sweets");
        em.merge(order); // not even persisting if the data is same as in db
    }

    @Transactional
    public void updateOrderItem() {
        OrderItem item = em.find(OrderItem.class, 1);
        item.setItemName("Gulab Jamun");
        em.merge(item);
    }

    @Transactional
    public void deleteOrder() {
        Order order = em.find(Order.class, 1);
        em.remove(order);
    }

    @Transactional
    public void deleteOrderItem() {
        OrderItem item = em.find(OrderItem.class, 1);
        em.remove(item);
    }

    */


    /**
     *
     * This is an example for Unidirectional @OneToMany
     *
    @Transactional
    public void createOrder() {
        Order order = new Order();
        order.setOrderName("Jangiri");
        em.persist(order);
    }

    @Transactional
    public void createOrderItem() {
        OrderItem item = new OrderItem();
        item.setItemName("Gulabjam");
        em.find(Order.class, 2).addOrderItem(item);
        em.persist(item);
    }

    public void readOrder() {
        System.out.println(em.find(Order.class, 2));
    }

    public void readOrderItem() {
        System.out.println(em.find(OrderItem.class, 3));
    }

    @Transactional
    public void updateOrder() {
        Order order = em.find(Order.class, 2);
        order.setOrderName("Diwali special");
        order.setItems(null);  // Remove the mapping from all the Order items
        em.merge(order);
    }

    @Transactional
    public void updateOrderItem() {
        OrderItem item = em.find(OrderItem.class, 3);
        item.setItemName("Halwa");
        em.merge(item);
    }

    @Transactional
    public void deleteOrder() {
        Order order = em.find(Order.class, 2);
        em.remove(order);
    }

    @Transactional
    public void deleteOrderItem() {
        OrderItem item = em.find(OrderItem.class, 3);
        em.remove(item);
    }
    */

    @Transactional
    public void createOrder() {
        Order order = new Order();
        order.setOrderName("Jangiri");
        em.persist(order);
    }

    @Transactional
    public void createOrderItem() {
        OrderItem item = new OrderItem();
        item.setItemName("Gulabjam");

        Order order = em.find(Order.class, 4);
        order.addOrderItem(item);
        item.setOrder(order);    // The mapping should be done to both the entities !!!

        em.persist(item);
    }

}





















