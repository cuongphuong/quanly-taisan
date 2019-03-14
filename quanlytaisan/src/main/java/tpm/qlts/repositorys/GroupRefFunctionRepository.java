package tpm.qlts.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.GroupRefFunction;
import tpm.qlts.entitys.GroupRefFunctionPK;

@Repository("groupRefFunctionRepository")
public interface GroupRefFunctionRepository extends CrudRepository<GroupRefFunction, GroupRefFunctionPK>{

}
