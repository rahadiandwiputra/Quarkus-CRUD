package org.acme.commandmode.Service;

import org.acme.commandmode.model.prodiModel;
import org.acme.commandmode.repository.prodiRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class prodiService {

    @Inject
    prodiRepository ProdiRepository;

    public List<prodiModel> getProdi() {
        return ProdiRepository.listAll();
    }

    @Transactional
    public void addProdi(prodiModel ProdiModel) {
        ProdiRepository.persist(ProdiModel);
    }

    @Transactional
    public void deleteProdi(Long kd_prodi) {
        ProdiRepository.deleteById(kd_prodi);
    }
}
