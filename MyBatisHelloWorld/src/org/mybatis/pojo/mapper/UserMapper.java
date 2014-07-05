package org.mybatis.pojo.mapper;

import java.util.List;

import org.mybatis.pojo.User;

/**
 * User Mapper interface
 * 
 * @author chaoch
 * 
 */
public interface UserMapper {
	// Add user
	void add(User user);

	// Delete user by id
	void delete(int id);

	// Find user by id
	User findById(int id);
	
	// Find user by role id
//	User findByRoleId(int roleId);

	// Find all users
	List<User> findAllUsers();

	// Update user
	void update(User user);
}
