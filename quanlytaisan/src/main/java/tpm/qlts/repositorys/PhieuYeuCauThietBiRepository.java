package tpm.qlts.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.PhieuYeuCauThietBi;

@Repository("phieuYeuCauThietBiRepository")
public interface PhieuYeuCauThietBiRepository extends JpaRepository<PhieuYeuCauThietBi, Integer>{

}
