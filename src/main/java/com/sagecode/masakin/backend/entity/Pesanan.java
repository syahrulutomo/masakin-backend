package com.sagecode.masakin.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pesanan {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user",nullable= false)
    private User user ;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_menu",nullable = false)
    private Menu menu;
          
    @Column(nullable = false)
    private String alamat;
    
    @Column(name = "tgl_pesan", nullable= false)    
    @Temporal(TemporalType.DATE)
    private Date tglPesan;
    
    @Column(name = "jumlah_pesan")
    private Integer jumlahPesanan;
    
    @Column(name = "total_bayar", nullable= false)
    private Integer totalBayar;
    
    @Column(name = "status_bayar", nullable= false)
    private String statusBayar;
    
    @Column(name = "status_delivery", nullable= false)
    private String statusDelivery;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTglPesan() {
        return tglPesan;
    }

    public void setTglPesan(Date tglPesan) {
        this.tglPesan = tglPesan;
    }

    public Integer getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(Integer totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(String statusBayar) {
        this.statusBayar = statusBayar;
    }

    public String getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(String statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public Integer getJumlahPesan() {
        return jumlahPesanan;
    }

    public void setJumlahPesan(Integer jumlahPesan) {
        this.jumlahPesanan = jumlahPesan;
    }
    
    
}
