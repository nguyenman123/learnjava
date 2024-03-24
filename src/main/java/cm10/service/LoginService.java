package cm10.service;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import cm10.model.User;
import cm10.repository.UserRepository;

public class LoginService {
	
	private UserRepository userRepository = new UserRepository();
	
	public boolean checkLogin(String username, String password) {
		List<User> list = userRepository.getUserByUsernameAndPassword(username, password);
		
		return list.size()>0 ? true:false;

	}

}
