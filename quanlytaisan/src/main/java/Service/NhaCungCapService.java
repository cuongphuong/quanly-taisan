package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.NhaCungCapRepository;
import tpm.qlts.entitys.NhaCungCap;

@Service("nhaCungCapService")
public class NhaCungCapService {

	@Autowired
	private NhaCungCapRepository nhaCungCapRepository;

	public Iterable<NhaCungCap> findAll() {
		return nhaCungCapRepository.findAll();
	}

	public Optional<NhaCungCap> findByID(String ID) {
		return nhaCungCapRepository.findById(ID);
	}

	public NhaCungCap update(NhaCungCap ncc) {
		return nhaCungCapRepository.save(ncc);
	}

	public void delete(String ID) {
		nhaCungCapRepository.deleteById(ID);
	}
}
