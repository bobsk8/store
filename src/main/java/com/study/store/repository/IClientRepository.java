package com.study.store.repository;

import com.study.store.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {

    
}