package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Function database table.
 * 
 */
@Entity
@NamedQuery(name="Function.findAll", query="SELECT f FROM Function f")
public class Function implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FunctionID")
	private int functionID;

	@Column(name="FunctionName")
	private String functionName;

	@Column(name="Url")
	private String url;

	//bi-directional many-to-one association to Module
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ModuleID")
	private Module module;

	//bi-directional many-to-one association to GroupRefFunction
	@OneToMany(mappedBy="function")
	private List<GroupRefFunction> groupFunctions;

	//bi-directional many-to-one association to Permission
	@OneToMany(mappedBy="function")
	private List<Permission> permissions;

	public Function() {
	}

	public int getFunctionID() {
		return this.functionID;
	}

	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<GroupRefFunction> getGroupFunctions() {
		return this.groupFunctions;
	}

	public void setGroupFunctions(List<GroupRefFunction> groupFunctions) {
		this.groupFunctions = groupFunctions;
	}

	public GroupRefFunction addGroupFunction(GroupRefFunction groupFunction) {
		getGroupFunctions().add(groupFunction);
		groupFunction.setFunction(this);

		return groupFunction;
	}

	public GroupRefFunction removeGroupFunction(GroupRefFunction groupFunction) {
		getGroupFunctions().remove(groupFunction);
		groupFunction.setFunction(null);

		return groupFunction;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Permission addPermission(Permission permission) {
		getPermissions().add(permission);
		permission.setFunction(this);

		return permission;
	}

	public Permission removePermission(Permission permission) {
		getPermissions().remove(permission);
		permission.setFunction(null);

		return permission;
	}

}