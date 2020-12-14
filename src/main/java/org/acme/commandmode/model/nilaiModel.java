package org.acme.commandmode.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nilai")
public class nilaiModel {
    @Id
    private Long id;
    private int latihan;
    private int tugas;
    private int UTS;
    private int UAS;

    public nilaiModel() {

    }

    public nilaiModel(Long id, int latihan, int tugas, int UTS, int UAS) {
        this.id = id;
        this.latihan = latihan;
        this.tugas = tugas;
        this.UTS = UTS;
        this.UAS = UAS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLatihan() {
        return latihan;
    }

    public void setLatihan(int latihan) {
        this.latihan = latihan;
    }

    public int getTugas() {
        return tugas;
    }

    public void setTugas(int tugas) {
        this.tugas = tugas;
    }

    public int getUTS() {
        return UTS;
    }

    public void setUTS(int UTS) {
        this.UTS = UTS;
    }

    public int getUAS() {
        return UAS;
    }

    public void setUAS(int UAS) {
        this.UAS = UAS;
    }
}
