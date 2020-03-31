package com.study.store.rest;

import java.util.List;

import com.study.store.exception.RecordNotFoundException;
import com.study.store.model.Client;
import com.study.store.service.IClientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/store")
public class ClientController {

    @Autowired
    IClientService clientService;

    @PostMapping("/clients")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Client> create(@RequestBody Client client) throws RecordNotFoundException {
        Client updated = clientService.create(client);
        return new ResponseEntity<Client>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/clients")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/clients/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Client getById(@PathVariable("id") long id) {
        return clientService.getById(id);
    }

    @PutMapping("/clients")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void update(@RequestBody Client client) {
        clientService.update(client);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        clientService.delete(id);
    }

}