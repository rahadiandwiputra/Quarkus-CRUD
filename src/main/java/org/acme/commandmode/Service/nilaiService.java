package org.acme.commandmode.Service;

import org.acme.commandmode.model.nilaiModel;
import org.acme.commandmode.repository.nilaiRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class nilaiService {

    @Inject
    nilaiRepository NilaiRepository;

    public List<nilaiModel> getNilai() {
        return NilaiRepository.listAll();
    }

    @Transactional
    public void addNilai(nilaiModel NilaiModel) {
        NilaiRepository.persist(NilaiModel);
    }

    @Transactional
    public void deleteNilai(Long id) {
        NilaiRepository.deleteById(id);
    }
}
