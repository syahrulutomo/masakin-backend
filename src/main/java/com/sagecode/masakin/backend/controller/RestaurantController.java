package com.sagecode.masakin.backend.controller;


import com.sagecode.masakin.backend.dao.RestaurantDao;
import com.sagecode.masakin.backend.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
     
     @Autowired
     private RestaurantDao rd;
        
     @RequestMapping(value="/restaurant", method = RequestMethod.GET)
     public Page<Restaurant> cariRestaurant(Pageable page) {
         return rd.findAll(page);
     }
     
     @RequestMapping(value="/restaurant", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertRestaurantBaru(@RequestBody Restaurant r){
         rd.save(r);
     }
     
     @RequestMapping(value="/restaurant/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateRestaurant(@PathVariable("id") String id, @RequestBody Restaurant r){
         r.setId(id);
         rd.save(r);
     }
     
     @RequestMapping(value="/restaurant/{id}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Restaurant findRestaurantById(@PathVariable("id") String id){
         return rd.findOne(id);
     }
     
     @RequestMapping(value="/restaurant/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusRestaurant(@PathVariable("id") String id){
         rd.delete(id);
     }
}
