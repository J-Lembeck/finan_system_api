package com.project.pac.user;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.project.pac.user.definition.UserBean;
import com.project.pac.user.definition.UserModel;

@Component
public class UserFactory {

	public List<UserBean> buildBeanList(List<UserModel> listModel) {
		return listModel.stream().map(this::buildBean).toList();
	}

	public UserBean buildBean(UserModel model) {
		UserBean bean = new UserBean();

		bean.setId(model.getId());
		bean.setUserName(model.getUserName());
		bean.setPassword(model.getPassword());
		bean.setCnpj(model.getCnpj());

		return bean;
	}
	
	public UserBean buildBeanNoPassword(UserModel model) {
		UserBean bean = new UserBean();

		bean.setId(model.getId());
		bean.setUserName(model.getUserName());
		bean.setCnpj(model.getCnpj());

		return bean;
	}

	public UserModel buildModel(UserBean bean) {
		UserModel model = new UserModel();
		
		String hashSenha = BCrypt.hashpw(bean.getPassword(), BCrypt.gensalt());
		
		model.setId(bean.getId());
		model.setUserName(bean.getUserName());
		model.setPassword(hashSenha);
		model.setCnpj(bean.getCnpj());

		return model;
	}

}
