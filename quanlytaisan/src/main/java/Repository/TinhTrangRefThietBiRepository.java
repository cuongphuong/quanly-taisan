package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.TinhTrangRefThietBi;
import tpm.qlts.entitys.TinhTrangRefThietBiPK;

@Repository("tinhTrangRefThietBi")
public interface TinhTrangRefThietBiRepository extends JpaRepository<TinhTrangRefThietBi,TinhTrangRefThietBiPK > {

}
