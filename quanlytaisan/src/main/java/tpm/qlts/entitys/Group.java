package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Group database table.
 * 
 */
@Entity
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GroupID")
	private int groupID;

	@Column(name="GroupName")
	private String groupName;

	//bi-directional many-to-one association to GroupRefFunction
	@OneToMany(mappedBy="group")
	private List<GroupRefFunction> groupFunctions;

	//bi-directional many-to-one association to UserRefGroup
	@OneToMany(mappedBy="group")
	private List<UserRefGroup> userGroups;

	public Group() {
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<GroupRefFunction> getGroupFunctions() {
		return this.groupFunctions;
	}

	public void setGroupFunctions(List<GroupRefFunction> groupFunctions) {
		this.groupFunctions = groupFunctions;
	}

	public GroupRefFunction addGroupFunction(GroupRefFunction groupFunction) {
		getGroupFunctions().add(groupFunction);
		groupFunction.setGroup(this);

		return groupFunction;
	}

	public GroupRefFunction removeGroupFunction(GroupRefFunction groupFunction) {
		getGroupFunctions().remove(groupFunction);
		groupFunction.setGroup(null);

		return groupFunction;
	}

	public List<UserRefGroup> getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(List<UserRefGroup> userGroups) {
		this.userGroups = userGroups;
	}

	public UserRefGroup addUserGroup(UserRefGroup userGroup) {
		getUserGroups().add(userGroup);
		userGroup.setGroup(this);

		return userGroup;
	}

	public UserRefGroup removeUserGroup(UserRefGroup userGroup) {
		getUserGroups().remove(userGroup);
		userGroup.setGroup(null);

		return userGroup;
	}

}