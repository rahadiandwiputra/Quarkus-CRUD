package org.acme.commandmode.repository;

import org.acme.commandmode.model.prodiModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class prodiRepository implements PanacheRepository<prodiModel> {

}
