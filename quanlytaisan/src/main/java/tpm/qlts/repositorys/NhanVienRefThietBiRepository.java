package tpm.qlts.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.NhanVienRefThietBi;
import tpm.qlts.entitys.NhanVienRefThietBiPK;

@Repository("nhanVienRefThietBiRepository")
public interface NhanVienRefThietBiRepository extends CrudRepository<NhanVienRefThietBi, NhanVienRefThietBiPK>{
	
}
