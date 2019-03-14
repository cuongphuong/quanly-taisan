package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.NhanVien;

@Repository("nhanVien")
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

}
