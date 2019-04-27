package tpm.qlts.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.ThietBi;

@Repository("thietBiRepository")
public interface ThietBiRepository extends JpaRepository<ThietBi, Long>{

	@Query("select tb from PhongBan p JOIN p.nhanViens n Join n.nvTbs m Join m.thietBi tb Join tb.loaiTb l where p.maPhongBan =:maPhongBan and l.maLoai =:maLoai")
	public List<ThietBi> getAllThietBiByID(@Param("maPhongBan") String maPhongBan, @Param("maLoai") String maLoai);
	
	@Query("select tb from PhongBan p JOIN p.nhanViens n Join n.nvTbs m Join m.thietBi tb where p.maPhongBan =:maPhongBan")
	public List<ThietBi> getAllByIdthietBiPhongBan(@Param("maPhongBan") String maPhongBan);
	
}
