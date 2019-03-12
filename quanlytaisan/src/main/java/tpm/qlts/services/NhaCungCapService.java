package tpm.qlts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.NhaCungCap;
import tpm.qlts.repositorys.NhaCungCapRepository;

@Service("nhaCungCapService")
public class NhaCungCapService {
	@Autowired
	private NhaCungCapRepository nhaCungCapRepository;
	
	public Iterable<NhaCungCap> findAll() {
		return nhaCungCapRepository.findAll();
	}
	
	public Optional<NhaCungCap> findByID() {
		return nhaCungCapRepository.findById("DT");
	}
	
	public NhaCungCap capNhat(NhaCungCap ncc) {
		return nhaCungCapRepository.save(ncc);
	}
	
	public void delete() {
		nhaCungCapRepository.deleteById("AB");
	}
}
