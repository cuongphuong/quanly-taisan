package tpm.qlts.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.LoaiTB;

@Repository("loaiThietBiRepository")
public interface LoaiThietBiRepository extends CrudRepository<LoaiTB, String> {
	
	@Query("select c from LoaiTB c where c.maLoaiCha <> null")
	public List<LoaiTB> getLoaiTBSub();
	
	@Query("select c from LoaiTB c where c.maLoaiCha = null")
	public List<LoaiTB> getLoaiTBCha();
	
	@Query(value = "select top 1 ChiMucChu from GeneralLoaiAuto where id = 1", nativeQuery = true)
	public String getChiMucChu();
	
	@Query(value = "select top 1 ChiMucSo from GeneralLoaiAuto where id = 1", nativeQuery = true)
	public int getChiMucSo();
}
