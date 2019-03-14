package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.NhaCungCap;

@Repository("nhaCungCap")
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {

}
