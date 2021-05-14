package com.cerg.educar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cerg.educar.dto.ClientDTO;
import com.cerg.educar.entities.Client;
import com.cerg.educar.repositories.ClientRepository;
import com.cerg.educar.services.exceptions.ControllerNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;
	
	public Page<ClientDTO> findAll(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}

	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ControllerNotFoundException("Cliente com id " + id + " não exite!"));
		return new ClientDTO(entity);	
	}
}
