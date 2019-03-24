package tpm.qlts.controller;

import java.security.Principal;
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

import tpm.qlts.custommodels.PermissionItem;
import tpm.qlts.custommodels.PermissionUserUpdate;
import tpm.qlts.custommodels.Permissions;
import tpm.qlts.entitys.Function;
import tpm.qlts.entitys.Group;
import tpm.qlts.entitys.GroupRefFunction;
import tpm.qlts.entitys.GroupRefFunctionPK;
import tpm.qlts.entitys.Module;
import tpm.qlts.entitys.Permission;
import tpm.qlts.entitys.PermissionPK;
import tpm.qlts.entitys.UserRefGroup;
import tpm.qlts.entitys.UserRefGroupPK;
import tpm.qlts.entitys.Users;
import tpm.qlts.services.FunctionService;
import tpm.qlts.services.GroupRefFunctionService;
import tpm.qlts.services.GroupService;
import tpm.qlts.services.ModuleService;
import tpm.qlts.services.PermissionService;
import tpm.qlts.services.UserRefGroupService;
import tpm.qlts.services.UserRevice;

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
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private UserRevice userService;

	@GetMapping("index")
	private String index() {
		return "Permission API by Cuong, Phuong Van.";
	}

	// Crud table group
	@GetMapping("get-all-group")
	public List<Group> getAllGroup() {
		return groupService.findAll();
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
	
	@GetMapping("get-all-module")
	public List<Module> getAllModule() {
		return moduleService.findAll();
	}
	
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
	@GetMapping("getall-user-group")
	public List<UserRefGroup> getAllUserGroup() {
		return userRefGroupService.findAll();
	}

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
	@GetMapping("getall-group-function")
	public List<GroupRefFunction> getAllGroupFunction() {
		return groupRefFunctionService.findAll();
	}

	@Transactional
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

	@PostMapping("update-permission-user")
	public Iterable<Permission> setPermissionToUser(@RequestBody PermissionUserUpdate data) {
		List<Permission> lstPermissionClient = new ArrayList<Permission>();
		for (int i = 0; i < data.getLstFunction().length; i++) {
			lstPermissionClient.add(new Permission(new PermissionPK(data.getUserID(), data.getLstFunction()[i])));
		}

		//
		List<Permission> lstInDatabase = permissionService.findAll();
		for (int i = 0; i < lstPermissionClient.size(); i++) {
			PermissionPK idClient = lstPermissionClient.get(i).getId();
			for (int j = 0; j < lstInDatabase.size(); j++) {
				if (idClient.getFunctionID() == lstInDatabase.get(j).getId().getFunctionID()
						&& idClient.getUserID().equals(lstInDatabase.get(j).getId().getUserID())) {
					lstPermissionClient.remove(lstPermissionClient.get(j));
					lstInDatabase.remove(lstInDatabase.get(i));
					continue;
				}
				i++;
			}
		}

		if (lstInDatabase.size() > 0)
			permissionService.deleteAll(lstInDatabase);
		return permissionService.updateAll(lstPermissionClient);
	}

	//

	@GetMapping("get-permission-user/{id}")
	public List<PermissionItem> getPermissionOfUser(@PathVariable String id) {
		List<Function> allFunction = functionService.findAll();

		int[] functionByUser = permissionService.getAllFunctionByUser(id);

		List<PermissionItem> lstRes = new ArrayList<PermissionItem>();
		for (Function f : allFunction) {
			if (this.existsInList(f.getFunctionID(), functionByUser))
				lstRes.add(new PermissionItem(id, f.getFunctionID(), f.getFunctionName(), f.getModule().getModuleID(),
						f.getModule().getModuleName(), true));
			else
				lstRes.add(new PermissionItem(id, f.getFunctionID(), f.getFunctionName(), f.getModule().getModuleID(),
						f.getModule().getModuleName(), false));
		}

		return lstRes;
	}

	public boolean existsInList(int id, int[] lst) {
		for (int i = 0; i < lst.length; i++) {
			if (lst[i] == id)
				return true;
		}
		return false;
	}

	@GetMapping("get-function-active")
	public List<Permissions> getFunctionActiveByUser(Principal principal) {
		Users uRes = userService.findByUserName(principal.getName());
		List<Permissions> lstData = new ArrayList<Permissions>();
		List<Module> allModule = moduleService.findAll();
		for (Module itemModule : allModule) {
			List<Permission> lstPermission = permissionService.getAllFunctionByUserIDFull(uRes.getUserID(),
					itemModule.getModuleID());
			List<Function> tmpList = new ArrayList<Function>();
			for (Permission p : lstPermission) {
				Function f = p.getFunction();
//				if(f.getFunctionName().equals("thiết bị".toUpperCase())){
//					f.setFunctionName(f.getFunctionName().replace("thiết bị", "TB"));
//					f.setFunctionName(f.getFunctionName().replace("Thiết bị", "TB"));
//					f.setFunctionName(f.getFunctionName().replace("Thiết Bị", "TB"));
//				}
				tmpList.add(f);
			}
			lstData.add(new Permissions(itemModule.getModuleID(), itemModule.getModuleName(), tmpList));
		}
		return lstData;
	}
}
