package de.econda.client.service;

import de.econda.client.model.ProductVisitor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SuggestionServiceTest {

    private static final Long DEFAULT_ID = 1L;
    private static final String DEFAULT_NAME = "donut";
    private static final String DEFAULT_CATEGORY = "food";

    @Autowired
    private SuggestionService suggestionService;

    @Test
    void suggestion() {
        ResponseEntity<?> response = suggestionService.suggestion(DEFAULT_ID, DEFAULT_NAME, DEFAULT_CATEGORY);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void getProducts() {
        List<ProductVisitor> productVisitors = suggestionService.getProducts(1L);
        assertEquals(productVisitors.get(0).getProduct().getId(), 1L);

    }

}