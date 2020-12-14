package org.acme.commandmode.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.commandmode.model.matkulModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class matkulRepository implements PanacheRepository<matkulModel> {

}
