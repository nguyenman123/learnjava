package cm10.service;

import java.util.List;

import cm10.model.Role;
import cm10.repository.RoleRepository;

public class RoleService {
	private RoleRepository roleRepository = new RoleRepository();
	public List<Role> getRoles(){
		return roleRepository.getRole();
		
	}
	
	public boolean deleteRoleById(int id) {
		return roleRepository.deleteRoleById(id) > 0 ? true : false;
	}
}
