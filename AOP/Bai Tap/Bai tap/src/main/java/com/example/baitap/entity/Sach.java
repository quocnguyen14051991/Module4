package com.example.baitap.entity;

import javax.persistence.*;

@Entity(name = "sachmuon")
public class Sach {
    //Math.floor(Math.random()*100000+1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_muon_sach")
    private Integer id;
    private String tenSach;
    private Integer soLuong;
    private Integer maMuon;

    public Sach() {
    }

    public Sach(Integer id, String tenSach, Integer soLuong, Integer maMuon) {
        this.id = id;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.maMuon = maMuon;
    }

    public Integer getId() {
        return id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public Integer getMaMuon() {
        return maMuon;
    }
}
