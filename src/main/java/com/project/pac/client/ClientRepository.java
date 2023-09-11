package com.project.pac.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.client.definition.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

	List<ClientModel> findAllByIdUser(Long userId);

}
