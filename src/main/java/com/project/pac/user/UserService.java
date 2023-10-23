package com.project.pac.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.user.definition.ChangePasswordBean;
import com.project.pac.user.definition.UserBean;
import com.project.pac.user.definition.UserModel;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserFactory userFactory;

	public List<UserBean> findAll() {
		List<UserModel> userModels = userRepository.findAll();
		return userFactory.buildBeanList(userModels);
	}

	public UserBean findById(Long id) {
		Optional<UserModel> userModel = userRepository.findById(id);
		return userModel.map(userFactory::buildBean).orElse(null);
	}

	public UserBean login(UserBean user) {
		UserModel userModel = userRepository.findByUserName(user.getUserName());

		if (userModel != null) {
			if(BCrypt.checkpw(user.getPassword(), userModel.getPassword())) {
				user.setId(userModel.getId());
				user.setAuth(true);
			}else {
				user.setAuth(false);
			}
		} else {
			user.setAuth(false);
		}

		return user;
	}

	public UserBean save(UserBean user) throws Exception {
		UserModel userModel = userRepository.findByUserName(user.getUserName());

		if (userModel == null) {
			UserModel userToSave = userFactory.buildModel(user);
			UserModel savedUserModel = userRepository.save(userToSave);
			return userFactory.buildBean(savedUserModel);
		} else {
			throw new Exception("User already exists");
		}
	}

	public UserBean changePassword(ChangePasswordBean bean) throws Exception {
		Optional<UserModel> userModel = userRepository.findById(bean.getUserId());

		if (userModel.isPresent()) {
			UserModel user = userModel.get();

			if (user.getPassword().equals(bean.getPassword())) {
				user.setPassword(bean.getNewPassword());
				UserModel savedUserModel = userRepository.save(user);
				return userFactory.buildBean(savedUserModel);
			} else {
				throw new Exception("Incorrect password");
			}
		} else {
			throw new Exception("User doesn't exist");
		}
	}
}
