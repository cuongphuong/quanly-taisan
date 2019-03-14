package tpm.qlts.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.Permission;
import tpm.qlts.entitys.PermissionPK;

@Repository("permissionRepository")
public interface PermissionRepository extends CrudRepository<Permission, PermissionPK>{

}
