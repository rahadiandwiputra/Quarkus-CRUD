package org.acme.commandmode.Service;

import org.acme.commandmode.model.matkulModel;
import org.acme.commandmode.repository.matkulRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class matkulService {

    @Inject
    matkulRepository MatkulRepository;

    public List<matkulModel> getMatkul() {
        return MatkulRepository.listAll();
    }

    @Transactional
    public void addMatkul(matkulModel MatkulModel) {
        MatkulRepository.persist(MatkulModel);
    }

    @Transactional
    public void deleteMatkul(Long kd_matkul) {
        MatkulRepository.deleteById(kd_matkul);
    }


}
