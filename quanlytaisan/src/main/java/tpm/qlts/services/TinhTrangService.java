package tpm.qlts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpm.qlts.entitys.TinhTrang;
import tpm.qlts.repositorys.TinhTrangRepository;

@Service("tinhTrangService")
public class TinhTrangService {
	@Autowired
	private TinhTrangRepository tinhTrangRepository;
	
	public void deleteById(String id)
	{
		tinhTrangRepository.deleteById(id);
	}
	
	public List<TinhTrang> findAll()
	{
		return (List<TinhTrang>) tinhTrangRepository.findAll();
	}
	
	public Optional<TinhTrang> findById(String id)
	{
		return tinhTrangRepository.findById(id);
	}
	
	public TinhTrang update(TinhTrang tinhTrang)
	{
		return tinhTrangRepository.save(tinhTrang);
	}
	
	public boolean exitstsById(String id)
	{
		return tinhTrangRepository.existsById(id);
	}
	
	public String getTenTinhTrangByIDThietBi(long idThietBi) {
		return tinhTrangRepository.getTenTinhTrangByIDThietBi(idThietBi);
	}
}
