package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpm.qlts.entitys.DonViTinh;

@Repository("donViTinh")
public interface DonViTinhRepository extends JpaRepository<DonViTinh, Integer> {

}