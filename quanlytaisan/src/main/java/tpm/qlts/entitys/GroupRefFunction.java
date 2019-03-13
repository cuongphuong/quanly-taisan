package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Group_Function database table.
 * 
 */
@Entity
@Table(name="Group_Function")
@NamedQuery(name="GroupRefFunction.findAll", query="SELECT g FROM GroupRefFunction g")
public class GroupRefFunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GroupRefFunctionPK id;


	//bi-directional many-to-one association to Function
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FunctionID")
	private Function function;

	//bi-directional many-to-one association to Group
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GroupID")
	private Group group;

	public GroupRefFunction() {
	}

	public GroupRefFunctionPK getId() {
		return this.id;
	}

	public void setId(GroupRefFunctionPK id) {
		this.id = id;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}