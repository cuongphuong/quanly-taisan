package tpm.qlts.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.UserRefGroup;
import tpm.qlts.entitys.UserRefGroupPK;

@Repository("userRefGroupRepository")
public interface UserRefGroupRepository extends CrudRepository<UserRefGroup, UserRefGroupPK>{
	
}
