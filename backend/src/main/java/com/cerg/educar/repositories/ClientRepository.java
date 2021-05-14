package com.cerg.educar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerg.educar.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
