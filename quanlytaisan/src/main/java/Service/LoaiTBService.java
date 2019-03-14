package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.LoaiTBRepository;
import tpm.qlts.entitys.LoaiTB;

@Service("loaiTBService")
public class LoaiTBService {
	@Autowired
	private LoaiTBRepository loaiTBRepository;

	public Iterable<LoaiTB> findAll() {
		return loaiTBRepository.findAll();
	}

	public Optional<LoaiTB> findByID(String ID) {
		return loaiTBRepository.findById(ID);
	}

	public LoaiTB update(LoaiTB ltb) {
		return loaiTBRepository.save(ltb);
	}

	public void delete(String ID) {
		loaiTBRepository.deleteById(ID);
	}

}
