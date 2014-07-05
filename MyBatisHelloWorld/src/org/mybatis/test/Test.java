package org.mybatis.test;

import java.io.IOException;
import java.util.List;

import org.mybatis.pojo.Role;
import org.mybatis.pojo.User;
import org.mybatis.pojo.mapper.RoleMapper;
import org.mybatis.pojo.mapper.UserMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	private static SqlSessionFactory factory;
	private static SqlSession session;
	private static final String CONFIG = "myBatis_config.xml";
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources
					.getResourceAsReader(CONFIG));
			session = factory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Get user DAO
	 * 
	 * @return
	 */
	public static UserMapper getUserMapper() {
		if (session == null) {
			System.out.println("Session is not open");
			return null;
		}
		return session.getMapper(UserMapper.class);
	}

	/**
	 * Get role Mapper
	 * 
	 * @return
	 */
	public static RoleMapper getRoleMapper() {
		if (session == null) {
			System.out.println("Session is not open");
			return null;
		}
		return session.getMapper(RoleMapper.class);
	}

	/**
	 * Test for adding a new role
	 */
	public static void addRoleTest() {
		RoleMapper roleMapper = getRoleMapper();
		if (roleMapper == null)
			return;
		// Add a new role
		Role role = new Role();
		role.setName("visitor");
		role.setLevel(2);
		roleMapper.add(role);
		session.commit();
	}

	/**
	 * Test for adding a user
	 */
	public static void addUserTest() {
		RoleMapper roleMapper = getRoleMapper();
		UserMapper userMapper = getUserMapper();
		if (userMapper == null || roleMapper == null) {
			return;
		}
		// Add a new user
		Role role = roleMapper.getRoleById(1);
		User user = new User();
		user.setName("admin");
		user.setPasswd("admin");
		user.setRole(role);
		userMapper.add(user);
		session.commit();
	}

	/**
	 * Tet for getting all users
	 */
	public static void getAllUsersTest() {
		UserMapper userMapper = getUserMapper();
		if (userMapper == null) {
			return;
		}
		List<User> users = userMapper.findAllUsers();
		for (User user : users) {
			System.out.println(user.getId() + " " + user.getName() + " "
					+ user.getPasswd() + " " + user.getRole().getName());
		}
	}

	/**
	 * Test for getting all roles
	 */
	public static void getAllRolesTest() {
		RoleMapper roleMapper = getRoleMapper();
		if (roleMapper == null)
			return;
		// Get all roles
		List<Role> roles = roleMapper.getAllRoles();
		for (Role role : roles) {
			System.out.println(role.getId() + " " + role.getName() + " "
					+ role.getLevel());
			System.out.print("- Users: ");
			for (User user : role.getUsers()) {
				System.out.print(role.getName() + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		getAllRolesTest();
		// getAllUsersTest();
	}
}
