package de.econda.client.service.impl;

import de.econda.client.model.ProductVisitor;
import de.econda.client.repository.ProductVisitorRepository;
import de.econda.client.service.SuggestionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private static final HashMap serviceProviderCallUpCount = new HashMap();

    private static final Long defaultId = 1L;
    private static final String defaultName = "donut";
    private static final String defaultCategory = "food";

    private final ProductVisitorRepository productVisitorRepository;


    @Value("${suggestion.provider.url}")
    private String suggestionProviderUrl;

    public SuggestionServiceImpl(ProductVisitorRepository productVisitorRepository) {
        this.productVisitorRepository = productVisitorRepository;
    }

    @Override
    public ResponseEntity<?> suggestion(Long id, String name, String category) {
        RestTemplate restTemplate = new RestTemplate();


        id = (id != null) ? id : defaultId;
        name = isNotEmpty(name) ? name : defaultName;
        category = isNotEmpty(category) ? name : defaultCategory;


        String suggestionProviderUrlProperty = suggestionProviderUrl + "/" + id + "/" + name + "/" + category;
        ResponseEntity<String> response
                = restTemplate.getForEntity(suggestionProviderUrlProperty, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            serviceProviderCallUpCount.put(serviceProviderCallUpCount.size() + 1, response);
        }
        return response;
    }

    @Override
    public List<ProductVisitor> getProducts(Long visitorId) {

        return productVisitorRepository.getProductVisitors()
                .stream()
                .filter(p -> p.getVisitor().getId().equals(visitorId))
                .toList();
    }

}
