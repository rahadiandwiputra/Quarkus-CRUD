package org.acme.commandmode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.vertx.reactivex.sqlclient.Row;

import javax.persistence.*;


@Entity
@Table(name = "mahasiswa")
public class mahasiswaModel extends PanacheEntityBase {

    @Id
    @Column(name = "nim")
    private Long nim;
    private String nama;
    private String kelas;
    private int semester;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kd_prodi")
    private prodiModel ProdiModel;

    public mahasiswaModel(){

    }

    public mahasiswaModel(Long nim, String nama, String kelas, int semester, prodiModel ProdiModel) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.semester = semester;
        this.ProdiModel = ProdiModel;
    }

    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public prodiModel getProdiModel() {
        return ProdiModel;
    }

    public void setProdiModel(prodiModel ProdiModel) {
        this.ProdiModel = ProdiModel;
    }

}
