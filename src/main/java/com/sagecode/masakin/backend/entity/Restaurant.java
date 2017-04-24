package com.sagecode.masakin.backend.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(name = "nama_restaurant", nullable = false)
    private String namaRestaurant;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String alamat;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private List<Menu> daftarMenu = new ArrayList<>();

    @Column(name = "nomor_rekening_bank",nullable = false)
    private String nomorRekeningBank;
    
    private String foto;

    public String getNomorRekeningBank() {
        return nomorRekeningBank;
    }

    public void setNomorRekeningBank(String nomorRekeningBank) {
        this.nomorRekeningBank = nomorRekeningBank;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaRestaurant() {
        return namaRestaurant;
    }

    public void setNamaRestaurant(String namaRestaurant) {
        this.namaRestaurant = namaRestaurant;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Menu> getDaftarMenu() {
        return daftarMenu;
    }

    public void setDaftarMenu(List<Menu> daftarMenu) {
        this.daftarMenu = daftarMenu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
} 
