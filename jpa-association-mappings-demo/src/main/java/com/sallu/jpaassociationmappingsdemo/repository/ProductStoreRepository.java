package com.sallu.jpaassociationmappingsdemo.repository;

import com.sallu.jpaassociationmappingsdemo.entity.Product;
import com.sallu.jpaassociationmappingsdemo.entity.Store;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductStoreRepository {
    EntityManager em;

    public ProductStoreRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void createStore() {
        Store store = new Store();
        store.setStoreName("Reliance mall");
        em.persist(store);
    }

    @Transactional
    public void createProduct() {
        Product product = new Product();
        product.setProductName("Bread");
        em.persist(product);
    }

    @Transactional
    public void mapProductAndStore(int productId, int storeId) {
        Product product = em.find(Product.class, productId);
        Store store = em.find(Store.class, storeId);

        store.getProducts().add(product);
        product.getStores().add(store);

    }

    @Transactional
    public void changeStoreName(Store store) {
        store = em.find(Store.class, store.getStoreId());
        store.setStoreName("Forum mall");
    }
}
