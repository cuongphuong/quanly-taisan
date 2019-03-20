package tpm.qlts.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.DonMuaHang;

@Repository("donMuaHangRepository")
public interface DonMuaHangRepository extends JpaRepository<DonMuaHang, Integer>{

}
