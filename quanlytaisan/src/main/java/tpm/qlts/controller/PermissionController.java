package tpm.qlts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpm.qlts.entitys.Function;
import tpm.qlts.entitys.Group;
import tpm.qlts.entitys.GroupRefFunction;
import tpm.qlts.entitys.GroupRefFunctionPK;
import tpm.qlts.entitys.Module;
import tpm.qlts.entitys.UserRefGroup;
import tpm.qlts.entitys.UserRefGroupPK;
import tpm.qlts.services.FunctionService;
import tpm.qlts.services.GroupRefFunctionService;
import tpm.qlts.services.GroupService;
import tpm.qlts.services.ModuleService;
import tpm.qlts.services.UserRefGroupService;

@Controller
@RestController
@RequestMapping("permission")
public class PermissionController {
	@Autowired
	private GroupService groupService;
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private FunctionService functionService;
	@Autowired
	private UserRefGroupService userRefGroupService;
	@Autowired
	private GroupRefFunctionService groupRefFunctionService;

	// Crud table group
	@GetMapping("index")
	private String index() {
		return "Permission API by Cuong, Phuong Van.";
	}

	@PostMapping("add-group")
	public Group addNewGroup(@RequestBody Group group) {
		// check permission
		return groupService.update(group);
	}

	@PutMapping("update-group")
	public Group updateGroup(@RequestBody Group group) {
		// check permission
		if (groupService.existsById(group.getGroupID()))
			return groupService.update(group);
		else
			return null;
	}

	@DeleteMapping("delete-group/{id}")
	public void deleteGroup(@PathVariable int id) {
		if (groupService.existsById(id))
			groupService.deleteById(id);
	}

	// Crud table module
	@PostMapping("add-module")
	public Module addNewModule(@RequestBody Module module) {
		// check permission
		return moduleService.update(module);
	}

	@PutMapping("update-module")
	public Module updateModule(@RequestBody Module module) {
		// check permission
		if (moduleService.existsById(module.getModuleID()))
			return moduleService.update(module);
		else
			return null;
	}

	@DeleteMapping("delete-module/{id}")
	public void deleteModule(@PathVariable int id) {
		if (moduleService.existsById(id))
			moduleService.deleteById(id);
	}

	// Crud table function
	@PostMapping("add-function")
	public Function addNewFunction(@RequestBody Function function) {
		// check permission
		return functionService.update(function);
	}

	@PutMapping("update-function")
	public Function updateModule(@RequestBody Function function) {
		// check permission
		if (functionService.existsById(function.getFunctionID()))
			return functionService.update(function);
		else
			return null;
	}

	@DeleteMapping("delete-function/{id}")
	public void deleteFunction(@PathVariable int id) {
		if (functionService.existsById(id))
			functionService.deleteById(id);
	}

	// Crud table UserGroup
	@PostMapping("add-usergroup")
	public UserRefGroup addNewUserGroup(@RequestBody UserRefGroup userRefGroup) {
		// check permission
		return userRefGroupService.update(userRefGroup);
	}

	// Crud table UserGroup
	@Transactional
	@PostMapping("update-usergroup-by-list")
	public Iterable<UserRefGroup> updateUserGroup(@RequestBody List<UserRefGroupPK> lstUGPK) {
		// check permission
		List<UserRefGroup> lstInClient = this.toUserRefGroup(lstUGPK);
		List<UserRefGroup> lstInDatabase = userRefGroupService.findAll();
		List<UserRefGroup> lstDel = lstInDatabase;
		List<UserRefGroup> lstAdd = lstInClient;

//		for (UserRefGroup itemClient : lstInClient) {
//			UserRefGroupPK idClient = itemClient.getId();
//			for (UserRefGroup itemDatabase : lstInDatabase) {
//				if (idClient.getGroupID() == itemDatabase.getId().getGroupID()
//						&& idClient.getUserID().equals(itemDatabase.getId().getUserID()) == true) {
//					lstAdd.remove(itemClient);
//					lstDel.remove(itemDatabase);
//				}
//			}
//		}

		for (int i = 0; i < lstInClient.size(); i++) {
			UserRefGroupPK idClient = lstInClient.get(i).getId();
			for (int j = 0; j < lstInDatabase.size(); j++) {
				if (idClient.getGroupID() == lstInDatabase.get(j).getId().getGroupID()
						&& idClient.getUserID().equals(lstInDatabase.get(j).getId().getUserID()) == true) {
					lstAdd.remove(lstInDatabase.get(j));
					lstDel.remove(lstInClient.get(i));
					continue;
				}
				i++;
			}
		}
		userRefGroupService.deleteAll(lstDel);
		return userRefGroupService.updateByList(lstAdd);
	}

	public List<UserRefGroup> toUserRefGroup(List<UserRefGroupPK> lstUGPK) {
		List<UserRefGroup> lstRes = new ArrayList<UserRefGroup>();
		for (UserRefGroupPK k : lstUGPK) {
			lstRes.add(new UserRefGroup(new UserRefGroupPK(k.getUserID(), k.getGroupID())));
		}
		return lstRes;
	}

	// Crud table group-function
	@PostMapping("update-groupfunction-by-list")
	public Iterable<GroupRefFunction> updateGroupFunction(@RequestBody List<GroupRefFunctionPK> lstKey) {
		List<GroupRefFunction> lstInClient = this.toGroupFunction(lstKey);
		List<GroupRefFunction> lstInDatabase = groupRefFunctionService.findAll();
		List<GroupRefFunction> lstDel = lstInDatabase;
		List<GroupRefFunction> lstAdd = lstInClient;

		for (int i = 0; i < lstInClient.size(); i++) {
			GroupRefFunctionPK idClient = lstInClient.get(i).getId();
			for (int j = 0; j < lstInDatabase.size(); j++) {
				if (idClient.getGroupID() == lstInDatabase.get(j).getId().getGroupID()
						&& idClient.getFunctionID() == lstInDatabase.get(j).getId().getFunctionID()) {
					lstAdd.remove(lstInDatabase.get(j));
					lstDel.remove(lstInClient.get(i));
					continue;
				}
				i++;
			}
		}
		groupRefFunctionService.deleteByList(lstDel);
		return groupRefFunctionService.saveAllByList(lstAdd);
	}

	public List<GroupRefFunction> toGroupFunction(List<GroupRefFunctionPK> lstKey) {
		List<GroupRefFunction> lstRes = new ArrayList<GroupRefFunction>();
		for (GroupRefFunctionPK k : lstKey) {
			lstRes.add(new GroupRefFunction(new GroupRefFunctionPK(k.getGroupID(), k.getFunctionID())));
		}
		return lstRes;
	}

}
