package de.econda.client.repository;

import de.econda.client.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {


    private static final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        init();
    }

    private void init() {

        products.add(
                Product.builder()
                        .id(1L)
                        .name("donut1")
                        .category("food")
                        .build());

        products.add(
                Product.builder()
                        .id(2L)
                        .name("donut2")
                        .category("food2")
                        .build());
    }
}
