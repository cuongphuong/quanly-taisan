package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.LoaiTB;

@Repository("loaiTB")
public interface LoaiTBRepository extends JpaRepository<LoaiTB, String> {

}
