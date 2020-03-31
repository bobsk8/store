package com.study.store.service;

import java.util.List;

import com.study.store.model.Client;
import com.study.store.repository.IClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    IClientRepository clientrepo;

    @Override
    public Client create(Client client) {
        return clientrepo.save(client);
    }

    @Override
    public List<Client> getAll() {        
        return clientrepo.findAll();
    }

    @Override
    public Client getById(Long id) {        
        return clientrepo.getOne(id);
    }

    @Override
    public void update(Client client) {
        clientrepo.save(client);
    }

    @Override
    public void delete(Long id) {
        clientrepo.deleteById(id);
    }

    
}