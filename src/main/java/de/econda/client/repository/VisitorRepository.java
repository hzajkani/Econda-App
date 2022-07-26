package de.econda.client.repository;

import de.econda.client.model.Visitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VisitorRepository {

    private static final List<Visitor> visitors = new ArrayList<>();

    public VisitorRepository() {
        init();
    }

    private void init() {
        visitors.add(new Visitor(1L, "peter"));
        visitors.add(new Visitor(2L, "sara"));
    }

}
