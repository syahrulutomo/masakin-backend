package com.sagecode.masakin.backend.dao;


import com.sagecode.masakin.backend.entity.Menu;
import com.sagecode.masakin.backend.entity.Pesanan;
import com.sagecode.masakin.backend.entity.Restaurant;
import com.sagecode.masakin.backend.entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PesananDao extends PagingAndSortingRepository<Pesanan, String>{
     
    public Page<Pesanan> findByUser(User u, Pageable page);
 
    String queryGetPesananByUser = "select p from Pesanan p inner join p.user ";
    
    @Query(queryGetPesananByUser)
    List<Pesanan> getPesananByUser(User u, Pageable page);
     
}
