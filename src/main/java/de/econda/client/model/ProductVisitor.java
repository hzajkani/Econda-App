package de.econda.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVisitor {

    private Long id;
    private Product product;
    private Visitor visitor;

    public ProductVisitor getProduct(Long visitorId) {

        if (Objects.equals(this.visitor.getId(), visitorId)) {
            return this;
        } else {
            return null;
        }
    }

}
