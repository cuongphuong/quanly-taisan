package tpm.qlts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.LoaiTB;
import tpm.qlts.repositorys.LoaiTBRepository;

@Service("loaiTBService")
public class LoaiTBService {
	@Autowired
	public LoaiTBRepository loaiTBRepository;
	
	public void deleteById(String id)
	{
		loaiTBRepository.deleteById(id);
	}
	
	public List<LoaiTB> findAll(){
		return (List<LoaiTB>) loaiTBRepository.findAll();
	}
	
	public Optional<LoaiTB> findById(String id)
	{
		return loaiTBRepository.findById(id);
	}
	
	public LoaiTB save(LoaiTB loaiTB) {
		return loaiTBRepository.save(loaiTB);
	}
	
	public boolean existsById(String id) {
		return loaiTBRepository.existsById(id);
	}
	
	public List<LoaiTB> getAllByIdPhongBan(String id)
	{
		return loaiTBRepository.getAllByIdPhongBan(id);
	}
	
	public List<LoaiTB> getAllThietBimaLoai(String maPhongBan, String maLoai)
	{
		return loaiTBRepository.getAllThietBimaLoai(maPhongBan, maLoai); 
	}
	
}

