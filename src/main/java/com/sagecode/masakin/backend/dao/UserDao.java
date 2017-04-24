package com.sagecode.masakin.backend.dao;

import com.sagecode.masakin.backend.entity.Pesanan;
import com.sagecode.masakin.backend.entity.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends PagingAndSortingRepository<User, String>{
    
    @Query("select u from User u where u.email = :email and password = :password ")
    User findByEmailByPassword(@Param("email") String email,@Param("password") String password);
    
}
