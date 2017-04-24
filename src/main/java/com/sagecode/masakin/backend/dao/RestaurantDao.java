package com.sagecode.masakin.backend.dao;

import com.sagecode.masakin.backend.entity.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RestaurantDao extends PagingAndSortingRepository<Restaurant, String>{
    
}
