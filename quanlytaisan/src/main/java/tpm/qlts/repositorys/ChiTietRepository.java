package tpm.qlts.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.ChiTiet;

@Repository("chiTietRepository")
public interface ChiTietRepository extends JpaRepository<ChiTiet, Integer>{
	
}
