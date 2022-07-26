package de.econda.client.service;

import org.springframework.http.ResponseEntity;

public interface SuggestionService {

    ResponseEntity<?> suggestion();

    void getVisitor();
}
