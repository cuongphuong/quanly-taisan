package tpm.qlts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.ThietBi;
import tpm.qlts.repositorys.ThietBiRepository;

@Service("ThietBiServices")
@Primary
public class ThietBiServices {
	@Autowired
	private ThietBiRepository thietBiRepository;

	public ThietBi update(ThietBi tb) {
		return thietBiRepository.save(tb);
	}

	public void delete(Long id) {
		thietBiRepository.deleteById(id);
	}

	public List<ThietBi> findAll(){
		return (List<ThietBi>) thietBiRepository.findAll();
	}

	public Optional<ThietBi> findById(Long id) {
		return thietBiRepository.findById(id);
	}

	public long getMaxIDThietBi() {
		long recive = thietBiRepository.getMaxIDThietBi();
		return recive + 1;
	}

	public List<ThietBi> update(Iterable<ThietBi> tbs) {
		return thietBiRepository.saveAll(tbs);
	}
	
	public List<ThietBi> getAllThietBiByID(String maPhongBan, String maLoai)
	{
		return thietBiRepository.getAllThietBiByID(maPhongBan, maLoai);
	}
	
	public List<ThietBi> getAllByIdthietBiPhongBan(String id){
		return thietBiRepository.getAllByIdthietBiPhongBan(id);
	}
}
