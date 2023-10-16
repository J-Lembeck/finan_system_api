package com.project.pac.monitoring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.pac.user.UserRepository;
import com.project.pac.user.definition.UserModel;

@Component
@EnableScheduling
public class MonitoringSystem {

	@Autowired
	UserRepository userRepository;

	@Scheduled(fixedRate = 60000)
	public void MonitoringUsers() {
		List<UserModel> users = this.userRepository.findAll();
		Integer numberOfUsers = users.size();

		if (numberOfUsers >= 100) {
			issuePerformanceWarning();
		}

	}

	public void issuePerformanceWarning() {
		System.out.println("AVISO: O sistema atingiu 100 usuários cadastrados. Pode haver problemas de desempenho.");
	}

}
