package tpm.qlts.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.ThietBi;

@Repository("thietBiRepositoryByManhGa")
public interface ThietBiRepositoryByManhGa extends ThietBiRepository {

	@Query(value = "select ThietBi.* from ThietBi inner join LoaiTB on (ThietBi.MaLoai = LoaiTB.MaLoai) where LoaiTB.MaLoaiCha in (select MaLoai from LoaiTB where MaLoaiCha is null and MaNCC = :MaNCC)", nativeQuery = true)
	public List<ThietBi> getThietBiByNhaCungCap(@Param("MaNCC") String MaNCC);

	
}
