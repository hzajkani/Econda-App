package de.econda.client.service;

import de.econda.client.model.ProductVisitor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SuggestionService {


    ResponseEntity<?> suggestion(Long id, String name, String category);

    List<ProductVisitor> getProducts(Long visitorId);
}
