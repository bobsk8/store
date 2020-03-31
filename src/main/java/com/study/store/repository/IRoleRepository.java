package com.study.store.repository;

import java.util.Optional;

import com.study.store.model.ERole;
import com.study.store.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}