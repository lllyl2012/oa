package cn.yl.oa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ��ɫ
 * @author toshiba2
 *
 */
public class Role {
	private Long id;
	private String name;
	private String description;
	private Set<User> users;
	private Set<Privilege> privileges = new HashSet<Privilege>();
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	
	
}
