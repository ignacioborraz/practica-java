package com.adoptme.petshop.controllers;

import com.adoptme.petshop.entities.User;
import com.adoptme.petshop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired private UsersService service;

    @PostMapping
    public ResponseEntity<User> createPerson(@RequestBody User user) {
        try {
            return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllPersons() {
        try {
            List<User> users = service.findAll();
            if (!users.isEmpty()) {
                return ResponseEntity.ok(users);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        try {
            Optional<User> user = service.findById(id);
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User data) {
        try {
            Optional<User> optionalUser = service.findById(id);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                user.setName(data.getName());
                user.setEmail(data.getEmail());
                user.setPets(user.getPets());
                return ResponseEntity.ok(service.save(user));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        try {
            Optional<User> optionalUser = service.findById(id);
            if (optionalUser.isPresent()) {
                service.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
