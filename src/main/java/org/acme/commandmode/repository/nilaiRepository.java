package org.acme.commandmode.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.commandmode.model.nilaiModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class nilaiRepository implements PanacheRepository<nilaiModel> {
}
