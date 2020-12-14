package org.acme.commandmode.repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.commandmode.model.mahasiswaModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class mahasiswaRepository implements PanacheRepository<mahasiswaModel> {

}
