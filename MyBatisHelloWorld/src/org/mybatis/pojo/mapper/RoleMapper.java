package org.mybatis.pojo.mapper;

import java.util.List;

import org.mybatis.pojo.Role;

/**
 * Role Mapper interface
 * 
 * @author chaoch
 * 
 */
public interface RoleMapper {
	// Add new role
	void add(Role role);

	// Delete role by role id
	void delete(int roleId);

	// Get all roles
	List<Role> getAllRoles();

	// Get role by role id
	Role getRoleById(int roleId);

	// Update existing role
	void update(Role role);
}
