package com.project.pac.bank;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.pac.bank.definition.BankBean;
import com.project.pac.bank.definition.BankModel;

@Component
public class BankFactory {

	public List<BankBean> buildBeanList(List<BankModel> listModel) {
		return listModel.stream().map(this::buildBean).toList();
	}

	public BankBean buildBean(BankModel model) {
		BankBean bean = new BankBean();

		bean.setId(model.getId());
		bean.setIdUser(model.getIdUser());
		bean.setBankCode(model.getBankCode());
		bean.setBankName(model.getBankName());
		bean.setBalance(model.getBalance());

		return bean;
	}

	public BankModel buildModel(BankBean bean) {
		BankModel model = new BankModel();

		model.setId(bean.getId());
		model.setIdUser(bean.getIdUser());
		model.setBankCode(bean.getBankCode());
		model.setBankName(bean.getBankName());
		model.setBalance(bean.getBalance());

		return model;
	}

}
