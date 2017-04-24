package com.sagecode.masakin.backend.dao;

import com.sagecode.masakin.backend.entity.Menu;
import com.sagecode.masakin.backend.entity.Pesanan;
import com.sagecode.masakin.backend.entity.Restaurant;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuDao extends PagingAndSortingRepository<Menu, String>{
    
    Page<Menu> findByRestaurant(Restaurant r, Pageable page); 
    Page<Menu> findByDaftarPesanan(Pesanan p, Pageable page); 
   
    @Query("select m from Menu m where m.jenis ='Makanan'")
    Page<Menu> findByJenisMakanan(Pageable p);
    
    @Query("select m from Menu m where m.jenis ='Minuman'")
    Page<Menu> findByJenisMinuman(Pageable p);

        String queryGetByIdRestaurant = "select m from Menu m left join m.restaurant";
        String queryFindByPesanan = "select m from Menu m left join m.daftarPesanan ";  
        
        @Query(queryGetByIdRestaurant)
        List<Menu> getMenuByRestaurant();
        
        @Query(queryFindByPesanan)
        List<Menu> getMenuByPesanan();
        
       
}
