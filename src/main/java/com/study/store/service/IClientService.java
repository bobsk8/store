package com.study.store.service;

import java.util.List;

import com.study.store.model.Client;


public interface IClientService {

    Client create(Client client);

    List<Client> getAll();

    Client getById(Long id);

    void update(Client client);

    void delete(Long id);
}
