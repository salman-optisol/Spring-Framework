package com.sallu.jpaassociationmappingsdemo;

import com.sallu.jpaassociationmappingsdemo.repository.ItemOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemOrderCLR implements CommandLineRunner {

    ItemOrderRepository repo;
    @Autowired
    public ItemOrderCLR(ItemOrderRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {

//        repo.createOrder();
//        repo.createOrderItem();
//        repo.readOrder();
//        repo.readOrderItem();
//        repo.updateOrder();
//        repo.updateOrderItem();
//        repo.deleteOrderItem();
//        repo.deleteOrder();

    }
}
















