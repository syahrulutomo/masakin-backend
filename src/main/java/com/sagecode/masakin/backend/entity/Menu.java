package com.sagecode.masakin.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Menu {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(name = "nama_menu",nullable = false )
    private String namaMenu;
    
    @Column(nullable = false)
    private String jenis;
    
    @Column(nullable = false)
    private Integer harga;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_restaurant",nullable = false)
    private Restaurant restaurant;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "menu")
    private List<Pesanan> daftarPesanan;

    private String foto;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    public void setDaftarPesanan(List<Pesanan> daftarPesanan) {
        this.daftarPesanan = daftarPesanan;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
}
