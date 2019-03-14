package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.NhanVienRepository;
import tpm.qlts.entitys.NhanVien;

@Service("nhanVienService")
public class NhanVienService {
	@Autowired
	private NhanVienRepository nhanVienRepository;

	public Iterable<NhanVien> findAll() {
		return nhanVienRepository.findAll();
	}

	public Optional<NhanVien> findByID(String ID) {
		return nhanVienRepository.findById(ID);
	}

	public NhanVien update(NhanVien nv) {
		return nhanVienRepository.save(nv);
	}

	public void delete(String ID) {
		nhanVienRepository.deleteById(ID);
	}
}
