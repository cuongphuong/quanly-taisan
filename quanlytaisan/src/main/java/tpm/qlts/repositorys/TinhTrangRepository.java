package tpm.qlts.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.TinhTrang;

@Repository("tinhTrangRepository")
public interface TinhTrangRepository extends CrudRepository<TinhTrang, String>{

}