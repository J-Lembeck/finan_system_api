package com.project.pac.user.definition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangePasswordBean {

	private Long userId;
	private String password;
	private String newPassword;

}
