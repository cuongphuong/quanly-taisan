package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Permission database table.
 * 
 */
@Entity
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PermissionPK id;

	
	//bi-directional many-to-one association to Function
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FunctionID")
	private Function function;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UserID")
	private User user;

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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}