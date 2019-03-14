package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;

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

	// bi-directional many-to-one association to Function
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FunctionID", updatable = false, insertable = false)
	private Function function;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", updatable = false, insertable = false)
	private Users user;

	public Permission() {
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

}