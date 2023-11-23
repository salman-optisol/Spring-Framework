package com.sallu.jpaassociationmappingsdemo;

import com.sallu.jpaassociationmappingsdemo.entity.Store;
import com.sallu.jpaassociationmappingsdemo.repository.ProductStoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductStoreCLR implements CommandLineRunner {

    ProductStoreRepository repo;

    public ProductStoreCLR(ProductStoreRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
//        repo.createProduct();
//        repo.createStore();
//        repo.mapProductAndStore(1, 1);
        Store store = new Store();
        store.setStoreId(1);
        repo.changeStoreName(store);
    }
}
