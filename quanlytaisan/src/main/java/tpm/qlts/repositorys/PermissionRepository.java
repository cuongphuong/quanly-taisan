package tpm.qlts.repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.Permission;
import tpm.qlts.entitys.PermissionPK;

@Repository("permissionRepository")
public interface PermissionRepository extends CrudRepository<Permission, PermissionPK> {

	@Query("select c.functionID from Permission c where c.userID = :id")
	public int[] getAllFunctionByUserID(@Param("id") String idUser);

	@Query("select count(c) from Permission c where c.userID = :idUser and c.functionID = :functionID")
	public int checkPerission(@Param("idUser") String idUser, @Param("functionID") int functionID);
}
