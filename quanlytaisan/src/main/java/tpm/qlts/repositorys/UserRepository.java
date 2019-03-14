package tpm.qlts.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.Users;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<Users, String>{

}
