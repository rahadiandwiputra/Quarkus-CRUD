package org.acme.commandmode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "prodi")
public class prodiModel extends PanacheEntityBase {
    @Id
    @Column(name = "kd_prodi")
    private Long kd_prodi;
    private String nama_prodi;

    @JsonIgnore
    @OneToMany(mappedBy = "ProdiModel", orphanRemoval = true)
    private Set<mahasiswaModel> MahasiswaModel;

    public prodiModel() {

    }

    public prodiModel(Long kd_prodi, String nama_prodi) {
        this.kd_prodi = kd_prodi;
        this.nama_prodi = nama_prodi;
    }

    public Long getKd_prodi() {
        return kd_prodi;
    }

    public void setKd_prodi(Long kd_prodi) {
        this.kd_prodi = kd_prodi;
    }

    public String getNama_prodi() {
        return nama_prodi;
    }

    public void setNama_prodi(String nama_prodi) {
        this.nama_prodi = nama_prodi;
    }
}
