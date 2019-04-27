package tpm.qlts.repositorys;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.NhanVienRefThietBi;
import tpm.qlts.entitys.NhanVienRefThietBiPK;

@Repository("nhanVienRefThietBiRepository")
public interface NhanVienRefThietBiRepository extends CrudRepository<NhanVienRefThietBi, NhanVienRefThietBiPK>{
	
	@Query(value= "select TOP 1 * FROM NV_TB where MaThietBi = :maThietBi order by Timestame desc", nativeQuery = true)
	public NhanVienRefThietBi getAllMathietbi(@Param("maThietBi") long maThietBi);
}
