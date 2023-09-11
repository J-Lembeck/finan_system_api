package com.project.pac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.project.pac.user.UserFactory;
import com.project.pac.user.UserRepository;
import com.project.pac.user.UserService;
import com.project.pac.user.definition.ChangePasswordBean;
import com.project.pac.user.definition.UserBean;

public class UserControllerTest {

	@InjectMocks
    UserService userService;
    
    @Mock
    private UserRepository userRepository;
    
    @Mock
    private UserFactory userFactory;
    
    @Test
    public void findAll() {
    	UserBean user = new UserBean();
    	
    	user.setUserName("adm");
    	user.setPassword("teste123");

    	assertTrue(userService.login(user).getAuth());
    }
    
    @Test
    public void changePassword() throws Exception {
    	ChangePasswordBean changePassword = new ChangePasswordBean();
    	
    	changePassword.setUserId(1L);
    	changePassword.setPassword("teste123");
    	changePassword.setNewPassword("teste12345");
    	
    	UserBean user = userService.changePassword(changePassword);
    	
    	changePassword.setNewPassword("teste123");
    	userService.changePassword(changePassword);

    	assertEquals("teste12345", user.getPassword());
    }
}
