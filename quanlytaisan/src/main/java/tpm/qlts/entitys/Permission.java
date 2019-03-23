package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the Permission database table.
 * 
 */
@Entity
@NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PermissionPK id;

	@Column(name = "UserID", insertable = false, updatable = false)
	private String userID;

	@Column(name = "FunctionID", insertable = false, updatable = false)
	private int functionID;

	// bi-directional many-to-one association to Function
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "FunctionID", updatable = false, insertable = false)
	private Function function;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "UserID", updatable = false, insertable = false)
	private Users user;

	public Permission() {
	}

	public Permission(PermissionPK id) {
		super();
		this.id = id;
	}

	public PermissionPK getId() {
		return this.id;
	}

	public void setId(PermissionPK id) {
		this.id = id;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getFunctionID() {
		return functionID;
	}

	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}

}