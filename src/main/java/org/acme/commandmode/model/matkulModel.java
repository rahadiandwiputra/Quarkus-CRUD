package org.acme.commandmode.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matkul")
public class matkulModel {
    @Id
    private Long kd_matkul;
    private String nama_matkul;
    private int SKS;

    public matkulModel() {

    }

    public matkulModel(Long kd_matkul, String nama_matkul, int SKS) {
        this.kd_matkul = kd_matkul;
        this.nama_matkul = nama_matkul;
        this.SKS = SKS;
    }

    public Long getKd_matkul() {
        return kd_matkul;
    }

    public void setKd_matkul(Long kd_matkul) {
        this.kd_matkul = kd_matkul;
    }

    public String getNama_matkul() {
        return nama_matkul;
    }

    public void setNama_matkul(String nama_matkul) {
        this.nama_matkul = nama_matkul;
    }

    public int getSKS() {
        return SKS;
    }

    public void setSKS(int SKS) {
        this.SKS = SKS;
    }
}
