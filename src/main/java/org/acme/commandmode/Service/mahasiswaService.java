package org.acme.commandmode.Service;

import org.acme.commandmode.repository.mahasiswaRepository;
import org.acme.commandmode.model.mahasiswaModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class mahasiswaService {

    @Inject
    EntityManager entityManager;

    @Inject
    mahasiswaRepository MahasiswaRepository;

    public List<mahasiswaModel> getMahasiswa() {
        return MahasiswaRepository.listAll();
    }

    @Transactional
    public void addMahasiswa(mahasiswaModel MahasiswaModel) {
        MahasiswaRepository.persist(MahasiswaModel);
    }

    @Transactional
    public void deleteMahasiswa(Long nim) {
        MahasiswaRepository.deleteById(nim);
    }

    @Transactional
    public List<Object[]> groupBy(String kelas) {
        return entityManager.createNativeQuery("select nim, nama, kelas from mahasiswa where LOWER(kelas) like LOWER(:kelas) group by nim").setParameter("kelas",kelas).getResultList();
    }





//    @Transactional
//    public List<mahasiswaModel>group(mahasiswaModel MahasiswaModel){
//        return entityManager.createNativeQuery("select Count(nim), kelas from mahasiswa group by kelas").getResultList();
//    }



//    public static Multi<mahasiswaModel> findAll(PgPool client) {
//        return client.query("SELECT id, name FROM fruits ORDER BY name ASC").execute()
//                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
//                .onItem().transform(mahasiswaModel::from);
//    }

//    @Transactional
//    public List<Object[]> GrupBy(PgPool client){
//        return client.query("SELECT COUNT(nim), kelas FROM mahasiswa GROUP BY kelas").execute()
//                .onI
//    }



//    public void edit(Long nim){
//
//    }


//    public void deleteMahasiswa(Long nim){
//        data.remove(nim); ;
//    }
}
