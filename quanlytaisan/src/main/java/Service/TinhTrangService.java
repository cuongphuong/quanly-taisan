package Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.TinhTrangRepository;
import tpm.qlts.entitys.TinhTrang;

@Service("tinhTrangService")
public class TinhTrangService {
	@Autowired
	private TinhTrangRepository tinhTrangRepository;

	public Iterable<TinhTrang> finAll() {
		return tinhTrangRepository.findAll();
	}

	public Optional<TinhTrang> findByID(String ID) {
		return tinhTrangRepository.findById(ID);
	}

	public TinhTrang update(TinhTrang tt) {
		return tinhTrangRepository.save(tt);
	}

	public void delete(String ID) {
		tinhTrangRepository.deleteById(ID);
	}
}
