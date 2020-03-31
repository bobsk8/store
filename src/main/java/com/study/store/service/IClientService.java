package com.study.store.service;

import java.util.List;

import com.study.store.exception.RecordNotFoundException;
import com.study.store.model.Client;

public interface IClientService {

    Client create(Client client) throws RecordNotFoundException;

    List<Client> getAll();

    Client getById(Long id);

    void update(Client client);

    void delete(Long id);
}
