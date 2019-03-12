package tpm.qlts.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.NhaCungCap;

@Repository("nhaCungCapRepository")
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {

}