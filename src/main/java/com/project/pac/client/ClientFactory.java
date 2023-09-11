package com.project.pac.client;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.pac.client.definition.ClientBean;
import com.project.pac.client.definition.ClientModel;

@Component
public class ClientFactory {

	public List<ClientBean> buildBeanList(List<ClientModel> listModel) {
		return listModel.stream().map(this::buildBean).toList();
	}

	public ClientBean buildBean(ClientModel model) {
		ClientBean bean = new ClientBean();

		bean.setId(model.getId());
		bean.setIdUser(model.getIdUser());
		bean.setName(model.getName());
		bean.setCnpj(model.getCnpj());
		bean.setPhone(model.getPhone());

		return bean;
	}

	public ClientModel buildModel(ClientBean bean) {
		ClientModel model = new ClientModel();

		model.setId(bean.getId());
		model.setIdUser(bean.getIdUser());
		model.setName(bean.getName());
		model.setCnpj(bean.getCnpj());
		model.setPhone(bean.getPhone());

		return model;
	}

}
