package com.sagecode.masakin.backend.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sagecode.masakin.backend.dao.MenuDao;
import com.sagecode.masakin.backend.dao.RestaurantDao;
import com.sagecode.masakin.backend.entity.Menu;
import com.sagecode.masakin.backend.entity.Pesanan;
import com.sagecode.masakin.backend.entity.Restaurant;
import com.sagecode.masakin.backend.entity.User;
import java.util.ArrayList;
import java.util.List;
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
public class MenuController {
    
    @Autowired
    private RestaurantDao rd;
    
    @Autowired
    private MenuDao md;
     
    
     @RequestMapping(value="/menu", method = RequestMethod.GET)
     public Page<Menu> cariMenu(Pageable page) {
        return md.findAll(page);
     }
     
     @RequestMapping(value="/menu/restaurant{id}", method = RequestMethod.GET)
     public Page<Menu> cariByRestaurant(Pageable page,@PathVariable("id") String id){
         Restaurant r = new Restaurant();
         r.setId(id);
         
         return md.findByRestaurant(r, page);
     }
     
     @RequestMapping(value="/menu/makanan",method = RequestMethod.GET)
     public Page<Menu> cariByMakanan(Pageable page){
         return md.findByJenisMakanan(page);
     }
     
     @RequestMapping(value="/menu/minuman",method = RequestMethod.GET)
     public Page<Menu> cariByMinuman(Pageable page){
         return md.findByJenisMinuman(page);
     }
     
     @RequestMapping(value="/menu/pesanan{id}", method = RequestMethod.GET)
     public Page<Menu> cariByDaftarPesanan(Pageable page,@PathVariable("id") String id){
         
         
         Pesanan p = new Pesanan();
         p.setId(id);
         
         return md.findByDaftarPesanan(p, page);
     }
     
     
     @RequestMapping(value="/menu/restaurant{id}", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertMenuBaru(@RequestBody Menu m,@PathVariable("id") String id){
         Restaurant r = new Restaurant();
         r.setId(id);
         
         m.setRestaurant(r);
         md.save(m);
     }
     
     @RequestMapping(value="/menu/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateMenu(@PathVariable("id") String id, @RequestBody Menu m){
         m.setId(id);
         md.save(m);
     }
     
     @RequestMapping(value="/menu/{id}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public Menu findMenuById(@PathVariable("id") String id){
         return md.findOne(id);
     }
     
     @RequestMapping(value="/menu/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusMenu(@PathVariable("id") String id){
         md.delete(id);
     }
}
