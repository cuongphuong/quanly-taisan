package tpm.qlts.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.Function;

@Repository("functionRepository")
public interface FunctionRepository extends CrudRepository<Function, Integer>{

}
