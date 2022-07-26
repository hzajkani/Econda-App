package de.econda.client.api;

import de.econda.client.service.impl.SuggestionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientApi {

    private final SuggestionServiceImpl suggestionServiceImpl;

    public ClientApi(SuggestionServiceImpl suggestionServiceImpl) {
        this.suggestionServiceImpl = suggestionServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<?> suggestion() {
        ResponseEntity<?> response = suggestionServiceImpl.suggestion();
        return response;
    }
}
