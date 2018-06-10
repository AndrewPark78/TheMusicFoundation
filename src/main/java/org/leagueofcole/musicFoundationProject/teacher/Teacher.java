package org.leagueofcole.musicFoundationProject.teacher;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.leagueofcole.musicFoundationProject.role.Role;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String password;
	private String passwordConfirm;
@ManyToMany(fetch=FetchType.EAGER)
private Set<Role> roles;

	public Teacher(String userName, String password, String passwordConfirm) {
		super();
		this.userName = userName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}
Teacher(){
	
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void getUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return "";
	}

	public String getRegistryCode() {
		return "";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "teacher_role", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}