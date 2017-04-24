package com.sagecode.masakin.backend.controller;

import com.sagecode.masakin.backend.dao.UserDao;
import com.sagecode.masakin.backend.entity.Pesanan;
import com.sagecode.masakin.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
     @Autowired
     private UserDao ud;
     
     @RequestMapping(value="/user", method = RequestMethod.GET)
     public Page<User> cariUser(Pageable page) {         
         return ud.findAll(page);
     }
     
     @RequestMapping(value="/user/login", method = RequestMethod.GET)
     public User findByEmail(@RequestParam("email") String email,@RequestParam("password") String password){
        return ud.findByEmailByPassword(email,password);
     }
     
     @RequestMapping(value="/user", method = RequestMethod.POST)
     @ResponseStatus(HttpStatus.CREATED)
     public void insertUserBaru(@RequestBody User u){
         ud.save(u);
     }
     
     @RequestMapping(value="/user/{id}", method = RequestMethod.PUT)
     @ResponseStatus(HttpStatus.OK)
     public void updateUser(@PathVariable("id") String id, @RequestBody User u){
         u.setId(id);
         ud.save(u);
     }
     
//     @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
//     @ResponseStatus(HttpStatus.OK)
//     public User findUserById(@PathVariable("id") String id){
//         return ud.findOne(id);
//     }
     
     @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
     @ResponseStatus(HttpStatus.OK)
     public void hapusUser(@PathVariable("id") String id){
         ud.delete(id);
     }
}