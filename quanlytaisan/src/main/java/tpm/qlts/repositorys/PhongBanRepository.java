package tpm.qlts.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.PhongBan;

@Repository("phongBanRepository")
public interface PhongBanRepository extends CrudRepository<PhongBan, String>{

}
