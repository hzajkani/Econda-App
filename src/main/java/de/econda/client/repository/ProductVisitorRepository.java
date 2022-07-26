package de.econda.client.repository;

import de.econda.client.model.Product;
import de.econda.client.model.ProductVisitor;
import de.econda.client.model.Visitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductVisitorRepository {


    private static final List<ProductVisitor> productVisitors = new ArrayList<>();

    public ProductVisitorRepository() {
        init();
    }

    private void init() {
        productVisitors
                .add(new ProductVisitor(1L,
                        Product.builder()
                                .id(1L)
                                .name("donut1")
                                .category("food")
                                .build(),
                        new Visitor(1L, "peter")));

        productVisitors
                .add(new ProductVisitor(2L,
                        Product.builder()
                                .id(2L)
                                .name("donut2")
                                .category("food2")
                                .build(),
                        new Visitor(2L, "sara")));
    }

    public List<ProductVisitor> getProductVisitors() {
        return productVisitors;
    }

}
