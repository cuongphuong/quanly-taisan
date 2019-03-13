package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="UserID")
	private String userID;

	@Column(name="FullName")
	private String fullName;

	@Column(name="Password")
	private String password;

	@Column(name="Username")
	private String username;

	//bi-directional many-to-one association to Permission
	@OneToMany(mappedBy="user")
	private List<Permission> permissions;

	//bi-directional many-to-one association to UserRefGroup
	@OneToMany(mappedBy="user")
	private List<UserRefGroup> userGroups;

	public User() {
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Permission addPermission(Permission permission) {
		getPermissions().add(permission);
		permission.setUser(this);

		return permission;
	}

	public Permission removePermission(Permission permission) {
		getPermissions().remove(permission);
		permission.setUser(null);

		return permission;
	}

	public List<UserRefGroup> getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(List<UserRefGroup> userGroups) {
		this.userGroups = userGroups;
	}

	public UserRefGroup addUserGroup(UserRefGroup userGroup) {
		getUserGroups().add(userGroup);
		userGroup.setUser(this);

		return userGroup;
	}

	public UserRefGroup removeUserGroup(UserRefGroup userGroup) {
		getUserGroups().remove(userGroup);
		userGroup.setUser(null);

		return userGroup;
	}

}