package com.project.pac.supplier;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.pac.supplier.definition.SupplierBean;
import com.project.pac.supplier.definition.SupplierModel;

@Component
public class SupplierFactory {

	public List<SupplierBean> buildBeanList(List<SupplierModel> listModel) {
		return listModel.stream().map(this::buildBean).toList();
	}

	public SupplierBean buildBean(SupplierModel model) {
		SupplierBean bean = new SupplierBean();

		bean.setId(model.getId());
		bean.setIdUser(model.getIdUser());
		bean.setCnpj(model.getCnpj());
		bean.setName(model.getName());
		bean.setPhone(model.getPhone());

		return bean;
	}

	public SupplierModel buildModel(SupplierBean bean) {
		SupplierModel model = new SupplierModel();

		model.setId(bean.getId());
		model.setIdUser(bean.getIdUser());
		model.setCnpj(bean.getCnpj());
		model.setName(bean.getName());
		model.setPhone(bean.getPhone());

		return model;
	}
}
