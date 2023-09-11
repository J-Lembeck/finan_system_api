package com.project.pac.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.client.definition.ClientBean;
import com.project.pac.client.definition.ClientModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientFactory clientFactory;

	public List<ClientBean> findAll(Long userId) {
		List<ClientModel> clientModels = clientRepository.findAllByIdUser(userId);
		return clientModels.stream().map(clientFactory::buildBean).collect(Collectors.toList());
	}

	public List<ClientBean> saveAll(List<ClientBean> clientList) {
		return clientList.stream().map(this::save).collect(Collectors.toList());
	}

	public ClientBean save(ClientBean clientBean) {
		ClientModel clientModel = clientFactory.buildModel(clientBean);
		ClientModel savedModel = clientRepository.save(clientModel);
		return clientFactory.buildBean(savedModel);
	}

	public ClientBean update(ClientBean clientBean) throws Exception {
		if (clientRepository.existsById(clientBean.getId())) {
			return save(clientBean);
		} else {
			throw new Exception("Client not found");
		}
	}

	public void deleteByIds(List<Long> clientIds) {
		clientRepository.deleteAllById(clientIds);
	}
}
