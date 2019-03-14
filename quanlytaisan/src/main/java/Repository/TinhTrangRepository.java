package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.TinhTrang;

@Repository("tinhTrangRepository")
public interface TinhTrangRepository extends JpaRepository<TinhTrang, String> {

}
