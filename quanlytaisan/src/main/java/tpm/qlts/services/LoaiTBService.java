package tpm.qlts.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.LoaiTB;
import tpm.qlts.repositorys.LoaiThietBiRepository;
@Service("loaiTBService")
public class LoaiTBService {
	
	@Autowired
	private LoaiThietBiRepository loaiThietBiRepository;
	
	public List<LoaiTB> findAll(){
		return (List<LoaiTB>) loaiThietBiRepository.findAll();
	}
	
	public List<LoaiTB> getloaicha()
	{
		return (List<LoaiTB>) loaiThietBiRepository.getLoaitbcha();
	}
	
	public LoaiTB update(LoaiTB ltt)
	{
		return loaiThietBiRepository.save(ltt);
	}
	
	public boolean exitbyId(String id) {
		return loaiThietBiRepository.existsById(id);
	}
	
	public List<LoaiTB> gettenloaibyloaicha(String id)
	{
		return loaiThietBiRepository.gettbbymaloai(id);
	}
	
	public void deletebyId(String id) {
		loaiThietBiRepository.deleteById(id);
	}
	
}
