package com.sagecode.masakin.backend.controller;

import com.sagecode.masakin.backend.dao.PesananDao;
import com.sagecode.masakin.backend.dao.UserDao;
import com.sagecode.masakin.backend.entity.Menu;
import com.sagecode.masakin.backend.entity.Pesanan;
import com.sagecode.masakin.backend.entity.Restaurant;
import com.sagecode.masakin.backend.entity.User;
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
public class PesananController {
    
    @Autowired
    private PesananDao pd;
        
     @RequestMapping(value="/pesanan", method = RequestMethod.GET)
     public Page<Pesanan> cariPesanan(Pageable page) {
         return pd.findAll(page);
     }
     
     @RequestMapping(value="/pesanan/user{id}", method = RequestMethod.GET)
     public Page<Pesanan> cariByUser(Pageable page,@PathVariable("id") String id){
         User u = new User();
         u.setId(id);
         
         return pd.findByUser(u, page);
     }
     
     
     @RequestMapping(value="/pesanan/user{idUser}/menu{idMenu}", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertPesananBaru(@PathVariable("idUser") String idUser,@PathVariable("idMenu") String idMenu,@RequestBody Pesanan p){
         User u =  new User();
         u.setId(idUser);
         
         Menu m = new Menu();
         m.setId(idMenu);
         
         p.setUser(u);
         p.setMenu(m);
                 
         pd.save(p);
     }
     
     @RequestMapping(value="/pesanan/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updatePesanan(@PathVariable("id") String id, @RequestBody Pesanan p){
         p.setId(id);
         pd.save(p);
     }
     
     @RequestMapping(value="/pesanan/{id}", method = RequestMethod.GET)
     @ResponseStatus(HttpStatus.OK)
     public void findPesananById(@PathVariable("id") String id){
         pd.findOne(id);
     }
     
     @RequestMapping(value="/pesanan/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusPesanan(@PathVariable("id") String id){
         pd.delete(id);
     }
     
     
}
