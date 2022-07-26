package de.econda.client.api;

import de.econda.client.model.ProductVisitor;
import de.econda.client.service.impl.SuggestionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientApi {

    private final SuggestionServiceImpl suggestionServiceImpl;

    public ClientApi(SuggestionServiceImpl suggestionServiceImpl) {
        this.suggestionServiceImpl = suggestionServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<?> suggestion() {
        Long id = 1L;
        String name = "donut";
        String category = "food";

        return suggestionServiceImpl.suggestion(id, name, category);
    }

    @GetMapping("/products/{visitorId}")
    List<ProductVisitor> getProducts(@PathVariable("visitorId") Long visitorId) {
        return suggestionServiceImpl.getProducts(visitorId);
    }
}
