package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.DonViTinhRepository;
import tpm.qlts.entitys.DonViTinh;

@Service("donViTinhService")
public class DonViTinhService {

	@Autowired
	private DonViTinhRepository donViTinhRepository;

	public Iterable<DonViTinh> findAll() {
		return donViTinhRepository.findAll();
	}

	public Optional<DonViTinh> findByID(int ID) {
		return donViTinhRepository.findById(ID);
	}

	public DonViTinh update(DonViTinh dvt) {
		return donViTinhRepository.save(dvt);
	}

	public void delete(int ID) {
		donViTinhRepository.deleteById(ID);
	}
}
